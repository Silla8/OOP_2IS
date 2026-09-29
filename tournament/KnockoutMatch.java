
package tournament;

import static java.lang.Math.abs;
import java.util.Random;


public class KnockoutMatch extends Match {
    
    private int penaltyA;
    private int penaltyB;
    
    public KnockoutMatch(Team A, Team B)
    {
        super(A,B);
        this.penaltyA = 0;
        this.penaltyB = 0;
    }
    
    private Team penalties()
    {
        Random rng = new Random();
        for(int i = 1; i <= 5; i++)
        {
            if (rng.nextBoolean())
                this.penaltyA+=1;
            if (rng.nextBoolean())
                this.penaltyB+=1;
            if (abs(this.penaltyA-this.penaltyB)> 5 - i)
                break;
        }
        while (this.penaltyA == this.penaltyB)
        {
            if (rng.nextBoolean())
                this.penaltyA+=1;
            if (rng.nextBoolean())
                this.penaltyB+=1;
        }
        
        if (this.penaltyA > this.penaltyB)
            return getTeamA();
        else
            return getTeamB();
    }
    
    @Override
    public Team winner()
    {
        Team t = super.winner();
        if (t == null)
            return penalties();
        return t;
    }
    
    @Override
    public String toString()
    {
        String str = this.getTeamA()+" vs. "+this.getTeamB()+"\n"+this.getScoreA()+"-"+getScoreB();
        if (this.getScoreA()==this.getScoreB())
            str+="\nPenalties: "+this.penaltyA+"-"+this.penaltyB;
        return str;
    }
}
