package food;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RecipeReader {

	// regex for column separator
	private final String columnSeparatorRegex = "\\$";

	/**
	 * Read recipes from an InputStream with the given format:
	 *
	 * name$category$nPortions$ingredient1;ingredient2;...;...$amount1;amount2;...;...
	 * 
	 * As you see from the format, each recipe is a single line, with fields separated by `$` and 
	 * elements in lists separated by `;`.
	 * 
	 * Regarding ingredients and amounts, the two lists are sorted in the same order, so `ingredient1`
	 * should have `amount1`, and so forth. All amounts can be read as doubles, while nPortions is an integer.
	 *
	 * Note that the first line of the stream is the header, and so should not be used.
	 * If a line (i.e. a single recipe) fails to be parsed correctly, that recipe is to be skipped.
	 *
	 * @param input The source to read from
	 * @throws IOException if input (InputStream) throws IOException
	 */
	//Usikker på denne, men ønsker allikevel å vise til et eksempel som viser at jeg har jobbet med inputStream før
	/*
	 * public class InputStreamTester {
	public static void main(String[] args) {
		int letter;
		File file = new File("C:\\Users\\andre\\Desktop\\haidar.txt");
		try {
			InputStream in = new FileInputStream(file);
			while((letter=in.read())!=-1) {
				System.out.println((char)letter);
			}
			in.close();			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			
		}finally {
			System.exit(0);
		}
		
		

	}

}
	 */
	public List<Recipe> readRecipes(InputStream input) throws IOException {
	
	}

	public static void main(String[] args) throws IOException {
		// read from sample file
		List<Recipe> recipes = new RecipeReader().readRecipes(RecipeReader.class.getResourceAsStream("sample-recipes.txt"));
		System.out.println(recipes);
	}
}
