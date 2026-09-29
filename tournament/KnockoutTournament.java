
package tournament;

import java.util.ArrayList;
import java.util.Random;


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
        	
        	System.out.println("The number of invited teams should be of power of two.");
        	System.exit(1);
        	
        }
        
        brackets.addAll(this.shuffleTeams(invited));
        
        
        this.winner = recursiveknockout(brackets);
       
        
        
    }

    private Team recursiveknockout(ArrayList<Team> teams) {
    	
    	if(teams.size()==1) return teams.get(0);
    	
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
    		
    		
    	
    	
    	return recursiveknockout(tempBrackets);
    	
    }
    	
    @Override
    public void winner() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    private ArrayList<Team> shuffleTeams(ArrayList<Team> teams){
    	
    	int i=0, m=0, n=0;
    	while(i<teams.size()*5) {
    		
    		Random rng = new Random();
    		
    		while(m ==  n) {
    			
    			m = rng.nextInt(teams.size());
        		
        		n = rng.nextInt(teams.size());
    		}
    		
    		
    	
    		Team t = teams.get(m);
    		
    		teams.set(m, teams.get(n));
    		
    		teams.set(n, t);
    		
    		m = n = 0;
    		i++;
    	
    		
    	}
    	
    	return teams;
    }
}
