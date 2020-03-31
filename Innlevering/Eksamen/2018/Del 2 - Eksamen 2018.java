


public class ThreeOrMoreOfAKind implements DiceScorer{
	
	@Override
	Dice getScore(Dice dice){
		int intToFind = 1;
		int count;
		while(intToFind<7){
			count = 0;
			for(int diceVal:dice){
				if(diceVal==intToFind){
					count++;
				}		
			}
			intToFind++;
		}
		if(count<3){
			return null;
		}
		
	}		
		
	


	

}
