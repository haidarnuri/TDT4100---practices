package Eksamen2018Kont;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Dice implements Iterable<Integer> {

    private final int[] valueCounters = new int[6];

    public Dice(Iterator<Integer> dieValues) {
        while (dieValues.hasNext()) {
            int NextValue = dieValues.next();
            valueCounters[NextValue-1]++;
        }
    }

    public Dice(Iterable<Integer> dieValues) {
        this(dieValues.iterator());
    }

    public int getDieCount() {
        int count = 0;
        for (int val : valueCounters) {
            count += val;
        }
        return count;
    }


    public int getDieValue(int dieNum) throws IllegalArgumentException {
        if (dieNum < 1 || dieNum > getDieCount()) {
            throw new IllegalArgumentException("Values is either too high or low.");
        }
        int dieCount = 0;
        int dieVal = 0;

        for (int value : valueCounters){
            dieCount += value;
            dieVal++;
            if (dieCount >= dieNum) {
                break;
            }
        }
        return dieVal;
    }


    public int getValueCount(int value) {
        if (value < 1 || value > 6) {
            throw new IllegalArgumentException("The value must be from 1 to 6.");
        }
        return valueCounters[value - 1];
    }


    public boolean contains(Dice dice) {
        Collection<Integer> currentDiceValuesCollection = new ArrayList<Integer>();
        Collection<Integer> diceValuesCollection = new ArrayList<Integer>();
        return true;


    }


    public boolean isSame(Dice dice) {
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}