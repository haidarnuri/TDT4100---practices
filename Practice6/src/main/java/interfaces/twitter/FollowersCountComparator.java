package interfaces.twitter;

import java.util.Comparator;

public class FollowersCountComparator implements Comparator<TwitterAccount> {

    @Override
    public int compare(TwitterAccount twitterAccount, TwitterAccount t1) {
        return t1.getFollowerCount()-twitterAccount.getFollowerCount();
    }
}
