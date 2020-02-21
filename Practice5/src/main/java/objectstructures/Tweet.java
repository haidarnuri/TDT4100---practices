package objectstructures;

public class Tweet {

    private String text;
    private Tweet retweet;
    private Tweet originalTweet;

    private int retweetCount = 0;
    private TwitterAccount owner;

    //First creating two constructors
    public Tweet(TwitterAccount owner, String text) {
        this.text = text;
        this.owner = owner;
    }

    public Tweet(TwitterAccount owner, Tweet retweet) {
        this.retweetCount +=1;
        this.text = retweet.getText();
        this.owner = owner;
        if(getOriginalTweet().equals(retweet)){
            throw new RuntimeException("the original tweet comes from the same owner");
        }

    }

    public TwitterAccount getOwner() {
        return this.owner;
    }

    public String getText(){
        return this.text;
    }

    public Tweet getOriginalTweet(){
        return this.originalTweet;
    }

    public int getRetweetCount() {
        return this.retweetCount;
    }



}


