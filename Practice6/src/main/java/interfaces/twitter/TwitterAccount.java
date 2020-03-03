package interfaces.twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class TwitterAccount {

    private String userName;
    private int retweetCount;
    private int followerCount;

    // private TwitterAccount thisAccount;
    private ArrayList<Tweet> tweetArrayList = new ArrayList<>();
    private ArrayList<TwitterAccount> listFollowers = new ArrayList<>();



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
            follower.followerCount++;
            listFollowers.add(follower);
        }
    }

    public void unfollow(TwitterAccount userToUnfollow){
        if(listFollowers.contains(userToUnfollow)) {
            userToUnfollow.followerCount--;
            listFollowers.remove(userToUnfollow);
        }
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

    public int getTweetCount() {return getTweetArrayList().size();}


     public int getFollowerCount(){
        return this.followerCount;
     }

     public ArrayList<TwitterAccount> getListFollowers(Comparator<TwitterAccount> l){
        ArrayList<TwitterAccount> tempList = new ArrayList<>(this.listFollowers);
        if(l.equals(null)) {
            return this.listFollowers;
        }
        else{
            Collections.sort(tempList,l);
            return tempList;
        }
     }

     private ArrayList<Tweet> getTweetArrayList() {return tweetArrayList;}

}
