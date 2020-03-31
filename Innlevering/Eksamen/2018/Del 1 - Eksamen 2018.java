
//DEL 1
public class Dice implements Iterable<Integer>{

    private int dieCount;
    private int score;
	private Collection<Integer> dieValues = new ArrayList<Integer>();

	//Oppgave 1 a
    public static Collection<Integer> randomDieValues(int dieCount){
        Collection<Integer> listOfDice = new ArrayList<>();
        for(int i=0;i<dieCount;i++){
            int randomNumber = (int)Math.random()*6 + 1;
            listOfDice.add(randomNumber);
        }
        return listOfDice;
    }
	
	public Dice(Collection<Integer> dieValues, int score){
		setDieValues(dieValues);
		this.score=score;
	}
	
	public Dice(int dieCount){
		setDieValues(randomDieValues(dieCount));
	}
	
	public Dice(Dice dice, int score){
		setDieValues(dice.getDieValues);
		this.score=score;
	}
	
	
	private void setDieValues(Collection<Integer> dieValues){
		for(Integer dieValue:dieValues){
			if(dieValue<0 && dieValues>6){
				throw new IllegalArgumentException("This is an invalid die value");
			}
		}
		this.dieValues = dieValues;
	}
	
	public Collection<Integer> getDieValues(){
		return this.dieValues;
	}
	//oppgave 1b
	
	public void generateStringValueOfDice(){
		String strValueOfDice = new String();
		if(getScore() == -1){
			strValueOfDice = String.valueOf(getDieValues);
		}
		else{
			strValueOfDice = String.valueOf(getDieValues)+"="+String.valueOf(getScore());
		}	
	}
	
	public static Dice valueOf(String s){
		Collection<Integer> newDiceValues = new ArrayList<Integer>();
		Collection<Integer> validDieValues = generatingValidDieValues();
		
		String firstPart = String.subString(0,s.indexOf("="));
		String secondPart = String.subString(s.indexOf("=")+1);
		
		for(char val: firstPart.toCharArray()){
			for(Integer validVal:validDieValues){
				if(Integer.parseInt(val).equals(validVal)){
					newDiceValues.add(Integer.parseInt(val));
				}
			}
		}
		int score = Integer.valueOf(secondPart);
		Dice dice = new Dice(newDiceValues,score);
		return dice;
	}
	
	
	private Collection<Integer> generatingValidDieValues(){
		Collection<Integer> validDieValues = new ArrayList<Integer>();
		Collections.addAll(validDieValues,1,2,3,4,5,6);
		return validDieValues;
	}
	
	//oppgave 1C
    public int getDieCount() {
        return getDieValues().size();
    }
	
	public int getDieValue(int dieNum){
		return getDieValues().get(dieNum);
	}

	public int getValueCount(int value){
		int count = 0;
		for (Integer val:getDieValues()){
			if(val==value){
				count++;
			}
		}
		return count;
	}



	//Oppgave 1D
    private void setScore(int score) {
		if(score!=-1){
			this.score = score;
		}
		else{
			throw new IllegalArgumenException("This score already har a value.");
		}
	}
	
    public int getScore() {
        return this.score;
    }
	
	//Oppgave 1E
	
	@Override
	public Iterator<Integer> iterator(){
		return getDieValues.iterator();
	}
	
	//Når man implementerer denne metoden kan man iterere gjennom et dice objekt. 
	public static void main(String[] args) {
		//dette opprettet et dice objekt som inneholder en arrayList med 5 elementer, slik konstruktøren min er skrevet. 
		Dice dice = new Dice(5);
		for(int value:dice){
			.....Her kommer dieValues sin neste verdi
		}
	}
	
	//Oppgave 1F
	public boolean contains(Dice dice){
		return getDieValues().equals(dice.getDieValues());
	}
	
	public Dice add(Dice dice){
		Dice tempDice = this;
		for(int diceValue:dice){
			tempDice.getDieValues().add(diceValue);
		}
		return tempDice;
	}
	
	
	public Dice remove(Dice dice){
		Collection<Integer> tempDieList = new ArrayList<Integer>();
		for(int val:this){
			if(!dice.getDieValues().contains(val)){
				tempDieList.add(val);
			}
		}
		Dice tempDice = new Dice(tempDieList);
		return tempDice;
	}
}























































