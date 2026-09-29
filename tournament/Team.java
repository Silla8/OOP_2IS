
package tournament;


public class Team {
    private String name;
    private String country;
    
    public Team(String _name, String _country)
    {
        this.name = _name;
        this.country = _country;
    }
    
    public String toString()
    {
        return this.name+" from "+this.country;
    }
}
