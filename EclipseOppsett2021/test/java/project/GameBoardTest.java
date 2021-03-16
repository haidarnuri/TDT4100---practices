package project;

import static org.junit.jupiter.api.Assertions.fail;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameBoardTest{
	
	GameBoardArray board1, board2, inValidBoard;
	
	
	
	@BeforeEach
	public void setup() {
		board1 = new GameBoardArray();
		board2 = new GameBoardArray(10,6);
	}
	@Test
	public void testValidLenghtRowAndColoumn_duringGameBoard() { 
		Assertions.assertEquals(5, board1.getDuringGameBoard().length);
		Assertions.assertEquals(5, board1.getDuringGameBoard()[0].length);
		
		Assertions.assertEquals(10, board2.getDuringGameBoard().length);
		Assertions.assertEquals(6, board2.getDuringGameBoard()[0].length);
	}
	
	@Test
	public void testInvalidLenghtRowAndColoumn_duringGameBoard() { 
		try{
	        inValidBoard = new GameBoardArray(2,4);
	        fail("Den burde ikke akseptere radstørrelser som er under 3");
		} catch(Exception e) {
	    } 
		
		try{
	        inValidBoard = new GameBoardArray(4,3);
	        fail("Den burde ikke akseptere kolonnestørrelser som er under 3");
		} catch(Exception e) {
	    } 
		
	}
	
	@Test
	public void testValidLenghtRowAndColoumn_generatedBeforeBoard() { 
		Assertions.assertEquals(5, board1.getGeneratedBeforeGameboard().length);
		Assertions.assertEquals(5, board1.getGeneratedBeforeGameboard()[0].length);
		
		Assertions.assertEquals(10, board2.getGeneratedBeforeGameboard().length);
		Assertions.assertEquals(6, board2.getGeneratedBeforeGameboard()[0].length);

	}

	
	
	
	
}
