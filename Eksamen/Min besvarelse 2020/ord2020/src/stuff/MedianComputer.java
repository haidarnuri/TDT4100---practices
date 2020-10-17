package stuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class MedianComputer {
	
	/*
	 * Formel for median er å hente ut (n+1)/2 der n er antall elementer
	 * i lista. Det er det jeg prøver å bruke etter å ha sortert lista først. 
	 */
	public static double compute(List<Integer> numbersToComputeMedian) {
		List<Integer> sortedList = new ArrayList<>();
		numbersToComputeMedian.stream().sorted().forEach(t->sortedList.add(t));
		int size = sortedList.size()+1;
		
		/*
		 * Hvis det er oddetall elementer så henter den miderste verdiene
		 * Hvis det er partall elementer så henter den snittet av de to midterste
		 */
		
		//Size er størrelsen +1 derfor må det bli kongruent med null her. 
		if(size%2==0) {
			return sortedList.get(((size+1)/2)-1);
		}else {
			int value1 = sortedList.get(((size+1)/2)-2);
			int value2 = sortedList.get(((size+1)/2)-1);
			double average = (value1+value2)/2.0;
			return average;
		}
			
		
	}

}
