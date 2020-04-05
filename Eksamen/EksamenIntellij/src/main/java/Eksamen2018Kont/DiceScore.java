package Eksamen2018Kont;

import java.util.HashMap;
import java.util.Map;

public class DiceScore {
    private Map<Dice,Integer> scoreBoard = new HashMap<Dice,Integer>();

    public DiceScore(final int score, final Dice scoringDice) {
        scoreBoard.put(scoringDice,score);
    }

    public Dice getSpecificScoringDice(Dice dice){
         for(Dice diceCompare:scoreBoard.keySet()){
             if(diceCompare.equals(dice)){
                 return diceCompare;
             }
         }
         return null;
    }

    public int getSpecificScore(Dice diceCheckScore){
        return scoreBoard.get(diceCheckScore);
    }

    public Dice getSpecificDice(int score){
        for(Dice dice:scoreBoard.keySet()){
            if(scoreBoard.get(dice)==score){
                return dice;
            }
        }
        return null;
    }


}
