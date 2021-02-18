package encapsulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RPNCalcTest{
	
	private RPNCalc calc;
	
	@BeforeEach
	public void setup() {
		calc = new RPNCalc();
	}
	
	@Test
	public void testPush() {
		calc.push(1.0);
		Assertions.assertEquals(1.0, calc.peek(0));
		
		calc.push(2.0);
		Assertions.assertEquals(2.0, calc.peek(0));
		
		calc.push(3.0);
		Assertions.assertEquals(3.0, calc.peek(0));
	}
	
	@Test
	public void testPop() {
		calc.push(1.0);
		calc.push(2.0);
		calc.push(3.0);
		Assertions.assertEquals(3.0, calc.peek(0));
		
		Assertions.assertEquals(3.0, calc.pop());
		Assertions.assertEquals(2.0, calc.peek(0));
		
		Assertions.assertEquals(2.0, calc.pop());
		Assertions.assertEquals(1.0, calc.peek(0));
		
		calc.push(2.0);
		Assertions.assertEquals(2.0, calc.peek(0));
		
		Assertions.assertEquals(2.0, calc.pop());
		Assertions.assertEquals(1.0, calc.peek(0));
		
		Assertions.assertEquals(1.0, calc.pop());
		Assertions.assertEquals(0, calc.getSize());
	}
	
	@Test
	public void testPeek() {
		calc.push(0.0);
		calc.push(1.0);
		calc.push(2.0);
		Assertions.assertEquals(2.0, calc.peek(0));
		Assertions.assertEquals(1.0, calc.peek(1));
		Assertions.assertEquals(0.0, calc.peek(2));
	}
	
	@Test
	public void testEmptyStack() {
		Assertions.assertEquals(Double.NaN, calc.peek(3));
		Assertions.assertEquals(Double.NaN, calc.peek(-1));
	}
	
	@Test
	public void testGetSize() {
		Assertions.assertEquals(0, calc.getSize());
		calc.push(1.0);
		Assertions.assertEquals(1, calc.getSize());
		calc.push(2.0);
		Assertions.assertEquals(2, calc.getSize());
	}
	
	@Test
	public void testAddOperation() {
		calc.push(3.0);
		calc.push(4.0);
		calc.performOperation('+');
		Assertions.assertEquals(1, calc.getSize());
		Assertions.assertEquals(7.0, calc.peek(0));
	}
	
	@Test
	public void testSubOperation() {
		calc.push(7.0);
		calc.push(2.0);
		calc.performOperation('-');
		Assertions.assertEquals(1, calc.getSize());
		Assertions.assertEquals(5.0, calc.peek(0));
	}
	
	@Test
	public void testMultOperation() {
		calc.push(5.0);
		calc.push(2.0);
		calc.performOperation('*');
		Assertions.assertEquals(1, calc.getSize());
		Assertions.assertEquals(10.0, calc.peek(0));
	}
	
	@Test
	public void testDivOperation() {
		calc.push(10.0);
		calc.push(4.0);
		calc.performOperation('/');
		Assertions.assertEquals(1, calc.getSize());
		Assertions.assertEquals(2.5, calc.peek(0));
	
	}
	
}
