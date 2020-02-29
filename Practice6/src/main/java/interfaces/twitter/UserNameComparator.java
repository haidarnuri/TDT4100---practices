package interfaces.twitter;

import objectstructures.TwitterAccount;

import java.util.Comparator;

public class UserNameComparator implements Comparator<TwitterAccount> {

    @Override
    public int compare(TwitterAccount twitterAccount, TwitterAccount t1) {
        return twitterAccount.getUserName().compareTo(t1.getUserName());
    }
}
