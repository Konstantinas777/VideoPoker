

public class PokerGame {

    private PokerPlayer user;
    public static PokerDeck pokerDeck;

    public PokerGame() {
        user = new PokerPlayer();
        pokerDeck = new PokerDeck();
    }
    // drawing 5 cards and adds a pokerCards to the array(player Class)
    public void play() {

        for (int i = 0; i < 5; i++) {
            PokerCards pokerCards = pokerDeck.draw();
            user.addCard(pokerCards);
        }

        System.out.println("( Your cards are : \n");

        System.out.println(user.toString()); //shows user initial cards

        user.rejectCards();    // carries out method in player class if user rejects cards.

        System.out.println();

        System.out.println(user.categorizeHand()); //Scores the user's hand.
    }


}
