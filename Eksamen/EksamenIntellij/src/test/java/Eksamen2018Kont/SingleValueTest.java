package Eksamen2018Kont;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SingleValueTest {
    private Collection<Integer> diceValues1 = new ArrayList<Integer>();
    private Collection<Integer> diceValues2 = new ArrayList<Integer>();
    SingleValue singleValue1;
    DiceScore diceScore1;
    Dice dice1;
    int value=1;
    int score=50;

    @Before
    public void setUp(){
        Collections.addAll(diceValues1,1,1,1,2,2,3,4);
        Collections.addAll(diceValues2,1,1,1,4);
    }

    //Remember that the singleValue1 obj creates a new Dice with om winner values!
    @Test
    public void getScoreFromSingleValue_comparingToDice1AndExpectingFalse(){
        singleValue1 = new SingleValue(this.value,this.score);
        dice1 = new Dice(diceValues1);
        diceScore1 = new DiceScore(this.score,dice1);
        Assert.assertEquals(false,dice1.isSame(singleValue1.getScore(dice1).getDice()));
    }




}
