
package tournament;

import java.util.Random;


public class Match {
    private Team teamA;
    private Team teamB;
    private int scoreA;
    private int scoreB;
    
    public Match(Team _teamA, Team _teamB)
    {
        this.teamA = _teamA;
        this.teamB = _teamB;
        this.scoreA = 0;
        this.scoreB = 0;
    }
    
    private void playMatch()
    {
        Random rng = new Random();
        this.scoreA = rng.nextInt(0, 8);
        this.scoreB = rng.nextInt(0, 8);
    }
    
    
    public Team winner()
    {
        playMatch();
        if (scoreA > scoreB)
            return teamA;
        else if (scoreB > scoreA)
            return teamB;
        else 
            return null;
    }
    
    public String toString()
    {
       return this.teamA+" vs. "+this.teamB+" :\n"+this.scoreA+"-"+this.scoreB;
            
    }
    
    public Team getTeamA()
    {
        return this.teamA;
    }
    
    public Team getTeamB()
    {
        return this.teamB;
    }
    
    public int getScoreA()
    {
        return this.scoreA;
    }
    
    public int getScoreB()
    {
        return this.scoreB;
    }
}
