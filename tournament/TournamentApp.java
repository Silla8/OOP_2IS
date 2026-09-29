
package tournament;


public class TournamentApp {

    public static void main(String[] args) {
        // TODO code application logic here
       /* Team barcelona = new Team("Barcelona", "Spain");
        Team munich = new Team("Munich", "Germany");
        Team madrid = new Team("Madrid", "Spain");
        Team sevilla = new Team("Sevilla", "Spain");
        
        Tournament tourney = new Tournament("Germano-spanish competition");
        
        tourney.inviteTeam(barcelona);
        tourney.inviteTeam(munich);
        tourney.inviteTeam(madrid);
        tourney.inviteTeam(sevilla);
        
        tourney.playMatches();
        tourney.winner();
        
        System.out.println(tourney.getWinner());*/
       
    	Team barcelona = new Team("Barcelona", "Spain");
        Team munich = new Team("Munich", "Germany");
        Team madrid = new Team("Madrid", "Spain");
        Team sevilla = new Team("Sevilla", "Spain");
        Team milan = new Team("Sevilla", "Spain");
        Team bakou = new Team("Bakou", "Azerbaïdjan");
        Team paris = new Team("Paris", "France");
        Team toulouse = new Team("Toulouse", "France");
        
        KnockoutTournament knockey  = new KnockoutTournament("European Knockout Competition");
        

        knockey.inviteTeam(barcelona);
        knockey.inviteTeam(munich);
        knockey.inviteTeam(madrid);
        knockey.inviteTeam(sevilla);
        knockey.inviteTeam(milan);
        knockey.inviteTeam(bakou);
        knockey.inviteTeam(paris);
        knockey.inviteTeam(toulouse);
        
        
        
        knockey.playMatches();
        //knockey.winner();
        
        System.out.println(knockey.getWinner());
        
    }
    
}
