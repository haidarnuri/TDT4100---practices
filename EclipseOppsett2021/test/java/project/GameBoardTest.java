package project;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameboardTest{
	
	
	Gameboard board1, board2, board3,board4, invalidGameboard;
	
	
	@BeforeEach
	public void setup() {
		board1 = new Gameboard(9);
		board2 = new Gameboard(36);
		board3 = new Gameboard(81);
	}
		
	@Test
	public void testInvalidBoardSize() {
		/*
		 * Genrerer først et tilfeldig ugyldig tall mellom 0 og 1000. 
		 */
		Random rand =new Random();
		int randInt = rand.nextInt(1000);
		while(randInt==9 && randInt==36 && randInt==81) {
			randInt = rand.nextInt(1000);
		}
		try{
			invalidGameboard = new Gameboard(randInt); 	        
			fail("Den burde ikke aksepterer en verdi utenom 9, 36 eller 81");
		} catch(Exception e) {
	    } 
	}
	
	@Test
	public void testGetNumberOfMines_allBoardObjects() {
		//Tester for brett 1
		int correctNumberOfMinesBoard1 = (int)Math.sqrt(9);
		assertEquals(correctNumberOfMinesBoard1, board1.getNumberOfMines());
		
		//Tester for brett 2
		int correctNumberOfMinesBoard2 = (int)Math.sqrt(36);
		assertEquals(correctNumberOfMinesBoard2, board2.getNumberOfMines());

		//Tester for brett 3
		int correctNumberOfMinesBoard3 = (int)Math.sqrt(81);
		assertEquals(correctNumberOfMinesBoard3, board3.getNumberOfMines());

	}
	
	@Test
	public void testGetNumberOfEmpty_allBoardObjects() {
		//Tester for brett 1
		int correctNumberOfEmptyBoard1 = 9 - (int)Math.sqrt(9);
		assertEquals(correctNumberOfEmptyBoard1, board1.getNumberOfEmpty());
		
		//Tester for brett 2
		int correctNumberOfEmptyBoard2 = 36 - (int)Math.sqrt(36);
		assertEquals(correctNumberOfEmptyBoard2, board2.getNumberOfEmpty());

		//Tester for brett 3
		int correctNumberOfEmptyBoard3 = 81 - (int)Math.sqrt(81);
		assertEquals(correctNumberOfEmptyBoard3, board3.getNumberOfEmpty());
	}
	
	@Test
	public void testSetNumberOfEmpty_allBoardObjects() {
		//Tester for brett 1
		board1.setNumberOfEmpty(8);
		int newCorrectNumberOfEmptyBoard1 = 8 - board1.getNumberOfMines();
		assertEquals(newCorrectNumberOfEmptyBoard1, board1.getNumberOfEmpty());
				
		//Tester for brett 2
		board2.setNumberOfEmpty(35);
		int newCorrectNumberOfEmptyBoard2 = 35 - board2.getNumberOfMines();
		assertEquals(newCorrectNumberOfEmptyBoard2, board2.getNumberOfEmpty());

		//Tester for brett 3
		board3.setNumberOfEmpty(80);
		int newCorrectNumberOfEmptyBoard3 = 80 - board3.getNumberOfMines();
		assertEquals(newCorrectNumberOfEmptyBoard3, board3.getNumberOfEmpty());		
	}
	
	@Test
	public void testDecreaseNumberOfEmptyFields_allBoardObjects() {
		//Tester for brett 1
		int expectedNumberOfEmptyBoard1 = board1.getNumberOfEmpty()-1;
		board1.decreaseNumberOfEmptyFields();
		assertEquals(expectedNumberOfEmptyBoard1, board1.getNumberOfEmpty());
		
		//Tester for brett 2
		int expectedNumberOfEmptyBoard2 = board2.getNumberOfEmpty()-1;
		board2.decreaseNumberOfEmptyFields();
		assertEquals(expectedNumberOfEmptyBoard2, board2.getNumberOfEmpty());

		//Tester for brett 3
		int expectedNumberOfEmptyBoard3 = board3.getNumberOfEmpty()-1;
		board3.decreaseNumberOfEmptyFields();
		assertEquals(expectedNumberOfEmptyBoard3, board3.getNumberOfEmpty());
	}
	
	@Test
	public void testNoEmptyFieldsLeft_allBoardObjects() {
		//Tester for brett 1
		int numberOfEmptyBoard1 = board1.getNumberOfEmpty();
		for (int i = 0; i < numberOfEmptyBoard1; i++) {
			board1.decreaseNumberOfEmptyFields();
		}
		assertTrue(board1.noEmptyFieldsLeft());
		
		//Tester for brett 2
		int numberOfEmptyBoard2 = board2.getNumberOfEmpty();
		for (int i = 0; i < numberOfEmptyBoard2; i++) {
			board2.decreaseNumberOfEmptyFields();
		}
		assertTrue(board2.noEmptyFieldsLeft());
		
		//Tester for brett 3
		int numberOfEmptyBoard3 = board3.getNumberOfEmpty();
		for (int i = 0; i < numberOfEmptyBoard3; i++) {
			board3.decreaseNumberOfEmptyFields();
		}
		assertTrue(board3.noEmptyFieldsLeft());
	}

	
	
	
	
}
