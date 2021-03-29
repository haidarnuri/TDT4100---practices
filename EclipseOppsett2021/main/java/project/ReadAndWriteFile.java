/**
 * 
 */
package project;

import java.io.IOException;
import java.util.List;

/**
 * Dette grensesnittet innholder metoder som 
 * lagrer og loader tilstander. 
 * 
 * @author hanua005
 *
 */
public interface ReadAndWriteFile {
	
	void saveFile();
	
	List<Character> loadFile() throws IOException;
}
