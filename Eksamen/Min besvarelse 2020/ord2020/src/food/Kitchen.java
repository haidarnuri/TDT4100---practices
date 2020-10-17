package food;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Kitchen implements KitchenObserver{

	//Viktig at Kitchen har oversikt over lytterne. og at den kan legge til og fjerne lyttere. 
	private Collection<KitchenObserver> observers = new ArrayList<>();
	
	public void addObserver(KitchenObserver observer) {
		if(!this.observers.contains(observer)) {
			this.observers.add(observer);
		}
	}
	
	public void removeObserver(KitchenObserver observer) {
			this.observers.remove(observer);
	}
	
	
	//Dårlig tid som gjorde at jeg bare lagde en metode for å demonstrere obserbervarhet. 
	@Override
	public void informObserveres(String information) {
		this.observers.stream()
						.forEach(o ->o.informObserveres(information));
		
	}
	
	
	private Collection<Recipe> allRecieps = new ArrayList<>();
	/**
	 * Create a new kitchen with the given recipes
	 * @param recipes The recipes the kitchen knows
	 */
	public Kitchen(Recipe...recipes) {
		this.allRecieps = Arrays.asList(recipes);
	}

	/**
	 * @return The kitchen's ingredient storage
	 */
	public IngredientContainer getStorage() {
		IngredientContainer newIngredientContainer = new IngredientContainer();
		for(Recipe temp : this.allRecieps) {
			newIngredientContainer.addIngredients(temp.getIngredients());
		}
		return newIngredientContainer;
	}

	/**
	 * Lookup a recipe in the kitchen's known recipes by name.
	 * 
	 * If no recipe with the given name is found, `null` is returned.
	 * 
	 * @param name The name of the recipe
	 * @return The recipe with the given name, or `null` if no such recipe exists 
	 */
	public Recipe getRecipe(String name) {
		Recipe newRecipe = this.allRecieps.stream()
										  .filter(t ->t.getName().equals(name))
										  .findAny().orElse(null);
		return newRecipe;
	}

	/**
	 * @return A collection of all the recipes the kitchen knows
	 */
	public Collection<Recipe> getAllRecipes() {
		return this.allRecieps;
	}
	
	/**
	 * Add a recipe to the recipes of the week
	 * @param recipe The recipe to add
	 */
	public void addRecipeToWeekly(Recipe recipe) {
		if(getAllRecipes().contains(recipe)) {
			this.allRecieps.add(recipe);
		}
	}

	/**
	 * Remove a recipe from the recipes of the week
	 * @param recipe The recipe to remove
	 */
	public void removeRecipeFromWeekly(Recipe recipe) {
		this.allRecieps.remove(recipe);
	}

	/**
	 * Clear the recipes of the week. Useful for selecting next weeks
	 * recipes.
	 */
	public void clearWeekly() {
		this.allRecieps.clear();
	}

	/**
	 * This method should be called when the chef has finished setting 
	 * all recipes for the next week, and can be used to trigger
	 * fitting behavior.
	 */
	public void registerWeekly() {
		// TODO
	}

	/**
	 * @return The list of recipes the kitchen will create this week
	 */
	public Collection<Recipe> getWeeklyRecipes() {
		// TODO
	}

	/**
	 * Check if this kitchen has the ingredients needed to cook a given recipe
	 *
	 * @param recipe The recipe to check for
	 * @return true if the kitchen has enough ingredients
	 */
	public boolean canCreateRecipe(Recipe recipe) {
		// TODO
	}

	/**
	 * Cook the given recipe, i.e. remove the amount of ingredients from this kitchen's storage.
	 *
	 * @param recipe The recipe to create
	 * @throws an appropriate RuntimeException if there's not enough ingredients to create the given recipe.
	 */
	public void createRecipe(Recipe recipe) {
		// TODO
	}
	
	/**
	 * Generic filter method on the recipes in this kitchen
	 *
	 * @param predicate The predicate to filter on
	 * @return The filtered collection of recipes
	 */
	public Collection<Recipe> filterRecipes(Predicate<Recipe> predicate) {
		Collection<Recipe> filteredRecipes = new ArrayList<>();
		this.allRecieps.stream()
						.filter(predicate)
						.forEach(t->filteredRecipes.add(t));
		return filteredRecipes;
	}

	/**
	 * @return All recipes that can be created with the current ingredient store of this kitchen
	 */
	
	//Prøver å hente ut alle ingrediensene fra lageret og se om det mathcer ingrediensene i oppskriften.  
	public Collection<Recipe> getRecipesThatCanBeCreated() {
		return filterRecipes(t->getStorage().containsIngredients(t.getIngredients()));
	}

	/**
	 * @param ingredient The ingredient to search for
	 * @return All recipes that contains `ingredient`
	 */
	public Collection<Recipe> getRecipiesContainingIngredient(String ingredient) {
		Collection<Recipe> getRecipes = this.allRecieps.stream()
														.filter(t->t.getIngredients().getIngredientNames().contains(ingredient))
														.collect(Collectors.toList());
		return getRecipes;
	}

	// TODO: support observability 
	
	public static void main(final String[] args) throws IOException {

		// Reading from file:
		
		// Read recipes using RecipeReader. Uncomment to test.
//		final RecipeReader recipeReader = new RecipeReader();
//		List<Recipe> recipes = new RecipeReader().readRecipes(RecipeReader.class.getResourceAsStream("sample-recipes.txt"));
//		System.out.println(recipes.size());
		
		// Use the sample recipes. Uncomment to test
//		final Collection<Recipe> dummyrecipes = Recipe.createSampleRecipes();
//		System.out.println(dummyrecipes.size());
		
		// Simple kitchen - two recipes only
		Recipe[] recipesArray = new Recipe[2];
		IngredientContainer ig = new IngredientContainer();
		ig.addIngredient("egg", 4);
		ig.addIngredient("milk", 5);
		ig.addIngredient("flour", 3);
		ig.addIngredient("salt", 1);
		Recipe pancakes = new Recipe("pancakes", "almost_dinner", 4, ig);
		recipesArray[0] = pancakes;

		ig = new IngredientContainer();
		ig.addIngredient("egg", 5);
		ig.addIngredient("milk", 4);
		ig.addIngredient("flour", 3);
		ig.addIngredient("salt", 1);
		ig.addIngredient("vanilla", 1);
		Recipe waffles = new Recipe("waffles", "Dessert", 4, ig);
		recipesArray[1] = waffles;
		
		final Kitchen kitchen = new Kitchen(recipesArray);
		System.out.println("Pancakes: " + kitchen.getRecipe("pancakes"));
		
		// Should print false:
		System.out.println(kitchen.canCreateRecipe(pancakes));
		kitchen.getStorage().addIngredient("egg", 12);
		kitchen.getStorage().addIngredient("milk", 20);
		kitchen.getStorage().addIngredient("flour", 2000);
		kitchen.getStorage().addIngredient("salt", 100);
		// Should print true:
		System.out.println(kitchen.canCreateRecipe(pancakes));
		
		// Weekly recipes:
		
		kitchen.addRecipeToWeekly(pancakes.createNPortions(20));
		kitchen.registerWeekly();
		System.out.println("Kitchens weekly recipes: " + kitchen.getWeeklyRecipes());
		System.out.println(kitchen.getStorage());
		
		// Recipes containing egg:
		System.out.println("Recipes containing egg: " + kitchen.getRecipiesContainingIngredient("egg"));
	}

	
}
