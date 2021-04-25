package project;

import org.junit.jupiter.api.Test;

import javafx.scene.control.RadioButton;

import static org.junit.jupiter.api.Assertions.fail;


public class ToggleClassTest {

	private RadioButton smallBoard,mediumBoard,largeBoard;
	/**
	 * Denne testen sjekker om paramtere lik null utløser et unntak
	 */
	@Test
	public void testConstructor_ExpectingException() {
		try {
			new ToggleClass(smallBoard,mediumBoard,largeBoard);
			fail("Should show exception when parameter is null");
		}catch(Exception e) {
		}
	}	
	
}
