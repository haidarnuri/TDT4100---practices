//Del 1

public class Dice implements Iterable<Integer> {
    /**
     * Counters for each possible die value.
     * The counter at index i (0-5) is the counter for the die value i+1 (1-6).
     * I.e. the value at index 2 is the counter for die value 3.
     */
    private final int[] valueCounters = new int[6];
  
    /**
     * Initializes this Dice with the values in dieValues.
     * @param dieValues sequence of die values, not counter values
     */
    public Dice(Iterator<Integer> dieValues) {
	   while(dieValues.hasNext()){
				int NextValue = dieValues.next();
					valueCounters[NextValue-1] ++;
			}
    }
 
    /**
     * Initializes this Dice with the values in dieValues.
     * @param dieValues sequence of die values, not counter values
     */
    public Dice(Iterable<Integer> dieValues) {
        this(dieValues.iterator());
    }
	

    @Override
    public Iterator<Integer> iterator() {
        return new DiceIterator(this);
    }
  
    /**
     * @return the number of die values
     */
    public int getDieCount() {
		int count =0;
		for(int val:dieValues){
				count+=val;
		}
		return count;
    }
  
    /**
     * Die values are considered ordered, with the smallest die values
     * at the lowest index. The value at a specific index
     * must be computed from the counters in valueCounters.
     * @param dieNum
     * @return the value of die number dieNum
     * @throws an appropriate exception, if dieNum is out of range
     */
    public int getDieValue(int dieNum) {
		if(dieNum <1 || dieNum>getDieCount()){
				throw IllegalAccessException("Values must be from 1 to 6.");
		}
		int dieCount=0;
		int dieVal = 0;
	
		for(int value:DieValues)
			dieCount+=value;
			dieVal++;
			if(dieCount>=dieNum){
				return dieVal;
				break;
			}
    }
  
    /**
     * @param value
     * @return the number of dice with the provided value
     */
	public int getValueCount(int value) {
        if(value<1 || value>6){
			throw new IllegalArgumentException("The value must be from 1 to 6.");
		}
		return dieValues[value-1];
    }
 
    /**
     * @param dice
     * @return true if all die values in the Dice argument appear in this Dice
     */
    public boolean contains(Dice dice) {
        boolean contains = true;
		for(int i=0;i<6;i++){
			if(dice.getValueCount(i)!=getDieValue(i)){
				contains=false;
			}
		}
		return contains;
    }
  
    /**
     * @param dice
     * @return true if this Dice and the one provided have exactly the same die values
     */
    public boolean isSame(Dice dice) {
        ???
    }
  
    /**
     * @param dice a Dice object
     * @return a new Dice instance with the all the die values in
     * this Dice and the Dice argument combined
     */
    public Dice add(Dice dice) {
        ???
    }
  
    /**
     * @param dice
     * @return a new Dice instance with the die values from this Dice, but
     * without those from the Dice argument
     */
    public Dice remove(Dice dice) {
        ???
    }
}