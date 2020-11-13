
package ohtu;

public class Player implements Comparable<Player> {
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
    
    public int getPoints() {
        return goals + assists;
    }
    
    public int getGoals() {
        return goals;
    }
    
    @Override
    public String toString() {
        if (name.length() < 15) {
            return name + "\t  " + team + "  " + goals + " + " + assists + " = " + this.getPoints();
        }
        return name + "  " + team + "  " + goals + " + " + assists + " = " + this.getPoints();
    }
    
    public int compareTo(Player p) {
        if (this.getPoints() != p.getPoints()) {
            return this.getPoints() - p.getPoints();
        } else {
            return this.getGoals() - p.getGoals();
        }
    }
    
    
}
