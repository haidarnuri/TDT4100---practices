
import java.lan.Math;

public class ThreeOrMoreOfAKind implements DiceScorer{
	@Override
	Dice getScore(Dice dice){
		int intToFind = 6;
		int count;
		int tempScore;
		int score = null;
		int = mostCommonDiceTemp=0;
		while(intToFind>0){
			count = 0;
			for(int diceVal:dice){
				if(diceVal==intToFind){
					count++;
				}		
			}
			if(count==3 || count==4){
				tempScore = 100*intToFind;
			}
			if(count>4){
				tempScore =100*intToFind*math.pow(intToFind,count-4);
			}
			if(tempScore>=score && dice.getValueCount(diceVal)>mostCommonDiceTemp)
				score = tempScore;
				mostCommonDiceTemp = dice.getDieValue(diceVal);
			}
			intToFind--;
		}
		if(count<3){
			return null;
		}
		else{
				return dice.setScore(score);
		}
		
		
		
	}
		
					
		
	
		
		
		
		
		
		
	}		
		
	


	

}
