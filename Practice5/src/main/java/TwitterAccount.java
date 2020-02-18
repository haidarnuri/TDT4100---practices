import java.util.ArrayList;
import java.util.Collection;



public class TwitterAccount {

    public Collection<Tweet> tweetList = new ArrayList<Tweet>();
    public Collection<TwitterAccount> follows = new ArrayList<TwitterAccount>();

    public String userName;
    public int tweetCount;
    public int retweetCount;

    public Tweet retweet;

    public TwitterAccount(String userName) {
        this.userName=userName;
    }

    public void follows(TwitterAccount account) {
        if(!follows.contains(account)) {
            follows.add(account);
        }
    }

    public void unfollow(TwitterAccount account) {
        follows.remove(account);
    }

    public boolean isFollowing(TwitterAccount account) {
        return follows.contains(account);
    }

    public boolean isFollowedBy(TwitterAccount account) {
        TwitterAccount tempAccount = new TwitterAccount(this.userName);
        return account.follows.contains(tempAccount);
    }



    public String getUserName() {
        return this.userName;
    }

    public void tweet(Tweet newTweet) {
        if(!tweetList.contains(newTweet)) {
            this.tweetCount+=1;
            this.tweetList.add(newTweet);
        }
    }

    public void retweet(Tweet tweet) {
        TwitterAccount tempAccount = new TwitterAccount(this.userName);
        if(this.tweetList.contains(tweet)) {
            this.retweetCount+=1;
            retweet = new Tweet(tempAccount,tweet);
        }
    }

    public Tweet getTweet(int i) {
        int counter = 0;
        Tweet tempTweet = null;
        for(Tweet e: tweetList) {
            counter+=1;
            if(counter==i) {
                tempTweet = e;
            }
        }
        return tempTweet;
    }

    public int getTweetCount() {
        return tweetCount;

    }

    public int getRetweetCount() {
        return 	this.retweetCount;

    }
}