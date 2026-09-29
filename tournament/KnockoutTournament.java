
package tournament;

import java.util.ArrayList;
import java.util.Collections;


public class KnockoutTournament extends Tournament {
    private ArrayList<Team> brackets;
    
    public KnockoutTournament(String _name)
    {
        super(_name);
        this.brackets = new ArrayList<>();
    }

    private boolean checkPowerofTwo(int nb)
    {
        if (nb<2)
            return false;
        while (nb>1)
        {
            if (nb%2!=0)
                return false;
            nb/=2;
        }
        return true;
    }
    
    @Override
    public void playMatches() {
        if(checkPowerofTwo(this.invited.size()) != true) {
        	
        	System.err.println("The number of invited teams should be of power of two.");
        	System.exit(1);
        	
        }
        
        Collections.shuffle(invited);
        brackets.addAll(invited);
        
        
        playMatches(brackets);
       
        
        
    }

    private void playMatches(ArrayList<Team> teams) {
    	
    	if(teams.size()==1) {
    		this.winner =  teams.get(0);
    		return;
    	}
    	
    	ArrayList<Team> tempBrackets = new ArrayList<Team>();
    	
    	for(int i=0; i<teams.size()-1; i+=2) {
        	
        	Team t1 = teams.get(i);
        	Team t2 = teams.get(i+1);
        	
        	KnockoutMatch km = new KnockoutMatch(t1, t2);
        	Team winner = km.winner();
        	
        	tempBrackets.add(winner);
    	}

    	//System.out.println("\n************* Round of "+teams.size()+" ****************\n");
    	
    	
    	//System.out.println(teams);
    		
    	
    	playMatches(tempBrackets);
    	
    }
    	
    @Override
    public void winner() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
