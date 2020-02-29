package objectstructures;

import java.util.ArrayList;


public class TwitterAccount {

    private String userName;
    private int retweetCount;


    // private TwitterAccount thisAccount;
    private ArrayList<Tweet> tweetArrayList = new ArrayList<Tweet>();
    private ArrayList<TwitterAccount> listFollowers = new ArrayList<TwitterAccount>();

    private ArrayList<TwitterAccount> listFollowedBy = new ArrayList<TwitterAccount>();


    public TwitterAccount(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void tweet(String tweetText){
        Tweet newTweet = new Tweet(this, tweetText);
        tweetArrayList.add(newTweet);
    }

    public void follow(TwitterAccount follower){
        if(!listFollowers.contains(follower)){
            listFollowers.add(follower);
        }
    }

    public void unfollow(TwitterAccount userToUnfollow){
        listFollowers.remove(userToUnfollow);
    }

    public boolean isFollowing(TwitterAccount doIFollowUser){
        return listFollowers.contains(doIFollowUser);
    }

    public boolean isFollowedBy(TwitterAccount checkIfFollowedBy){
        return checkIfFollowedBy.listFollowers.contains(this);
    }

    public void retweet(Tweet tweet){

      if(!tweetArrayList.contains(tweet)) {
            tweetArrayList.add(new Tweet(this, tweet));
            if(tweet.isRetweet){
                tweet.getOriginalTweet().getOwner().retweetCount++;
            }else{
                tweet.getOwner().retweetCount++;
            }
      }
    }

    //Start from the last element in tweetArrayList
    public Tweet getTweet(int i){
        return tweetArrayList.get(tweetArrayList.size()-i);

    }

    public int getRetweetCount(){
        return retweetCount;
    }

    public int getTweetCount() {
        return getTweetArrayList().size();
    }

    public ArrayList<TwitterAccount> setListFollowedBy(TwitterAccount followedBy) {
        if(isFollowedBy(followedBy)){
        this.listFollowedBy.add(followedBy);
        }
        return this.listFollowedBy;
    }

    public ArrayList<TwitterAccount> getListFollowedBy() {
        return this.listFollowedBy;
    }

    private ArrayList<Tweet> getTweetArrayList() {
        return tweetArrayList;
    }


}
