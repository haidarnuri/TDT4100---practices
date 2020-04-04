package Eksamen2018Kont;

import java.util.Iterator;

public class DiceIterator implements Iterator<Integer> {

    private Dice dice;
    private int counter=0;

    public DiceIterator(Dice dice){
        this.dice=dice;
    }

    @Override
    public boolean hasNext() {
       return counter<dice.valueCounters.length;
    }

    @Override
    public Integer next() {
        return dice.valueCounters[counter++];
    }
}
