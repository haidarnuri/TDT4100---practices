package Eksamen2018Kont;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiceTest {
    private Collection<Integer> diceValues1 = new ArrayList<Integer>();


    @Before
    public void setUp(){
    Collections.addAll(diceValues1,1,1,1,2,2,3,4);
    }

    @Test
    public void GettingDieCountTest_expectingAValue(){
        Dice dice = new Dice(diceValues1);
        Assert.assertEquals(7,dice.getDieCount());
    }

    @Test
    public void GettingDieValue_expectingASpesificDieValue() throws IllegalAccessException {
        Dice dice = new Dice(diceValues1);
        Assert.assertEquals(2,dice.getDieValue(5));
    }

    @Test
    public void GettingDieValue_expectingAExceptionWhenAddingIllegalValue() {
        Dice dice = new Dice(diceValues1);
        try{
            dice.getDieValue(17);
            throw new RuntimeException("Should throw an exception when a too high value is called");
        }catch (IllegalArgumentException e){

        }
    }

    @Test
    public void TestingGetValueCount_expectingToCountASpesificDiceValue() {
        Dice dice = new Dice(diceValues1);
        Assert.assertEquals(2,dice.getValueCount(2));
    }

    @Test
    public void TestingGetValueCount_AddingIllegalValue_expectingException() {
        Dice dice = new Dice(diceValues1);
        try{
            dice.getValueCount(7);
            throw new RuntimeException("Should throw an exception when a too high value is called");
        }catch (IllegalArgumentException e){

        }
    }


}
