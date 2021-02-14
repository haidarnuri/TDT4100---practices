package stateandbehavior;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class AccountTest {
	private double delta = 1e-8;
	
	private Account account;
	
	@BeforeEach
	public void setup() {
		account = new Account();
	}
	
	@Test
	@DisplayName("Konstruktør")
	public void testConstructor() {
		Assertions.assertEquals(0.0, account.getBalance(), delta);
	}
	
	@Test
	@DisplayName("Innskudd")
	public void testDeposit() {
		account.deposit(100);
		
		Assertions.assertEquals(100.0, account.getBalance(), delta);
	}
	
	@Test
	@DisplayName("Negativt innskudd")
	public void testNegativeDeposit() {
		account.deposit(-50);
		
		Assertions.assertEquals(0.0, account.getBalance(), delta);
	}
	
	@Test
	@DisplayName("Legge til renter") 
	public void testAddInterest() {
		account.setInterestRate(5);
		
		Assertions.assertEquals(0, account.getBalance(), delta);
		Assertions.assertEquals(5, account.getInterestRate(), delta);
		
		account.deposit(100);
		Assertions.assertEquals(100, account.getBalance(), delta);
		
		account.addInterest();
		Assertions.assertEquals(105,  account.getBalance(), delta);
	}
}