package Eksamen2018Kont;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Straight implements DiceScorer {


    private final int score;
    private DiceScore diceScore;
    private Collection<Integer> tempArray=new ArrayList<Integer>();
    /**
     * Initializes this Straight object with the specific score.
     * @param score
     */
    public Straight(int score) {
        this.score = score;
    }

    /**
     * Checks that all die values in the provided Dice form a series of consecutive values.
     * If this is the case returns a DiceScore object with a Dice with
     * the die values contributing to the score (necessarily all of them) and
     * the corresponding score.
     */
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
