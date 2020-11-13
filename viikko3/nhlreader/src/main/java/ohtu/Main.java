package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String nationality = "FIN";

//        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );
        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter newTimeFormat = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss yyyy");
        String formattedTime = time.format(newTimeFormat);

        System.out.println("Players form " + nationality + " " + formattedTime);
        System.out.println("");

        ArrayList<Player> selectedPlayers = new ArrayList<>();
        
        for (Player player : players) {
            if (player.getNationality().equals(nationality)) {
                selectedPlayers.add(player);
            }
        }
        Collections.sort(selectedPlayers);
        Collections.reverse(selectedPlayers);
        
        for (Player player : selectedPlayers) {
            System.out.println(player);
        }
    }

}
