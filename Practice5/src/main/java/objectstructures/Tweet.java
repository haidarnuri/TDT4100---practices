package objectstructures;

public class Tweet {

    private String tweetText;
    private Tweet originalTweet;

    private int retweetCount;

    private TwitterAccount account;

    //First creating two constructors
    public Tweet(TwitterAccount account, String tweetText) {
        this.tweetText = tweetText;
        this.account = account;
    }

    public Tweet(TwitterAccount account, Tweet tweet) {
        this.account = account;
        this.retweetCount+=1;
        for (Tweet e: account.tweetList) {
            if(account.tweetList.contains(tweet)) {
                this.originalTweet = e;
            }
            else {
                this.tweetText = tweet.getTweetText();
            }
        }
    }

    public String getTweetText() {
        return this.tweetText;
    }
    public String getText() {
        return this.getTweetText();
    }

    public TwitterAccount getOwner() {
        return this.account;
    }

    public Tweet getOriginalTweet() {
        return this.originalTweet;
    }

    public int getRetweetCount() {
        return this.retweetCount;
    }
}


