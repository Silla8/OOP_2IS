
package tournament;

import java.util.ArrayList;

public abstract class Tournament {
    protected ArrayList<Team> invited;
    private String name;
    protected Team winner;

    public Tournament(String _name)
    {
        this.name = _name;
        this.invited = new ArrayList<>();
        this.winner = null;
    }
    
    public void inviteTeam(Team _team)
    {
        this.invited.add(_team);
    }

    public abstract void playMatches();
    
    public abstract void winner();
    
    public Team getWinner()
    {
        return this.winner;
    }    
    
    
    public String toString() {
    	return "Welcome to "+this.name+" tournament ! \nThis Tournament consists of "+this.invited.size()+" teams. Let's have fun together !";
    }
}
