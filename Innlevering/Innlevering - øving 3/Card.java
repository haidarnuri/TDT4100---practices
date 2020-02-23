package encapsulation;

public class Card {

    private char suit; //Kortfargen
    private int face; //tallverdien

    public Card(char suit, int face) {
        this.setSuit(suit);
        this.setFace(face);
    }


    public char getSuit() {
        return this.suit;
    }



    public int getFace() {
        return this.face;
    }


    public void setSuit(char suit) {
        if(validSuit(suit)) {
            this.suit = suit;
        }
        else{
            throw new IllegalArgumentException("This is noe av valid suit");
        }
    }

    public void setFace(int face) {
        if(validFace(face)){
            this.face = face;
        }
        else{
            throw new IllegalArgumentException("This is noe av valid face");
        }

    }

    @Override
    public String toString(){
        return String.valueOf(getSuit()) + getFace();
    }

    //Alle private metoder under her.

    private boolean validFace(int face){
        return face<=13 && face>=1;
    }

    private boolean validSuit(char suit){
        return suit == 'S' || suit == 'H' || suit == 'D' || suit == 'C';
    }




}


