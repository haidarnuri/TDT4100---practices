package stuff;

import org.junit.Test;

import junit.framework.TestCase;

import java.util.List;


public class MedianComputerTest extends TestCase{

	// use as third argument to Assert.assertEquals(double, double, double) method for handling round-off errors
	// e.q. Assert.assertEquals(6.0, MedianComputer.compute(...), roundErrorDelta);
	double roundErrorDelta = 0.00000001;

	@Test
	public void testCompute1() {
		assertEquals(3,MedianComputer.compute(List.of(1,2,4,3,5)),roundErrorDelta);
	}

	@Test
	public void testCompute2() {
		assertEquals(2.5,MedianComputer.compute(List.of(1,3,50,2)),roundErrorDelta);
	}

	// TODO: more test methods
}
