package stuff;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SummerTest {

	@Test
	public void testSum1() {
		Assert.assertEquals(6, Summer.sum(List.of(1, 2, 3)));
	}

	//Tester med en tom liste. Da forventer jeg å få verdien null, men her kaster den et unntak. 
	@Test
	public void testSumMistake() {
		Assert.assertEquals(0, Summer.sum(List.of()));
	}

	@Test
	public void testDifference1() {
		Assert.assertEquals(0, Summer.difference(List.of()));
	}

	@Test
	public void testDifferenceMistake() {
		// TODO: reveal mistake in difference method
	}
}
