package stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Joiner {

	/**
	 * Joins the strings together, where all elements but the two last are separated by mainSeparator, and
	 * the two last are separated by lastSeparator. If lastSeparator is null, mainSeparator is used between all elements.
	 * E.g. if you join the strings "one", "two", "three" with mainSeparator as ", " and lastSeparator as " and ",
	 * you should get "one, to and three".
	 * If strings contains only one element, that element is returned, if it contains no elements, the empty string is returned.
	 * @param strings the strings to join
	 * @param mainSeparator the separator used between all but the two last elements
	 * @param lastSeparator the separator used between the last two elements
	 * @return strings joined with the provided separators
	 */
	public static String join(final Iterator<String> strings, final String mainSeparator, final String lastSeparator) {
		int count=0;
		String resultString = null;
		
		//Prøver med denne løkka og telle antall elementer i iteratoren. 
		while(strings.hasNext()) {
			count++;
			strings.next();
		}
		
		int secondCounter=0;
		while(strings.hasNext()) {
			secondCounter++;
			resultString+=strings.next();
			//Når den kommer til nest siste ledd så skal den legge til en lastSepetor. 
			if(secondCounter==count-1) {
				resultString+=lastSeparator;
			}else {
				resultString+=mainSeparator;
			}
		}
		return resultString;
	}

	// TODO: necessary declarations

	private String mainSeparator;
	private String lastSeparator;
	private String seperator;
	
	/**
	 * Initialises this Joiner with the provided separators.
	 * @param mainSeparator the separator to use between all but the last two elements
	 * @param lastSeparator the separator to use between the last two elements
	 */
	public Joiner(final String mainSeparator, final String lastSeparator) {
		this.mainSeparator=mainSeparator;
		this.lastSeparator=lastSeparator;
	}

	/**
	 * Initialises this Joiner with the provided separator.
	 * @param separator the separator to use between all elements
	 */
	public Joiner(final String separator) {
		this.seperator=seperator;
	}

	/**
	 * Joins strings with the provided mainSeparator and lastSeparator
	 * @param strings the strings to join
	 * @return the joined strings
	 */
	
	//Bruker join metoden som jeg har laget helt øverst. 
	public String join(final Iterator<String> strings) {
		return join(strings, this.mainSeparator, this.lastSeparator);
	}

	/**
	 * Joins strings with the provided mainSeparator and lastSeparator
	 * @param strings the strings to join
	 * @return the joined strings
	 */
	
	public String join(final Iterable<String> strings) {
		return join(strings.iterator());
	}

	/**
	 * Joins strings with the provided mainSeparator and lastSeparator
	 * @param strings the strings to join
	 * @return the joined strings
	 */
	public String join(final String... strings) {
		Collection<String> listOfStrings = new ArrayList<>();
		listOfStrings = Arrays.asList(strings);
		return join(listOfStrings);
	}

}
