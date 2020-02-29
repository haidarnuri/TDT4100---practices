package interfaces.twitter;

import objectstructures.TwitterAccount;

import java.util.Comparator;

public class TweetsCountComparator implements Comparator<TwitterAccount> {
    
    @Override
    public int compare(TwitterAccount twitterAccount, TwitterAccount t1) {
        return twitterAccount.getTweetCount() - t1.getTweetCount();
    }
}
