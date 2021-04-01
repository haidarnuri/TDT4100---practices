package project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameboardTest{
	
	
	Gameboard board1, board2, board3,board4, invalidGameboard;
	Random rand =new Random();
	
	@BeforeEach
	public void setup() {
		board1 = new Gameboard(9);
		board2 = new Gameboard(36);
		board3 = new Gameboard(81);
	}
	
	/*
	 * testInvalidBoardSize - tester om det kastes et unntak når man initierer et brett
	 * som ikke har 9, 36 eller 81 celler.
	 */
		
	@Test
	public void testInvalidBoardSize_ExpectingException() {
		/*
		 * Genrerer først et tilfeldig ugyldig tall mellom 0 og 1000. 
		 */
		int randInt = rand.nextInt(1000);
		while(randInt==9 || randInt==36 || randInt==81) {
			randInt = rand.nextInt(1000);
		}
		try{
			invalidGameboard = new Gameboard(randInt); 	        
			fail("Den burde ikke aksepterer en verdi utenom 9, 36 eller 81");
		} catch(Exception e) {
	    } 
	}
	
	/*
	 * testGetNumberOfMines_allBoardObjects 
	 * tester at antall miner fra starten stemmer. 
	 */
	@Test
	public void testGetNumberOfMines_allBoardObjects_ExpectingSpecificValue() {
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
	
	/*
	 * testGetNumberOfEmpty_allBoardObjects 
	 * tester at antall tomme felt fra starten stemmer. 
	 */
	@Test
	public void testGetNumberOfEmpty_allBoardObjects_ExpectingSpecificValue() {
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
	
	
	/*
	 * testSetNumberOfEmpty_allBoardObjects 
	 * tester at antalle tomme felt stemmer når man bruker setNumberEmpty metoden. 
	 */
	@Test
	public void testSetNumberOfEmpty_allBoardObjects_ExpectingSpecificValue() {
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
	
	
	/*
	 * testDecreaseNumberOfEmptyFields_allBoardObjects 
	 * tester at antall tomme felt synker med en når decreaseNumberOfEmptyFields metoden blir kalt
	 */
	@Test
	public void testDecreaseNumberOfEmptyFields_allBoardObjects_ExpectingSpecificValue() {
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
	
	/*
	 * testNoEmptyFieldsLeft_allBoardObjects_expectingTrue 
	 * tester noEmptyFieldsLeft gir true når decreaseNumberOfEmptyFields har blitt kalt LIKE mange ganger
	 * som startverdien på antall tomme felt. 
	 */	
	@Test
	public void testNoEmptyFieldsLeft_allBoardObjects_expectingTrue() {
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
	
	/*
	 * testNoEmptyFieldsLeft_allBoardObjects_expectingFalse 
	 * tester noEmptyFieldsLeft gir false når decreaseNumberOfEmptyFields har blitt kalt flere ganger enn det som er 
	 * startverdien på antall tomme felt. 
	 * Tester bare ved å legge til eller trekke fra en eller to i for løkkene. 
	 */	
	@Test
	public void testNoEmptyFieldsLeft_allBoardObjects_expectingFalse() {
		//Tester for brett 1
		int deltaBoard1=1;
		int numberOfEmptyBoard1 = board1.getNumberOfEmpty();
		for (int i = 0; i < numberOfEmptyBoard1+deltaBoard1; i++) {
			board1.decreaseNumberOfEmptyFields();
		}
		assertFalse(board1.noEmptyFieldsLeft());
		
		//Tester for brett 2
		int deltaBoard2 = -1;
		int numberOfEmptyBoard2 = board2.getNumberOfEmpty();
		for (int i = 0; i < numberOfEmptyBoard2 + deltaBoard2; i++) {
			board2.decreaseNumberOfEmptyFields();
		}
		assertFalse(board2.noEmptyFieldsLeft());
		
		//Tester for brett 3
		int deltaBoard3 = 2;
		int numberOfEmptyBoard3 = board3.getNumberOfEmpty();
		for (int i = 0; i < numberOfEmptyBoard3 + deltaBoard3; i++) {
			board3.decreaseNumberOfEmptyFields();
		}
		assertFalse(board3.noEmptyFieldsLeft());
	}
	
	/*
	 * testLeftClickOnCell_allBoardObjects_ExpectingException
	 * Denne metoden legger inn en ugyldig verdig som parameter i leftClickOnCell.
	 * Ugyldig verdig til si under 0 eller større enn størrelse på brettet minus en. 
	 */
	@Test
	public void testLeftClickOnCell_allBoardObjects_ExpectingException() {
		//Tester for brett 1
		int invalidPosBoard1 = -1;
		assertThrows(IllegalArgumentException.class, ()->{
			board1.leftClickOnCell(invalidPosBoard1);
		});
		
		//Tester for brett 2
		int invalidPosBoard2 = 36;
		assertThrows(IllegalArgumentException.class, ()->{
			board2.leftClickOnCell(invalidPosBoard2);
		});
		
		//Tester for brett 3
		int invalidPosBoard3 = -80;
		assertThrows(IllegalArgumentException.class, ()->{
			board3.leftClickOnCell(invalidPosBoard3);
		});
	}
	
	/*
	 * testLeftClickOnCell_allBoardObjects_ExpectingTrue
	 * Tester cellen som blir trykket på registrerer at den har blitt trykket på. 
	 */
	@Test
	public void testLeftClickOnCell_allBoardObjects_ExpectingTrue() {
		//Tester for brett 1
		int boardPosBoard1 = rand.nextInt(9);
		board1.leftClickOnCell(boardPosBoard1);
		assertTrue(board1.getduringGameboard().get(boardPosBoard1).isCellClicked());
		
		//Tester for brett 2
		int boardPosBoard2 = rand.nextInt(36);
		board2.leftClickOnCell(boardPosBoard2);
		assertTrue(board2.getduringGameboard().get(boardPosBoard2).isCellClicked());
			
		
		//Tester for brett 3
		int boardPosBoard3 = rand.nextInt(81);
		board3.leftClickOnCell(boardPosBoard3);
		assertTrue(board3.getduringGameboard().get(boardPosBoard3).isCellClicked());
	}
	
	/*
	 * testFillCellWithMine_allBoardObjects_ExpectingException
	 * Denne metoden legger inn en ugyldig verdig som parameter i fillCellWithMine.
	 * Ugyldig verdig til si under 0 eller større enn størrelse på brettet minus en. 
	 */
	@Test
	public void testFillCellWithMine_allBoardObjects_ExpectingException() {
		//Tester for brett 1
		int invalidPosBoard1 = -10;
		assertThrows(IllegalArgumentException.class, ()->{
			board1.fillCellWithMine(invalidPosBoard1);
		});
				
		//Tester for brett 2
		int invalidPosBoard2 = 36;
		assertThrows(IllegalArgumentException.class, ()->{
			board2.fillCellWithMine(invalidPosBoard2);
		});
				
		//Tester for brett 3
		int invalidPosBoard3 = 100;
		assertThrows(IllegalArgumentException.class, ()->{
			board3.fillCellWithMine(invalidPosBoard3);
		});
		
	}
	
	/*
	 * testFillCellWithMine_allBoardObjects_ExpectingSpecificValue
	 * Legger inn en spesfikk posisjon på brettet. 
	 * Figuren i den posisjon skal da være en mine merket med "M". 
	 */
	
	@Test
	public void testFillCellWithMine_allBoardObjects_ExpectingSpecificValue() {
		//Tester for brett 1
		String mineFigur = "M";
		int boardPosBoard1 = rand.nextInt(9);
		board1.leftClickOnCell(boardPosBoard1);
		board1.fillCellWithMine(boardPosBoard1);
		assertTrue(board1.getduringGameboard().get(boardPosBoard1).getFigur().equals(mineFigur));
	
		//Tester for brett 2
		int boardPosBoard2 = rand.nextInt(36);
		board2.leftClickOnCell(boardPosBoard2);
		board2.fillCellWithMine(boardPosBoard2);
		assertTrue(board2.getduringGameboard().get(boardPosBoard2).getFigur().equals(mineFigur));
			
		//Tester for brett 3
		int boardPosBoard3 = rand.nextInt(81);
		board3.leftClickOnCell(boardPosBoard3);
		board3.fillCellWithMine(boardPosBoard3);
		assertTrue(board3.getduringGameboard().get(boardPosBoard3).getFigur().equals(mineFigur));
	}
	
	/*
	 * testFillCellWithEmpty_allBoardObjects_ExpectingException
	 * Denne metoden legger inn en ugyldig verdig som parameter i fillCellWithEmpty.
	 * Ugyldig verdig til si under 0 eller større enn størrelse på brettet minus en. 
	 */
	@Test
	public void testFillCellWithEmpty_allBoardObjects_ExpectingException() {
		//Tester for brett 1
		int invalidPosBoard1 = -10;
		assertThrows(IllegalArgumentException.class, ()->{
			board1.fillCellWithEmpty(invalidPosBoard1);
		});
				
		//Tester for brett 2
		int invalidPosBoard2 = 36;
		assertThrows(IllegalArgumentException.class, ()->{
			board2.fillCellWithEmpty(invalidPosBoard2);
		});
				
		//Tester for brett 3
		int invalidPosBoard3 = 100;
		assertThrows(IllegalArgumentException.class, ()->{
			board3.fillCellWithEmpty(invalidPosBoard3);
		});
		
	}
	
	/*
	 * testFillCellWithMine_allBoardObjects_ExpectingSpecificValue
	 * Legger inn en spesfikk posisjon på brettet. 
	 * Figuren i den posisjon skal da være en mine merket med "M". 
	 */
	
	@Test
	public void testFillCellWithEmpty_allBoardObjects_ExpectingSpecificValue() {
		//Tester for brett 1
		String mineFigur = "E";
		int boardPosBoard1 = rand.nextInt(9);
		board1.leftClickOnCell(boardPosBoard1);
		board1.fillCellWithEmpty(boardPosBoard1);
		assertTrue(board1.getduringGameboard().get(boardPosBoard1).getFigur().equals(mineFigur));
	
		//Tester for brett 2
		int boardPosBoard2 = rand.nextInt(36);
		board2.leftClickOnCell(boardPosBoard2);
		board2.fillCellWithEmpty(boardPosBoard2);
		assertTrue(board2.getduringGameboard().get(boardPosBoard2).getFigur().equals(mineFigur));
			
		//Tester for brett 3
		int boardPosBoard3 = rand.nextInt(81);
		board3.leftClickOnCell(boardPosBoard3);
		board3.fillCellWithEmpty(boardPosBoard3);
		assertTrue(board3.getduringGameboard().get(boardPosBoard3).getFigur().equals(mineFigur));
	}
	
	/*
	 * Hvordan tester jeg denne?? 
	 */
	/*
	@Test
	public void testMineCounter_allBoardObjects_USIKKERHER() {
		
	}*/
	
	
	/*
	 * testDeactivateLeftClickOnAllCells_allBoardObjects_ExpectingTrue
	 * Aktiverer alle cellene. Deretter kaller jeg metoden deactivateLeftClickOnAllCells().
	 * Da skal IKKE cellene være klikket på. 
	 * Tester med kun et board da testen her er litt lengre. 
	 */
	@Test
	public void testDeactivateLeftClickOnAllCells_oneBoardObject_ExpectingTrue() {
		//Første linjene prøven jeg å vise at alle cellen er satt til isClicked. 
		board3.getduringGameboard().stream()
								   .forEach(cell ->cell.setCellClicked(true));
		List<Cell> listOfActivatedCells = board3.getduringGameboard().stream()
																	 .filter(cell -> !cell.isCellClicked())
																	 .collect(Collectors.toList());
		assertTrue(listOfActivatedCells.isEmpty());
		
		//Videre skal jeg vise at alle cellene blir deaktivert ved å kalle på deactivateLeftClickOnAllCells(). 
		
		board3.deactivateLeftClickOnAllCells();
		List<Cell> listOfDeactivatedCells = board3.getduringGameboard().stream()
				 								  .filter(cell -> !cell.isCellClicked())
				 								  .collect(Collectors.toList());
		/*
		 * Sjekker at alle cellene er deaktivert +  at det er like mange celler som opprinnelig liste. 
		 */
		boolean allButtonsDeactivated = true;
		boolean equalAmountOfCells = board3.getduringGameboard().size()==listOfDeactivatedCells.size();
		for(Cell tempCell : listOfDeactivatedCells) {
			if(tempCell.isCellClicked()) {
				allButtonsDeactivated=false;
			}
			
		}
		assertTrue(allButtonsDeactivated && equalAmountOfCells);
	}
	
	/*
	 * Hvordan tester jeg denne?? 
	 */
	/*
	@Test
	public void testScoutsCellsAround_allBoardObjects_USIKKERHER() {
		
	}*/
	
	
	
	

	
	
	
	
}
