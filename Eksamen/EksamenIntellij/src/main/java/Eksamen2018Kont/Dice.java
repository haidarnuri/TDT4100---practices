package Eksamen2018Kont;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Dice implements Iterable<Integer> {

    protected final int[] valueCounters = new int[6];

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
    /**
     * @param dice
     * @return true if all die values in the Dice argument appear in this Dice
     */
    public boolean contains(Dice dice) {
        boolean contains = true;
        for(int i=1;i<7;i++){
            if(dice.getValueCount(i)!=0&&getValueCount(i)!=dice.getValueCount(i)){
                    contains = false;
            }
        }
        return contains;
    }


    /**
     * @param dice
     * @return true if this Dice and the one provided have exactly the same die values
     */
    public boolean isSame(Dice dice) {
        boolean contains = true;
        for(int i=1;i<7;i++){
            if(getValueCount(i)!=dice.getValueCount(i)){
                contains = false;
                break;
            }
        }
        return contains;
    }

    public Dice add(Dice dice) {
        int[] arrayTemp = new int[6];
        Collection<Integer> newDiceList=new ArrayList<Integer>();
        for(int i=1;i<7;i++){
            arrayTemp[i-1]=getValueCount(i)+dice.getValueCount(i);
        }
        int count=0;
        for(int i:arrayTemp){
            count++;
            while(i>0){
                newDiceList.add(count);
                i--;
            }
        }
        return new Dice(newDiceList);
    }

    public Dice remove(Dice dice) {
        int[] arrayTemp = new int[6];
        Collection<Integer> newDiceList=new ArrayList<Integer>();
        for(int i=1;i<7;i++){
            int diff = getValueCount(i)-dice.getValueCount(i);
            if(diff>0){
                arrayTemp[i-1]=diff;
            }
        }
        int count=0;
        for(int i:arrayTemp){
            count++;
            while(i>0){
                newDiceList.add(count);
                i--;
            }
        }
        return new Dice(newDiceList);
    }


    @Override
    public Iterator<Integer> iterator() {
        return new DiceIterator(this);
    }

    @Override
    public String toString() {
        int count=0;
        while(count<7){
            count++;
            if(getValueCount(count)>0){
                return "Your object contains value " +count;
            }
        }
        return null;
    }

}