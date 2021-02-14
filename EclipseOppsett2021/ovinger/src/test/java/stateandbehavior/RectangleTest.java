package stateandbehavior;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RectangleTest {

	private Rectangle rect;
	
	@BeforeEach
	protected void setUp() {
		rect = new Rectangle();
	}
	
	/**
	 * Check all values related to a {@link Rectangle}.
	 * 
	 * @param rect The rectangle to check
	 * @param minX The expected minimum x value of rect
	 * @param minY The expected minimum y value of rect
	 * @param maxX The expected maximum x value of rect
	 * @param maxY The expected maximum y value of rect
	 * @param w The expected width of rect
	 * @param h The expected height of rect
	 */
	private void assertValues(Rectangle rect, int minX, int minY, int maxX, int maxY, int w, int h) {
		Assertions.assertEquals(minX, rect.getMinX());
		Assertions.assertEquals(minY, rect.getMinY());
		Assertions.assertEquals(maxX, rect.getMaxX());
		Assertions.assertEquals(maxY, rect.getMaxY());
		Assertions.assertEquals(w, rect.getWidth());
		Assertions.assertEquals(h, rect.getHeight());
	}
	
	/**
	 * Check that a rectangle is empty
	 * 
	 * @param rect The rectangle to check
	 */
	private void assertEmpty(Rectangle rect) {
		Assertions.assertTrue(rect.isEmpty());
		Assertions.assertFalse(rect.contains(0, 0));
		assertValues(rect, 0, 0, 0, 0, 0, 0);
	}
	
	@Test
	public void testConstructor() {
		assertEmpty(rect);
	}
	
	private void testAdd(Rectangle rect, int x, int y, Boolean expected) {
		boolean result = rect.add(x, y);
		if (expected != null) {
			Assertions.assertEquals(expected.booleanValue(), result);
		}
		Assertions.assertFalse(rect.isEmpty());
		Assertions.assertTrue(rect.contains(x, y));
	}
	
	@Test
	public void testAddXYToEmpty() {
		int x = 13, y = -27;
		testAdd(rect, x, y, true);
		assertValues(rect, x, y, x, y, 1, 1);
	}
	
	@Test
	public void testAddXY() {
		int x1 = 13, y1 = -27;
		int x2 = -11, y2 = 23;
		int x3 = 15, y3 = 33;
		
		// Add (x1, y1) to the rect, and check that all values are updated accordingly
		testAdd(rect, x1, y1, true);
		assertValues(rect, x1, y1, x1, y1, 1, 1);
		
		// Add (x2, y2) and check that rect is updated accordingly. Note how we check 
		// for minimum and maximum x an y values in the points.
		testAdd(rect, x2, y2, true);
		int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
		int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);
		assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
		
		// Add (x3, y3) and check that rect is updated accordingly.
		testAdd(rect, x3, y3, true);
		int minX1X2X3 = Math.min(minX1X2, x3), minY1Y2Y3 = Math.min(minY1Y2, y3);
		int maxX1X2X3 = Math.max(maxX1X2, x3), maxY1Y2Y3 = Math.max(maxY1Y2, y3);
		assertValues(rect, minX1X2X3, minY1Y2Y3, maxX1X2X3, maxY1Y2Y3, maxX1X2X3 - minX1X2X3 + 1, maxY1Y2Y3 - minY1Y2Y3 + 1);
	}
	
	@Test
	public void testAddSameXY() {
		int x = 13, y = -27;
		testAdd(rect, x, y, true);
		assertValues(rect, x, y, x, y, 1, 1);
		testAdd(rect, x, y, false);
		assertValues(rect, x, y, x, y, 1, 1);
	}
	
	@Test
	public void testAddRectangleToEmpty() {
		int x1 = 13, y1 = -27;
		int x2 = -11, y2 = 23;
		
		// Create a rectangle and fill it with some points. Assert that this rect is correct.
		Rectangle rect = new Rectangle();
		testAdd(rect, x1, y1, true);
		assertValues(rect, x1, y1, x1, y1, 1, 1);
		testAdd(rect, x2, y2, true);
		int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
		int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);
		assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
		
		// Add rect to this.rect, and check that this.rect is updated accordingly.
		Assertions.assertTrue(this.rect.add(rect));
		assertValues(this.rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
	}
	
	@Test
	public void testAddRectangle() {
		// Add a point to this.rect
		int x1 = 13, y1 = -27;
		int x2 = -11, y2 = 23;
		int x3 = 15, y3 = 33;
		testAdd(this.rect, x3, y3, true);
		assertValues(this.rect, x3, y3, x3, y3, 1, 1);
		
		// Create a new rect, add two points, and check correctness
		Rectangle rect = new Rectangle();
		testAdd(rect, x1, y1, true);
		assertValues(rect, x1, y1, x1, y1, 1, 1);
		testAdd(rect, x2, y2, true);
		int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
		int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);
		assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
		
		// Add rect to this.rect, and check correctness
		Assertions.assertTrue(this.rect.add(rect));
		int minX1X2X3 = Math.min(minX1X2, x3), minY1Y2Y3 = Math.min(minY1Y2, y3);
		int maxX1X2X3 = Math.max(maxX1X2, x3), maxY1Y2Y3 = Math.max(maxY1Y2, y3);
		assertValues(this.rect, minX1X2X3, minY1Y2Y3, maxX1X2X3, maxY1Y2Y3, maxX1X2X3 - minX1X2X3 + 1, maxY1Y2Y3 - minY1Y2Y3 + 1);
	}
	
	@Test
	public void testAddSameRectangle() {
		// Create a rectangle from two points, and check correctness
		int x1 = 13, y1 = -27;
		int x2 = -11, y2 = 23;
		Rectangle rect = new Rectangle();
		testAdd(rect, x1, y1, true);
		assertValues(rect, x1, y1, x1, y1, 1, 1);
		testAdd(rect, x2, y2, true);
		int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
		int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);
		assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
		
		// First time rectangle is added, add should return true and this.rect be updated
		Assertions.assertTrue(this.rect.add(rect));
		assertValues(this.rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
		
		// Second time, add should return false and this.rect should remain the same.
		Assertions.assertFalse(this.rect.add(rect));
		assertValues(this.rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
	}
	
	@Test
	public void testUnion() {
		int x1 = 13, y1 = -27;
		int x2 = -11, y2 = 23;
		int x3 = 15, y3 = 33;
		int x4 = 17, y4 = -33;
		
		// Add values to this.rect and check correctness
		testAdd(this.rect, x3, y3, true);
		assertValues(this.rect, x3, y3, x3, y3, 1, 1);
		testAdd(this.rect, x4, y4, true);
		int minX3X4 = Math.min(x3, x4), minY3Y4 = Math.min(y3, y4);
		int maxX3X4 = Math.max(x3, x4), maxY3Y4 = Math.max(y3, y4);
		assertValues(this.rect, minX3X4, minY3Y4, maxX3X4, maxY3Y4, maxX3X4 - minX3X4 + 1, maxY3Y4 - minY3Y4 + 1);
		
		// Create a new rect, and check correctness
		Rectangle rect = new Rectangle();
		testAdd(rect, x1, y1, true);
		assertValues(rect, x1, y1, x1, y1, 1, 1);
		testAdd(rect, x2, y2, true);
		int minX1X2 = Math.min(x1, x2), minY1Y2 = Math.min(y1, y2);
		int maxX1X2 = Math.max(x1, x2), maxY1Y2 = Math.max(y1, y2);
		assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
		
		// Take the union (both ways), and check that both 
		int minX = Math.min(minX1X2, minX3X4), minY = Math.min(minY1Y2, minY3Y4);
		int maxX = Math.max(maxX1X2, maxX3X4), maxY = Math.max(maxY1Y2, maxY3Y4);
		Rectangle union1 = this.rect.union(rect);
		assertValues(union1, minX, minY, maxX, maxY, maxX - minX + 1, maxY - minY + 1);
		assertValues(this.rect, minX3X4, minY3Y4, maxX3X4, maxY3Y4, maxX3X4 - minX3X4 + 1, maxY3Y4 - minY3Y4 + 1);
		assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
		Rectangle union2 = rect.union(this.rect);
		assertValues(union2, minX, minY, maxX, maxY, maxX - minX + 1, maxY - minY + 1);
		assertValues(this.rect, minX3X4, minY3Y4, maxX3X4, maxY3Y4, maxX3X4 - minX3X4 + 1, maxY3Y4 - minY3Y4 + 1);
		assertValues(rect, minX1X2, minY1Y2, maxX1X2, maxY1Y2, maxX1X2 - minX1X2 + 1, maxY1Y2 - minY1Y2 + 1);
	}
}
