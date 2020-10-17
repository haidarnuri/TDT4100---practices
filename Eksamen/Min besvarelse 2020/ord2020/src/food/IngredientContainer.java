package food;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Generic container of ingredients.
 */
public class IngredientContainer implements Ingredients {

	// TODO: necessary declarations and constructors
	private Ingredients ingredients;
	
	//Lager en mapping som kobler matvarer med mengde. 
	private Map<String, Double> listIngredients;
	
	//Collection<String> 
	
	
	/**
	 * Initializes a new, empty IngredientContainer.
	 */
	public IngredientContainer() {
		listIngredients= new HashMap<>();
	}

	/**
	 * Initializes a new IngredientContainer.
	 * @param ingredients Initial ingredients in the container
	 */
	public IngredientContainer(Ingredients ingredients) {
		this.ingredients=ingredients;
	}

	/**
	 * Add `amount` of `ingredient` to the container.
	 *
	 * @param ingredient The name of the ingredient to add
	 * @param amount The amount of the ingredient to add
	 * @throws (fitting subclass of) RuntimeException if amount cannot be removed from this
	 */
	
	//Hva menes med at den ikke kan bli fjernet?
	public void addIngredient(String ingredient, double amount) {
		validateIngredient(ingredient);
		checkNegativeAmount(amount);
		double newAmount = listIngredients.get(ingredient)+amount;
		listIngredients.put(ingredient, newAmount);
	}

	/**
	 * Remove `amount` of `ingredient` to the container.
	 *
	 * If the resulting amount of the ingredient is 0, its name should be removed
	 *
	 * @param ingredient The name of the ingredient to add
	 * @param amount The amount of the ingredient to remove
	 * @throws IllegalArgumentException if amount cannot be removed from this
	 */
	public void removeIngredient(String ingredient, double amount) {
		validateIngredient(ingredient);
		checkNegativeAmount(amount);
		//Her tester jeg om mengden er større en eksisterende mengde. Hvis ja, så fjerner jeg nøkkelen. 
		if(amount>this.listIngredients.get(ingredient)) {
			this.listIngredients.remove(ingredient);
		}else {
			double newAmount = this.listIngredients.get(ingredient)-amount;
			this.listIngredients.put(ingredient, newAmount);
		}
	}

	/**
	 * @return An Iterable giving the names of all the ingredients
	 */
	@Override
	public Iterable<String> ingredientNames() {
		Collection<String> namesIngredients = new ArrayList<>();
		for(String ingredient:this.listIngredients.keySet()) {
			namesIngredients.add(ingredient);
		}
		return namesIngredients;
	}

	/**
	 * @return A collection containing the names of all the ingredients
	 */
	
	//Samlet alle verdiene inn i en Collection i forrige metode. Derfor henviser jeg til den. 
	@Override
	public Collection<String> getIngredientNames() {
		return (Collection<String>) ingredientNames();
	}

	/**
	 * @param ingredient The ingredient to get the amount of
	 * If the ingredient does not exist, the double 0.0 should be returned.
	 * @return The amount of ingredient
	 */
	
	
	@Override
	public double getIngredientAmount(String ingredient) {
		if(!getIngredientNames().contains(ingredient)) {
			return 0.0;
		}		
		return this.listIngredients.get(ingredient);
	}

	/**
	 * Get a string containing the ingredients with amounts in the format given below:
	 * Mark that it does not matter in which order the ingredients are listed.
	 *
	 * ingredientName1: amount1
	 * ingredientName2: amount2
	 * ingredientName3: amount3
	 * ...
	 *
	 * @return A string on the format given above
	 */
	@Override
	public String toString() {
		String formatString = null;
		formatString = setFormatString(formatString);
		String resultString = new String();
		for(String temp:getIngredientNames()) {
			resultString+= String.format(formatString, temp,getIngredientAmount(temp));
		}
		return resultString;
	}
	

	/**
	 * Add all ingredients from another Ingredients object into this.
	 *
	 * @param ingredients the ingredients to add
	 */
	
	public void addIngredients(Ingredients ingredients) {
		for(String ingredient : ingredients.getIngredientNames()) {
				addIngredient(ingredient,ingredients.getIngredientAmount(ingredient));
		}
	}

	/**
	 * Remove all ingredients in other from this.
	 *
	 * @param ingredients the ingredients to remove
	 * @throws IllegalArgumentException if this does not contain enough of any of the ingredients (without changing this)
	 */
	
	/*
	 * Hvis det er en større mengde av ingrediensene i det andre objektet så vil den ikke ta ingrediensene. 
	 * Det er slik jeg tolker oppgaven.  
	 */
	public void removeIngredients(Ingredients ingredients) {
		for(String ingredient : getIngredientNames()) {
			if(getIngredientAmount(ingredient)<ingredients.getIngredientAmount(ingredient)) {
				throw new IllegalArgumentException("The ingredient amount is too large");
			}
			removeIngredient(ingredient, getIngredientAmount(ingredient));
		}
	}

	/**
	 * Checks if the all the ingredients in other is contained in this
	 * @param other
	 * @return true of there is at least the same or larger amount of ingredients in this than in other, false otherwise
	 */
	
	
	/*
	 * litt usikker på oppgavetekesten, men tolket det som  at denne må inneholde alle ingrediensene
	 * til other objekter for at den skal returnere true
	 */
	@Override
	public boolean containsIngredients(Ingredients other) {
		boolean containsAllIngredients= true;
		for(String ingredient:other.getIngredientNames()) {
			if(!getIngredientNames().contains(ingredient)) {
				containsAllIngredients=false;
			}
		}
		return containsAllIngredients;
	}

	/**
	 * Returns the ingredients that must be added to other for this to be contained in it
	 * @param other
	 * @return a new Ingredients that if added to other would make it contain this
	 */
	@Override
	public Ingredients missingIngredients(Ingredients other) {
		Collection<String> missingIngredients = new ArrayList<>();
		Ingredients missing = new IngredientContainer();
		missingIngredients = other.getIngredientNames().stream()
								  .filter(t->!getIngredientNames().contains(t))
								  .collect(Collectors.toList());
		//returnerer null hvis det ikke er noe manglende ingredienser. 
		if(missingIngredients.isEmpty()) {
			return null;
		}else {
			//Her legger jeg til alle ingrediensene som mangler. 
			for(String missingElements : missingIngredients) {
				missing.getIngredientNames().add(missingElements);
			}
			return missing;
		}	
	}

	/**
	 * Returns the ingredients that you get if you scale this by factor 'scale'.
	 * I.e. an IngredientContainer with 4 portions scaled by 2 ends up with 8 portions.
	 * See example in main method.
	 * @param scale
	 * @return a new scaled Ingredients
	 */
	//Fortsetter med denne hvis jeg får tid. 
	@Override
	public Ingredients scaleIngredients(double scale) {
		Ingredients scaledIngredient = new IngredientContainer();
		for(String ingredients : getIngredientNames()) {
			scaledIngredient.
		}

	}
	
	//Alle private metoder under her. 
	
	private void validateIngredient(String ingredient) {
		if(ingredient==null) {
			throw new IllegalArgumentException("This ingredient is not valid");
		}
	}
	private void checkNegativeAmount(double amount) {
		if(amount<0) {
			throw new IllegalArgumentException("Amount can not be negative");
		}
	}
	
	private String setFormatString(String text) {
		text = "%s : %s \n"; //Legger til et avsnitt på slutten. 
		return text;
	}
	
	
	
	
	
	/**
	 * Some helpful code to debug your code. Does not cover everything!
	 * @param args
	 */
	public static void main(String[] args) {
		
		final IngredientContainer container = new IngredientContainer();
		container.addIngredient("food1", 12.0);
		container.addIngredient("food2", 6.0);
		container.addIngredient("food2", 2.5);

		// food2 should now be 8.5, with a small delta added for double rounding.
		assertEquals(8.5, container.getIngredientAmount("food2"), 0.0001);
		System.out.println(container);

		// Double the ingredients:
		Ingredients twice = container.scaleIngredients(2);
		assertEquals(17.0, twice.getIngredientAmount("food2"), 0.0001);
		
		// Remove food from the first container:
		container.removeIngredient("food1", 10);
		System.out.println(container);
		assertEquals(2.0, container.getIngredientAmount("food1"), 0.0001);
		
		
	}
}
