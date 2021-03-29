package project;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Denne klassen lagrer og loader tilstander i spillet. 
 * Implimenterer ReadAndWriteFile-grensesnittet. 
 * 
 * @author haidarn
 */

public class SaveAndLoadGame implements ReadAndWriteFile{
	private String filename = "src/main/java/project/saveFile.txt";
	private Gameboard board;
	
	/**
	 * Konstruktør.
	 * @param board spillbrettobjekt som skal lagres og loades fra. 
	 */
	public SaveAndLoadGame(Gameboard board) {
		this.board=board;
	}
	
	/*
	 * Lagrer tilstanden til board objektet ved å skrive inn symbolene til saveFile.txt 
	 */
	public void saveFile() {
	    try {
	      FileWriter file = new FileWriter(filename);
	      for(Cell s:board.getduringGameboard()) {
	    	  String letterFromDuringBoard = s.getFigur();
	    	  /*
	    	   * Hvis cellen er tom så lagres mellomrom i fila. 
	    	   * Hvis cellen innholder E så lagres bokstaven E i saveFile.txt
	    	   */
           	  if(letterFromDuringBoard.isEmpty()) {
            	  file.write(" "); 
        	  }else{
        		  file.write(letterFromDuringBoard); 
        	  } 
	      }
          // close the file 
          file.close(); 
	    }
	    catch (Exception e) {
	      e.getStackTrace();
	    }
	}
	
	/**
	 * Metoden henter symboler fra saveFile.txt fila. 
	 * @return liste med symboler som er hentet fra saveFile.txt fila. 
	 */
	public List<Character> loadFile() throws IOException {
		List<Character> savedValues = new ArrayList<>();
        FileReader fileReader = new FileReader(filename);
        try {
        		int i;    
        		while((i = fileReader.read()) != -1) {
        			savedValues.add((char)i);
        		}
        	} 
        	finally {
        		fileReader.close();
        	}
		return savedValues;
	}

}
