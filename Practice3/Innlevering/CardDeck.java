package encapsulation;

import java.util.ArrayList;

public class CardDeck {
    ArrayList<Card> cardDeck = new ArrayList<Card>();

   public CardDeck(int n) {
	   SetCardDeck(n);
    }

    public void addCard(Card card) {
        this.cardDeck.add(card);
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
    var tempCardDeck = new ArrayList<Card>();
    
    for (int i = 0; i<getCardCount(); i++) {
    
    if(i %2 == 1) {
    	tempCardDeck.add(getCard(getCardCount()/2 + (i-1)/2));
    }
    
    else {
    	tempCardDeck.add(getCard(i/2));
    }
   
    }
      cardDeck = tempCardDeck;      
    }

    @Override
    public String toString(){
        return "your list is " + cardDeck;
    }

    //All private methods
    
    private void shuffle(int lenght) {
    	
    }
    
    
    
    private void SetCardDeck(int n) {
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





}
