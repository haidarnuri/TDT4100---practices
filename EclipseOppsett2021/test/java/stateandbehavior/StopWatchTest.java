package stateandbehavior;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StopWatchTest {
	private StopWatch stopWatch;
	
	@BeforeEach
	public void beforeEach() {
		stopWatch = new StopWatch();
	}
	
	@Test
	public void testConstructor() {
		Assertions.assertFalse(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());
		Assertions.assertEquals(0, stopWatch.getTicks());
		Assertions.assertEquals(-1, stopWatch.getTime());
		Assertions.assertEquals(-1, stopWatch.getLapTime());
		Assertions.assertEquals(-1, stopWatch.getLastLapTime());
	}
	
	@Test
	public void testTicksWithoutStart() {
		stopWatch.tick(1);
		Assertions.assertEquals(-1,  stopWatch.getTime());
		Assertions.assertEquals(1, stopWatch.getTicks());
		stopWatch.tick(4);
		Assertions.assertEquals(-1, stopWatch.getTime());
		Assertions.assertEquals(5, stopWatch.getTicks());
	}
	
	@Test
	public void testStartTickStop() {
		stopWatch.start();
		Assertions.assertEquals(0, stopWatch.getTime());
		Assertions.assertEquals(0, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());
		
		stopWatch.tick(3);
		Assertions.assertEquals(3, stopWatch.getTime());
		Assertions.assertEquals(3, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());
		
		stopWatch.tick(5);
		Assertions.assertEquals(8, stopWatch.getTime());
		Assertions.assertEquals(8, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());
		
		stopWatch.stop();
		Assertions.assertEquals(8, stopWatch.getTime());
		Assertions.assertEquals(8, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertTrue(stopWatch.isStopped());
	}
	
	@Test
	public void testTickStartTickStopTick() {
		stopWatch.tick(2);
		Assertions.assertEquals(-1, stopWatch.getTime());
		Assertions.assertEquals(2, stopWatch.getTicks());
		Assertions.assertFalse(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());
		
		stopWatch.start();
		Assertions.assertEquals(0, stopWatch.getTime());
		Assertions.assertEquals(2, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());
		
		stopWatch.tick(3);
		Assertions.assertEquals(3, stopWatch.getTime());
		Assertions.assertEquals(5, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());
		
		stopWatch.tick(5);
		Assertions.assertEquals(8, stopWatch.getTime());
		Assertions.assertEquals(10, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertFalse(stopWatch.isStopped());
		
		stopWatch.stop();
		Assertions.assertEquals(8, stopWatch.getTime());
		Assertions.assertEquals(10, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertTrue(stopWatch.isStopped());
		
		stopWatch.tick(3);
		Assertions.assertEquals(8, stopWatch.getTime());
		Assertions.assertEquals(13, stopWatch.getTicks());
		Assertions.assertTrue(stopWatch.isStarted());
		Assertions.assertTrue(stopWatch.isStopped());
	}
	
	@Test
	public void testLaps() {
		stopWatch.start();
		Assertions.assertEquals(0, stopWatch.getTime());
		Assertions.assertEquals(0, stopWatch.getLapTime());
		Assertions.assertEquals(-1, stopWatch.getLastLapTime());
		
		stopWatch.tick(3);
		Assertions.assertEquals(3, stopWatch.getTime());
		Assertions.assertEquals(3, stopWatch.getLapTime());
		Assertions.assertEquals(-1, stopWatch.getLastLapTime());
		
		stopWatch.lap();
		Assertions.assertEquals(3, stopWatch.getTime());
		Assertions.assertEquals(0, stopWatch.getLapTime());
		Assertions.assertEquals(3, stopWatch.getLastLapTime());
		
		stopWatch.tick(5);
		Assertions.assertEquals(8, stopWatch.getTime());
		Assertions.assertEquals(5, stopWatch.getLapTime());
		Assertions.assertEquals(3, stopWatch.getLastLapTime());
		
		stopWatch.stop();
		Assertions.assertEquals(8, stopWatch.getTime());
		Assertions.assertEquals(0, stopWatch.getLapTime());
		Assertions.assertEquals(5, stopWatch.getLastLapTime());
	}
}