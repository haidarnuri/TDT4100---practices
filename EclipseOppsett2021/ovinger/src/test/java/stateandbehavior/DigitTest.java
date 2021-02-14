package stateandbehavior;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DigitTest {
	
	private String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	@Test
	public void testConstructor() {
		Digit digit = new Digit(10);
		Assertions.assertEquals(0, digit.getValue());
		Assertions.assertEquals(10, digit.getBase());
	}
	
	@Test
	public void testIncrementedValue() {
		for (int base = 2; base < 17; base++) {
			Digit digit = new Digit(base);
			Assertions.assertEquals(0, digit.getValue());
			
			int i = 1;
			while (i < base) {
				boolean result = digit.increment();
				Assertions.assertEquals(i, digit.getValue(), "the value was not incremented correctly");
				Assertions.assertFalse(result, "increment should return false when the value is less than the base");
				i++;
			}
			boolean result = digit.increment();
			Assertions.assertEquals(0, digit.getValue(), "the value was not reset to 0 when it became equal to the base");
			Assertions.assertTrue(result, "increment should return true when the value is reset to 0");
		}
	}
	
	@Test
	public void testIncrementedToString() {
		for (int base = 2; base < 17; base++) {
			Digit digit = new Digit(base);
			Assertions.assertEquals("0", digit.toString(), "wrong string representation");
			
			int i = 1;
			while (i < base) {
				boolean result = digit.increment();
				Assertions.assertEquals(String.valueOf(digits.charAt(i)), digit.toString(), "wrong string representation");
				Assertions.assertFalse(result, "increment should return false when the value is less than the base");
				i++;
			}
			boolean result = digit.increment();
			Assertions.assertEquals("0", digit.toString(), "wrong string representation");
			Assertions.assertTrue(result, "increment should return true when the value is reset to 0");
		}
	}
}
