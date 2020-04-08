package Eksamen2018Kont;

import java.util.Collection;

public class Nothing implements DiceScorer{

    private int numDice;
    private int score;
    private Collection<DiceScorer> diceScorers;
    private DiceScore diceScore = null;

    public Nothing(int numDice, int score, Collection<DiceScorer> diceScorers) {
        this.numDice = numDice;
        this.score = score;
        this.diceScorers = diceScorers;
    }

    @Override
    public DiceScore getScore(Dice dice) {
        boolean isRuleNotApplied = true;
            for (DiceScorer diceScorerRule : diceScorers) {
                if (diceScorerRule.getScore(dice) != null) {
                    isRuleNotApplied = false;
                }
            }
        if(isRuleNotApplied && dice.getDieCount()>=this.numDice){
            this.diceScore = new DiceScore(this.score,dice);
        }
        return diceScore;
    }
}
