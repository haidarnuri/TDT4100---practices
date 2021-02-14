package encapsulation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UpOrDownCounterTest {
	
	@Test
	public void testCountUp() {
		UpOrDownCounter counter = new UpOrDownCounter(1,  5);
		assertEquals(1, counter.getCounter());
		
		for (int i = 2; i < 5; i++) {
			boolean result = counter.count();
			assertEquals(i, counter.getCounter());
			assertTrue(result);
		}

		boolean result = counter.count();
		assertEquals(5, counter.getCounter());
		assertFalse(result);

		result = counter.count();
		assertEquals(5, counter.getCounter());
		assertFalse(result);
	}
	
	@Test
	public void testCountDown() {
		UpOrDownCounter counter = new UpOrDownCounter(1,  -5);
		assertEquals(1, counter.getCounter());
		
		for (int i = 0; i > -5; i--) {
			boolean result = counter.count();
			assertEquals(i, counter.getCounter());
			assertTrue(result);
		}

		boolean result = counter.count();
		assertEquals(-5, counter.getCounter());
		assertFalse(result);

		result = counter.count();
		assertEquals(-5, counter.getCounter());
		assertFalse(result);
	}
}

