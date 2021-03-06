package interfaces.twitter;

import junit.framework.TestCase;
import org.junit.Test;

@SuppressWarnings("all")
public class FollowersCountComparatorTest extends TestCase {
  private FollowersCountComparator comparator;

  private FollowersCountComparator _init_comparator() {
    FollowersCountComparator _followersCountComparator = new FollowersCountComparator();
    return _followersCountComparator;
  }

  private TwitterAccount aaron;

  private TwitterAccount _init_aaron() {
    TwitterAccount _twitterAccount = new TwitterAccount("aaron");
    return _twitterAccount;
  }

  private TwitterAccount ben;

  private TwitterAccount _init_ben() {
    TwitterAccount _twitterAccount = new TwitterAccount("ben");
    return _twitterAccount;
  }

  private TwitterAccount charlie;

  private TwitterAccount _init_charlie() {
    TwitterAccount _twitterAccount = new TwitterAccount("charlie");
    return _twitterAccount;
  }

  @Override
  protected void setUp() {
    comparator = _init_comparator();
    aaron = _init_aaron();
    ben = _init_ben();
    charlie = _init_charlie();

  }

  @Test
  public void testCompare() {
    _transition_exprAction__compare_transitions0_actions0();
    _transition_exprAction__compare_transitions0_actions1();
    _test__compare_transitions0_effect_state();
    _transition_exprAction__compare_transitions1_actions0();
    _test__compare_transitions1_effect_state();

  }

  private void _transition_exprAction__compare_transitions0_actions0() {
    try {

      this.aaron.follow(this.ben);
      } catch (junit.framework.AssertionFailedError error) {
      fail("aaron.follow(ben) failed: " + error.getMessage());
    }

  }

  private void _transition_exprAction__compare_transitions0_actions1() {
    try {

      this.ben.follow(this.aaron);
      } catch (junit.framework.AssertionFailedError error) {
      fail("ben.follow(aaron) failed: " + error.getMessage());
    }

  }

  private void _test__compare_transitions0_effect_state() {
    _test__compare_transitions0_effect_state_objectTests0_test();

  }

  private void _test__compare_transitions0_effect_state_objectTests0_test() {

    int _compare = this.comparator.compare(this.aaron, this.ben);
    assertEquals("comparator.compare(aaron, ben) == 0 failed after aaron.follow(ben) ,ben.follow(aaron)", 0, _compare);

  }

  private void _transition_exprAction__compare_transitions1_actions0() {
    try {

      this.charlie.follow(this.ben);
      } catch (junit.framework.AssertionFailedError error) {
      fail("charlie.follow(ben) failed: " + error.getMessage());
    }

  }

  private void _test__compare_transitions1_effect_state() {
    _test__compare_transitions1_effect_state_objectTests0_test();

  }

  private void _test__compare_transitions1_effect_state_objectTests0_test() {

    int _compare = this.comparator.compare(this.aaron, this.ben);
    boolean _greaterThan = (_compare > 0);
    assertTrue("comparator.compare(aaron, ben) > 0 failed after charlie.follow(ben)", _greaterThan);

    int _compare_1 = this.comparator.compare(this.ben, this.aaron);
    assertTrue("comparator.compare(ben, aaron) < 0 failed after charlie.follow(ben)", (_compare_1 < 0));

  }

}
