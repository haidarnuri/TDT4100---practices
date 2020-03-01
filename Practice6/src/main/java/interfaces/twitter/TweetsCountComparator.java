package interfaces.twitter;

import java.util.Comparator;

public class TweetsCountComparator implements Comparator<TwitterAccount> {
    
    @Override
    public int compare(TwitterAccount twitterAccount, TwitterAccount t1) {
        return t1.getTweetCount() - twitterAccount.getTweetCount();
    }
}
