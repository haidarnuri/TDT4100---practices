package com.company;
import java.util.ArrayList;

public class CardDeck {
    ArrayList<Card> cardDeck = new ArrayList<Card>();

   public CardDeck(int n) {
        for (int i = 1; i < n+1; i++) {
            addCard(new Card('S', i));
        }
        for (int i = 1; i < n+1; i++) {
            addCard(new Card('H', i));
        }
        for (int i = 1; i < n+1; i++) {
            addCard(new Card('D', i));
        }

        for (int i = 1; i < n+1; i++) {
            addCard(new Card('C', i));
        }
    }

    public void addCard(Card cardSpades) {
        if (!cardDeck.contains(cardSpades)) {
            this.cardDeck.add(cardSpades);
        }
    }

    public int getCardCount() {
        return cardDeck.size();
    }

    public Card getCard(int n) {
        if (n < getCardCount()) {
            return cardDeck.get(n);
        } else {
            throw new IllegalArgumentException("There is not that many cards in the carddeck");
        }
    }


    public void shufflePerfectly(){
        var tempList = new ArrayList<Card>();
    for (int i = 0; i<getCardCount(); i++) {
    if(i %2 == 1) {
    tempList.add(getCard(getCardCount()/2 + (i-1)/2));
    }
    else {
    tempList.add(getCard(i/2));
    }
   
    }
      cardDeck = tempList;      
    }

    @Override
    public String toString(){
        return "your list is " + cardDeck;
    }
}
