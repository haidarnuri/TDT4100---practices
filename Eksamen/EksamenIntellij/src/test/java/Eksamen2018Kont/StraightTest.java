package Eksamen2018Kont;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StraightTest {
    private Collection<Integer> diceValues1 = new ArrayList<Integer>();
    private Collection<Integer> diceValues2 = new ArrayList<Integer>();
    private Collection<Integer> diceValues3 = new ArrayList<Integer>();
    Straight straightValue;
    DiceScore diceScore1;
    Dice dice1;
    int value=1;
    int score=50;

    @Before
    public void setUp(){
        Collections.addAll(diceValues1,1,1,1,2,2,3,4);
        Collections.addAll(diceValues2,1);
        Collections.addAll(diceValues3,1,2,3,4,5,6);
    }

    @Test
    public void StraightGetScore_ExpectingNull(){
        Dice dice = new Dice(diceValues1);
        straightValue = new Straight(this.score);
        Assert.assertEquals(null,straightValue.getScore(dice));
    }
    @Test
    public void StraightGetScore_ExpectingTrueWhenAddingArrayWithOneElement(){
        Dice dice = new Dice(diceValues2);
        straightValue = new Straight(this.score);
        diceScore1 = new DiceScore(this.score,dice);
        Assert.assertEquals(diceScore1.getScore(),straightValue.getScore(dice).getScore());
    }
    @Test
    public void StraightGetScore_ExpectingTrueWhenAddingStraight(){
        Dice dice = new Dice(diceValues3);
        straightValue = new Straight(this.score);
        diceScore1 = new DiceScore(this.score,dice);
        Assert.assertEquals(true,straightValue.getScore(dice).getDice().isSame(dice));
    }



}
