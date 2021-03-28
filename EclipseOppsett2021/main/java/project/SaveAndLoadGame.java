package project;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SaveAndLoadGame implements ReadAndWriteFile{
	private String filename = "src/main/java/project/saveFile.txt";
	private GameboardList board;
	
	public SaveAndLoadGame(GameboardList board) {
		this.board=board;
	}
		
	public void saveFile() {
	    try {
	      FileWriter file = new FileWriter(filename);
	      for(Cell s:board.getduringGameboard()) {
	    	  String letterFromDuringBoard = s.getFigur();
           	  if(letterFromDuringBoard.isEmpty()) {
            	  file.write("."); 
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
		
	public static void main(String[] args) throws IOException {
		GameboardList board1= new GameboardList(36);
		/*
		board1.leftClickOnCell(0);
		 board1.decreaseNumberOfEmptyFields();
		 board1.fillCellWithEmpty(0);
		*/
		ReadAndWriteFile tempText = new SaveAndLoadGame(board1);
		tempText.saveFile();
		List<Character> temp = tempText.loadFile();
		/*
		for (int i = 0; i < board1.getduringGameboard().size()-1; i++) {
			System.out.println("pos "+i+" figur "+board1.getduringGameboard().get(i));
			
		} */ 
		
	}

}
