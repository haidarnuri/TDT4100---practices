package interfaces.twitter;

import objectstructures.TwitterAccount;

import java.util.Comparator;

public class FollowersCountComparator implements Comparator<TwitterAccount> {

    @Override
    public int compare(TwitterAccount twitterAccount, TwitterAccount t1) {
        return t1.getNumberOfIGetFollowedBy()-twitterAccount.getNumberOfIGetFollowedBy();
    }
}
