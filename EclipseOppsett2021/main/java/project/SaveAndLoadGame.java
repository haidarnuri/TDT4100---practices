package project;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAndLoadGame {
	
	private String filename = "src/main/java/project/saveFile.txt";
	private String textToSave = "";
	private String textToLoad;
	
	public SaveAndLoadGame() {
		this("");	
	}
	
	public SaveAndLoadGame(String textToSave) {
		this.textToSave=textToSave;
	}
	
	
	
	
	public void saveFile() {

	    try {
	      // Creates a FileWriter
	      FileWriter file = new FileWriter(filename);
	      // read each character from string and write 
          // into FileWriter 
          for (int i = 0; i < this.textToSave.length(); i++) {
        	  file.write(this.textToSave.charAt(i)); 
        	  
          }
          // close the file 
          file.close(); 
	    }

	    catch (Exception e) {
	      e.getStackTrace();
	    }
	}
	
	public void loadFile() throws IOException {
        
        FileReader fileReader = new FileReader(filename);
        try {
        		int i;    
        		while((i = fileReader.read()) != -1) {
        			
        		}
        	} 
        	finally {
        		fileReader.close();
        	}
	}
		
	public static void main(String[] args) throws IOException {
		
		SaveAndLoadGame tempText = new SaveAndLoadGame("00E2+E,01  +M,02E1+E,10  +M,11E3+E,12E2+E,20  +E,21E2+E,22M+M");
		tempText.saveFile();
		tempText.loadFile();
	}

}
