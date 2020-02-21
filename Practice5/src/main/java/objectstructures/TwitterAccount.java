package objectstructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TwitterAccount {

    private String userName;
    private String tweetText;
    private int tweetCount;


    private TwitterAccount thisAccount;
    private ArrayList<Tweet> tweetArrayList = new ArrayList<Tweet>();

    public TwitterAccount(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void tweet(String tweetText){
        this.tweetCount +=1;
        this.thisAccount = new TwitterAccount(this.userName);
        tweetArrayList.add(new Tweet(this.thisAccount,tweetText));
    }

    public int getTweetCount() {
        return this.tweetCount;
    }
}
