package encapsulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocationTest {
	
	private Location loc;
	
	/**
	 * Check that the position of {@link #loc} is equal to the parameters.
	 * 
	 * @param x Expected x position
	 * @param y Expected y position
	 */
	private void checkPos(int x, int y) {
		Assertions.assertEquals(x, loc.getX());
		Assertions.assertEquals(y, loc.getY());
	}

	
	@BeforeEach
	public void beforeEach() {
		loc = new Location();
	}
	
	@Test
	public void testConstructor() {
		checkPos(0,0);
	}
	
	@Test
	public void testGetSetX() {
		loc.setX(0);
		Assertions.assertEquals(0, loc.getX());
		loc.setX(10);
		Assertions.assertEquals(10, loc.getX());
		loc.setX(-1);
		Assertions.assertEquals(-1, loc.getX());
	}
	
	@Test
	public void testGetSetY() {
		loc.setY(0);
		Assertions.assertEquals(0, loc.getY());
		loc.setY(10);
		Assertions.assertEquals(10, loc.getY());
		loc.setY(-1);
		Assertions.assertEquals(-1, loc.getY());
	
	}
	
	@Test
	public void testLeft() {
		checkPos(0,0);
		loc.left();
		checkPos(-1, 0);
	}
	
	@Test
	public void testRight() {
		checkPos(0,0);
		loc.right();
		checkPos(1,0);
	}
	
	@Test
	public void testUp() {
		checkPos(0,0);
		loc.up();
		checkPos(0,-1);
	}
	
	@Test
	public void testDown() {
		checkPos(0,0);
		loc.down();
		checkPos(0,1);
	}
}