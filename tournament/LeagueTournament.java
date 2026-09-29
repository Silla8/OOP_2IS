
package tournament;

import java.util.ArrayList;


public class LeagueTournament extends Tournament {

    private ArrayList<Integer> points;
    
    public LeagueTournament(String _name)
    {
        super(_name);
        this.points = new ArrayList<>();
    }
    
    
    @Override
    public void inviteTeam(Team _team)
    {
        super.inviteTeam(_team);
        this.points.add(0);
    }
    
    @Override
    public void playMatches()
    {
        // Every team plays against every other team
        for(int i = 0; i < invited.size()-1; i++)
            for(int j = i+1; j < invited.size(); j++)
            {
                Match m = new Match(invited.get(i), invited.get(j));
                Team t = m.winner();
                if (t == null)
                {
                    points.set(i, points.get(i)+1);
                    points.set(j, points.get(j)+1);
                }
                else if (t==invited.get(i))
                    points.set(i, points.get(i)+3);
                else
                    points.set(j, points.get(j)+3);              
            }
    }
    
    @Override
    public void winner()
    {
        int maxpoints = 0;
        Team t = null;
        for(int i = 0; i < points.size(); i++)
            if (points.get(i) > maxpoints)
            {
                maxpoints = points.get(i);
                t = invited.get(i);
            }
        this.winner = t;
    }
    
   
 
}







