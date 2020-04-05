package Eksamen2018Kont;

import java.util.ArrayList;
import java.util.Collection;

public class SingleValue implements DiceScorer {

    private int value;
    private int score;
    private DiceScore diceScore = null;
    private Collection<Integer> newArrayToDice = new ArrayList<Integer>();

    public SingleValue(int value, int score) {
        this.value=value;
        this.score=score;
    }

    @Override
    public DiceScore getScore(Dice dice) {
        int getDieValue = dice.getDieValue(this.value);
        if(getDieValue>0){
            newArrayToDice.add(getDieValue);
            this.diceScore=new DiceScore(this.score,new Dice(newArrayToDice));
        }
        return diceScore;
    }
}
