package Eksamen2018Kont;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiceScoreTest  {

    private Collection<Integer> diceValues1 = new ArrayList<Integer>();
    private Collection<Integer> diceValues2 = new ArrayList<Integer>();


    @Before
    public void setUp(){
        Collections.addAll(diceValues1,1,1,1,2,2,3,4);
        Collections.addAll(diceValues2,1,1,1,4);
    }

    @Test
    public void testingGetSpecificScore_getExpectedScore(){
        int score1 = 5;
        Dice dice1 = new Dice(diceValues1);
        DiceScore diceScoreDice1 = new DiceScore(score1,dice1);
        Assert.assertEquals(score1,diceScoreDice1.getSpecificScore(dice1));
    }

    @Test
    public void testingGetSpecificDice_getExpectedDice(){
        int score1 = 5;
        Dice dice1 = new Dice(diceValues1);
        DiceScore diceScoreDice1 = new DiceScore(score1,dice1);
        Assert.assertEquals(dice1,diceScoreDice1.getSpecificDice(score1));
    }
    @Test
    public void test2GetSpecificDice_getExpectedDice(){
        int score1 = 5;
        int score2 = 6;
        Dice dice1 = new Dice(diceValues1);
        DiceScore diceScoreDice1 = new DiceScore(score1,dice1);
        Assert.assertEquals(null,diceScoreDice1.getSpecificDice(score2));
    }




}
