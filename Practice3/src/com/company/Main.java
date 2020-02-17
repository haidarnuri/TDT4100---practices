package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CardDeck cardDeck = new CardDeck(2);
        System.out.println(cardDeck);
        cardDeck.shufflePerfectly();
        System.out.println(cardDeck);
        cardDeck.shufflePerfectly();
        System.out.println(cardDeck);

    }
}
