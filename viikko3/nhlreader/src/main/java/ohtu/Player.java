
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private String team;
    private int assists;
    private int goals;

    public void setName(String name) {
        this.name = name;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public void setAssists(int assists) {
        this.assists = assists;
    }

    public String getName() {
        return name;
    }
    
    public String getNationality() {
        return nationality;
    }
    

    @Override
    public String toString() {
        return name + " team " + team + " goals " + goals + " assists " + assists;
    }
      
}
