package project;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAndLoadGame {
	
	String filename = "src/main/java/project/saveFile.txt";
	String textToSave = "";
	
	
	public SaveAndLoadGame(String textToSave) {
		this.textToSave=textToSave;
		
	}
	
	
	public void saveFile() {

	    try {
	      // Creates a FileWriter
	      FileWriter file = new FileWriter(filename);
	     
	      // read each character from string and write 
          // into FileWriter 
          for (int i = 0; i < this.textToSave.length(); i++) 
        	  file.write(this.textToSave.charAt(i)); 
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
        			System.out.print((char)i);    
        		}
        	} 
        	finally {
        		fileReader.close();
        	}
	}
		
	public static void main(String[] args) throws IOException {
		String boardString = "";
		GameBoard temp = new GameBoard(3,3);
		temp.fillBoardWithFigures();
		for (int i = 0; i < temp.getGeneratedBeforeGameboard().length; i++) {
			for (int j = 0; j < temp.getGeneratedBeforeGameboard()[0].length; j++) {
				boardString += temp.getGeneratedBeforeGameboard()[i][j].getFigur();
			}
		}
		System.out.println(boardString);
		System.out.println(boardString.charAt(0));
		System.out.println(boardString.charAt(1));
		System.out.println(boardString.charAt(boardString.length()-1));
		/*
		SaveAndLoadGame tempText = new SaveAndLoadGame("TestText");
		tempText.saveFile();
		tempText.loadFile();*/
	}

}
