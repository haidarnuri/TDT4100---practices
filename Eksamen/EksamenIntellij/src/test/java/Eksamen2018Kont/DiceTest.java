package Eksamen2018Kont;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class DiceTest {
    private Collection<Integer> diceValues1 = new ArrayList<Integer>();
    private Collection<Integer> diceValues2 = new ArrayList<Integer>();
    private Collection<Integer> diceValues3 = new ArrayList<Integer>();
    private Collection<Integer> diceValues4 = new ArrayList<Integer>();
    private Collection<Integer> diceValues5 = new ArrayList<Integer>();


    @Before
    public void setUp(){
    Collections.addAll(diceValues1,1,1,1,2,2,3,4);
    Collections.addAll(diceValues2,1,1,1,4);
    Collections.addAll(diceValues3,1,1,1,2,2,2,4);
    Collections.addAll(diceValues4,1,1,1,1,1,1,2,2,3,4,4);
    Collections.addAll(diceValues5,2,2,3);
    }

    @Test
    public void GettingDieCountTest_expectingAValue(){
        Dice dice = new Dice(diceValues1);
        Assert.assertEquals(7,dice.getDieCount());
    }

    @Test
    public void GettingDieValue_expectingASpecificDieValue() throws IllegalAccessException {
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
    @Test
    public void testingContains_expectingTrue() {
        Dice dice = new Dice(diceValues1);
        Dice dice2 = new Dice(diceValues2);
        Assert.assertEquals(true,dice.contains(dice2));
    }
    @Test
    public void testingContains_expectingFalse() {
        Dice dice = new Dice(diceValues1);
        Dice dice3 = new Dice(diceValues3);
        Assert.assertEquals(false,dice.contains(dice3));
    }
    @Test
    public void testingIsSame_expectingTrue() {
        Dice dice = new Dice(diceValues1);
        Dice dice4 = new Dice(diceValues1);
        Assert.assertEquals(true,dice.isSame(dice4));
    }
    @Test
    public void testingIsSame_expectingFalse() {
        Dice dice = new Dice(diceValues1);
        Dice dice3 = new Dice(diceValues3);
        Assert.assertEquals(false,dice.isSame(dice3));
    }
    @Test
    public void testingAdd_expectingTrueWhenAddingTwoDicesAndComparingWithLastDice() {
        Dice dice = new Dice(diceValues1);
        Dice dice2 = new Dice(diceValues2);
        Dice dice3 = dice.add(dice2);
        Dice dice4 = new Dice(diceValues4);
        Assert.assertEquals(true,dice4.isSame(dice3));
    }

    @Test
    public void testingAdd_expectingFalseWhenAddingTwoDicesAndComparingWithLastDice() {
        Dice dice = new Dice(diceValues1);
        Dice dice2 = new Dice(diceValues3);
        Dice dice3 = dice.add(dice2);
        Dice dice4 = new Dice(diceValues4);
        Assert.assertEquals(false,dice4.isSame(dice3));
    }
    @Test
    public void testingRemove_expectingTrueWhenRemovingOneDiceObjectFromAnotherAndCompareToLastObject() {
        Dice dice = new Dice(diceValues1);
        Dice dice2 = new Dice(diceValues2);
        Dice dice3 = dice.remove(dice2);
        Dice dice5 = new Dice(diceValues5);
        Assert.assertEquals(true,dice5.isSame(dice3));
    }
    @Test
    public void testingIterator_expectingTrueWhenRemovingOneDiceObjectFromAnotherAndCompareToLastObject() {
        Dice dice5 = new Dice(diceValues5);
        Iterator<Integer> diceIterator = dice5.iterator();
        System.out.println(diceIterator.next());
        diceIterator.next();
        System.out.println(diceIterator.next());
        diceIterator.next();
        System.out.println(diceIterator.next());

    }


}
