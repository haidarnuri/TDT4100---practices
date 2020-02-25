package objectstructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Tweet {

    private String text;
    private Tweet originalTweet;
    public boolean isRetweet = false;

    private int retweetCount = 0;
    private TwitterAccount owner;

    //First creating two constructors
    public Tweet(TwitterAccount owner, String text) {
        this.text = text;
        this.owner = owner;
        this.isRetweet = false;
    }

    public Tweet(TwitterAccount owner, Tweet retweet) {
        if(retweet.getOwner().equals(owner)){
            throw new IllegalArgumentException("The same owner");
        }
        retweet.retweetCount += 1;
        this.text = retweet.getText();
        this.owner = owner;
        if(retweet.isRetweet){
            this.originalTweet = retweet.originalTweet;
        }else{
            this.originalTweet = retweet;
        }
        this.isRetweet = true;
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


