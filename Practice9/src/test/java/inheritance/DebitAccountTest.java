package inheritance;

import junit.framework.TestCase;

import org.junit.Test;
@SuppressWarnings("all")
public class DebitAccountTest extends TestCase {
  private DebitAccount sub;
  
  private DebitAccount _init_sub() {
    DebitAccount _debitAccount = new DebitAccount();
    return _debitAccount;
  }
  
  @Override
  protected void setUp() {
    sub = _init_sub();
    
  }

  @Test
  public void testDeposit() {
    _test__deposit_transitions0_source_state(sub);
    _transition_exprAction__deposit_transitions0_actions0(sub);
    _test__deposit_transitions0_effects0_state(sub);
    try {
      _transition_exprAction__deposit_transitions1_actions0(sub);
      fail("IllegalArgumentException should be thrown after deposit(-10000.0)");
    } catch (Exception e) {
      assertTrue("IllegalArgumentException should be thrown after deposit(-10000.0)", e instanceof IllegalArgumentException);
    }
    _test__deposit_transitions2_effects0_state(sub);
    
  }

  @Test
  public void testWithdraw() {
    _transition_exprAction__withdraw_transitions0_actions0(sub);
    _transition_exprAction__withdraw_transitions0_actions1(sub);
    _test__withdraw_transitions0_effects0_state(sub);
    try {
      _transition_exprAction__withdraw_transitions1_actions0(sub);
      fail("IllegalArgumentException should be thrown after withdraw(-10000.0)");
    } catch (Exception e) {
      assertTrue("IllegalArgumentException should be thrown after withdraw(-10000.0)", e instanceof IllegalArgumentException);
    }
    _test__withdraw_transitions2_effects0_state(sub);
    try {
      _transition_exprAction__withdraw_transitions3_actions0(sub);
      fail("IllegalStateException should be thrown after withdraw(20000.0)");
    } catch (Exception e_1) {
      assertTrue("IllegalStateException should be thrown after withdraw(20000.0)", e_1 instanceof IllegalStateException);
    }
    _test__withdraw_transitions4_effects0_state(sub);
    
  }
  
  private void _test__deposit_transitions0_source_state(final DebitAccount it) {
    _test__deposit_transitions0_source_state_objectTests0_test(sub);
    
  }
  
  private void _test__deposit_transitions0_source_state_objectTests0_test(final DebitAccount it) {
    
    double _balance = it.getBalance();
    assertEquals("getBalance() == 0.0 failed after deposit(10000.0)", 0.0, _balance);
    
  }
  
  private void _transition_exprAction__deposit_transitions0_actions0(final DebitAccount it) {
    try {
      
      it.deposit(10000.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("deposit(10000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__deposit_transitions0_effects0_state(final DebitAccount it) {
    _test__deposit_transitions0_effects0_state_objectTests0_test(sub);
    
  }
  
  private void _test__deposit_transitions0_effects0_state_objectTests0_test(final DebitAccount it) {
    
    double _balance = it.getBalance();
    assertEquals("getBalance() == 10000.0 failed after deposit(10000.0)", 10000.0, _balance);
    
  }
  
  private void _transition_exprAction__deposit_transitions1_actions0(final DebitAccount it) {
    try {
      
      it.deposit((-10000.0));
      } catch (junit.framework.AssertionFailedError error) {
      fail("deposit(-10000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__deposit_transitions2_effects0_state(final DebitAccount it) {
    _test__deposit_transitions2_effects0_state_objectTests0_test(sub);
    
  }
  
  private void _test__deposit_transitions2_effects0_state_objectTests0_test(final DebitAccount it) {
    
    double _balance = it.getBalance();
    assertEquals("getBalance() == 10000.0 failed", 10000.0, _balance);
    
  }
  
  private void _transition_exprAction__withdraw_transitions0_actions0(final DebitAccount it) {
    try {
      
      it.deposit(20000.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("deposit(20000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__withdraw_transitions0_actions1(final DebitAccount it) {
    try {
      
      it.withdraw(5000.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("withdraw(5000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__withdraw_transitions0_effects0_state(final DebitAccount it) {
    _test__withdraw_transitions0_effects0_state_objectTests0_test(sub);
    
  }
  
  private void _test__withdraw_transitions0_effects0_state_objectTests0_test(final DebitAccount it) {
    
    double _balance = it.getBalance();
    assertEquals("getBalance() == 15000.0 failed after deposit(20000.0) ,withdraw(5000.0)", 15000.0, _balance);
    
  }
  
  private void _transition_exprAction__withdraw_transitions1_actions0(final DebitAccount it) {
    try {
      
      it.withdraw((-10000.0));
      } catch (junit.framework.AssertionFailedError error) {
      fail("withdraw(-10000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__withdraw_transitions2_effects0_state(final DebitAccount it) {
    _test__withdraw_transitions2_effects0_state_objectTests0_test(sub);
    
  }
  
  private void _test__withdraw_transitions2_effects0_state_objectTests0_test(final DebitAccount it) {
    
    double _balance = it.getBalance();
    assertEquals("getBalance() == 15000.0 failed", 15000.0, _balance);
    
  }
  
  private void _transition_exprAction__withdraw_transitions3_actions0(final DebitAccount it) {
    try {
      
      it.withdraw(20000.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("withdraw(20000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__withdraw_transitions4_effects0_state(final DebitAccount it) {
    _test__withdraw_transitions4_effects0_state_objectTests0_test(sub);
    
  }
  
  private void _test__withdraw_transitions4_effects0_state_objectTests0_test(final DebitAccount it) {
    
    double _balance = it.getBalance();
    assertEquals("getBalance() == 15000.0 failed", 15000.0, _balance);
    
  }
}
