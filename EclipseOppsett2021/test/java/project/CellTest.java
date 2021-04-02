package project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CellTest {

	private Cell cell1;
	
	@BeforeEach
	public void setup() {
		cell1 = new Cell();
	}
	
	/*
	 * testConstructor_ExpectingFalse 
	 * tester om isclicked opprinnelig er satt til false.  
	 */
	@Test
	public void testConstructor_ExpectingFalse() {
		assertFalse(cell1.isCellClicked());
	}
	
	/*
	 * testConstructor_ExpectingEmptyFigur 
	 * tester om figuren opprinnelig er tom. 
	 */
	@Test
	public void testConstructor_ExpectingEmptyFigur() {
		assertTrue(cell1.getFigur().isEmpty());
	}
	
	/*
	 * testSetCellClicked_ExpectingTrue 
	 * tester når setCellClicked er satt til true, så er cellene klikket på. 
	 */
	@Test
	public void testSetCellClicked_ExpectingTrue() {
		cell1.setCellClicked(true);
		assertTrue(cell1.isCellClicked());
	}
	
	/*
	 * testGetFigur_ExpectingEmptyFigur 
	 * Tester at det ikke går ann å gi cellen en figuren når
	 * den IKKE er trykket på. Altså når isclicked() er false
	 */
	@Test
	public void testGetFigur_ExpectingEmptyFigur() {
		cell1.mineFigur();
		assertTrue(cell1.getFigur().isEmpty());
	}
	
	/*
	 * testGetFigur_ExpectingSpecificFigur 
	 * Tester at det går ann å gi cellen en figuren når
	 * den trykkes på først. Altså at isclicked() er true
	 */
	@Test
	public void testGetFigur_ExpectingSpecificFigur() {
		String mineFigur ="M";
		cell1.setCellClicked(true);
		cell1.mineFigur();
		assertEquals(mineFigur, cell1.getFigur());
	}
	
	/*
	 * testGetFigur_ExpectingSpecificFigur 
	 * Tester at det går ann å gi cellen en figuren når
	 * den trykkes på først. Altså at isclicked() er true
	 */
	@Test
	public void testClearCell_ExpectingEmptyFigur() {
		cell1.setCellClicked(true);
		cell1.mineFigur();
		cell1.clearCell();
		assertTrue(cell1.getFigur().isEmpty());
	}
	
	
	
}
