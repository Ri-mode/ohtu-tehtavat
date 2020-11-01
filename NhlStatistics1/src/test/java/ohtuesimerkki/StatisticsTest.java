/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author antti
 */
public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    @Test
    public void constructorSearchGivesPlayer() {
        assertEquals("Kurri", stats.search("Kurri").getName());
    }
    
    @Test
    public void searchGivesNull() {
        assertEquals(null, stats.search("Tikkanen"));
    }
    
    @Test
    public void teamGivesPlayer() {
        Player kurri = new Player("Kurri",   "EDM", 37, 53);
        assertEquals(kurri.getName(), stats.team("EDM").get(1).getName());
    }
    
    @Test
    public void topScoreresGivesPlayer() {
        Player the99 = new Player("Gretzky", "EDM", 35, 89);
        assertEquals(the99.getPoints(), stats.topScorers(1).get(0).getPoints());    
    }
    
}
