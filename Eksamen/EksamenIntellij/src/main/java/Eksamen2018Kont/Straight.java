package Eksamen2018Kont;

import java.util.ArrayList;
import java.util.Collection;

public class Straight implements DiceScorer {


    private final int score;
    private DiceScore diceScore;
    private Collection<Integer> tempArray=new ArrayList<Integer>();


    public Straight(int score) {
        this.score = score;
    }

    @Override
    public DiceScore getScore(Dice dice) {
        int scoreTemp;
        if(dice.getDieCount()>6){
            this.diceScore=null;
        }
        else if(dice.getDieCount()==1){
            this.diceScore=new DiceScore(this.score,dice);
        }
        else{
            boolean isStraight=true;
            for(int i=1;i<7;i++){
                if(dice.getValueCount(i)!=1){
                    isStraight=false;
                }
            }
            if(isStraight){
                this.diceScore=new DiceScore(this.score,dice);
            }
        }
        return this.diceScore;

    }
}
