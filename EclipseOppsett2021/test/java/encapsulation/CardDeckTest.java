package encapsulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;

public class CardDeckTest {
	
	private CardDeck cardDeck;
	
	private void checkDeck(CardDeck deck, String deckAsString) {
		Collection<String> toStrings = Arrays.asList(deckAsString.split(","));
		Assertions.assertEquals(deck.getCardCount(), toStrings.size());
		int i = 0;
		for(String toString : toStrings) {
			Card card = deck.getCard(i);
			String cardString = String.valueOf(card.getSuit()) + card.getFace();
			Assertions.assertEquals(cardString, toString);
			i++;
		}
	}
	
	@BeforeEach
	public void setup() {
		cardDeck = new CardDeck(2);
	}
	
	@Test
	public void testConstructor() {
		checkDeck(cardDeck, "S1,S2,H1,H2,D1,D2,C1,C2");
	}
	
	@Test
	public void testShufflePerfectly() {
		cardDeck.shufflePerfectly();
		checkDeck(cardDeck, "S1,D1,S2,D2,H1,C1,H2,C2");
	}
	
	
}
