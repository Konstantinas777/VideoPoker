
import java.util.ArrayList;
import java.util.Collections;

public class PokerDeck {

    // creating  empty array of pokerCards
    private ArrayList<PokerCards> pokerCards = new ArrayList<PokerCards>();

    public PokerDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                PokerCards newPokerCards = new PokerCards(i, j);
                pokerCards.add(newPokerCards); //each card (suit and value) by toSring -  add to the array - PokerDeck

            }
        }

        shuffle();//shuffling pokerDeck
    }

    public void shuffle() {

        Collections.shuffle(pokerCards);//Pre-written tool
    }

    //method that is return card drawn.
    public PokerCards draw() {
        PokerCards returnPokerCards = pokerCards.get(0);  //gets the first card of the array (after shuffling)
        pokerCards.remove(0); //Also removes it from the array.
        return returnPokerCards;

    }
}


