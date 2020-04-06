import Eksamen2018Kont.Dice;

import java.util.HashMap;
import java.util.Map;

public class DiceScore {
    private Map<Dice,Integer> scoreBoard = new HashMap<Dice,Integer>();

    public DiceScore(final int score, final Dice scoringDice) {
        scoreBoard.put(scoringDice,score);
    }

    //Unødvendig å lage en mapping, men morsomt å prøve
    public int getScore(){
        return scoreBoard.get(getDice());
    }

    public Dice getDice(){
        Dice diceTemp = null;
        for(Dice dice:scoreBoard.keySet()){
                diceTemp=dice;
            }
        return diceTemp;
    }


}
