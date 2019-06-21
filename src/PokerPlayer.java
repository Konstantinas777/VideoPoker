import java.util.ArrayList;
import java.util.Scanner;

public class PokerPlayer extends PokerCash {

    private ArrayList<PokerCards> hand = new ArrayList<PokerCards>(); // user's hand is created as a blank array
    private Scanner input = new Scanner(System.in);

    public PokerPlayer() {

    }

    //method for adding a pokerCards to hand array
    public void addCard(PokerCards pokerCards) {
        hand.add(pokerCards);


    }

    public String toString() {
        String info = "";
        for (PokerCards pokerCards : hand) {
            info += pokerCards.toString() + "\n"; //getting information of the cards only in the user's hand
        }
        return info;

    }

    public void rejectCards() {
        int reject;
        String rejected = ""; //Rejected card numbers will be taken as a string
        System.out.println("Would you like to reject any cards? (1-yes/0-no)");
        reject = input.nextInt();

        if (reject == 1) {
            System.out.println("Which card(s) would you like to reject? (Please choose from 1(first card) to 5(last card) like (15) ) : ");
            rejected = input.next();

        }

        replace(rejected); //calls method for replacing cards
    }

    private void replace(String rejected) {
        if (!rejected.equals("")) { //if the rejected string is not empty
            for (int j = 0; j < rejected.length(); j++) {//the length condition allows us to replace the number
                //of cards the user rejected.
                int cardToRemove = Integer.parseInt(rejected.substring(j, j + 1));
                PokerCards pokerCards = PokerGame.pokerDeck.draw(); //static variable pokerDeck is used here. Draws a pokerCards from it.
                hand.set(cardToRemove - 1, pokerCards); //replacing the rejected pokerCards with the new pokerCards at appropriate index.
            }
            System.out.println("Your new cards are : \n");
            System.out.println(toString());


        }
    }

    public String categorizeHand() { //method for scoring hand
        for (int i = 0; i < 5; i++) { // nested for loops are part of sorting the hand
            for (int j = 0; j < 4; j++) {
                int compare = hand.get(j).compareTo(hand.get(j + 1)); //compareTo is called. Compares values
                if (compare > 0) { //will arrange cards in ascending order of values
                    PokerCards temp = hand.get(j);
                    hand.set(j, hand.get(j + 1));
                    hand.set(j + 1, temp);
                }
            }
        }
        boolean pair = false, twopair = false, // booleans that set each score to false.
                threeofakind = false, straight = false, flush = false,
                fullhouse = false, fourofakind = false, straightflush = false,
                royalflush = false;

        for (int k = 0; k < 4; k++) { //primary for loop. Will go through each of the five cards

            if (hand.get(k).getValue() == hand.get(k + 1).getValue() //criteria for pair
                    && (k - 1 < 0 || hand.get(k - 1).getValue() != hand.get(k).getValue()) // boundary conditions for just being pair.
                    && (k + 2 > 4 || hand.get(k + 2).getValue() != hand.get(k).getValue())) {
                if (pair == true) {
                    twopair = true; //since we have a loop. this will be true if pair is true twice.

                }

                pair = true;

            }

            if ((k < 2) && hand.get(k).getValue() == hand.get(k + 1).getValue() && hand.get(k + 1).getValue()
                    == hand.get(k + 2).getValue() && hand.get(k + 2) == hand.get(k + 3)) {
                fourofakind = true; // hand with four cards of the same value.
            }

            if (!fourofakind && (k < 3) && hand.get(k).getValue() == hand.get(k + 1).getValue()
                    && hand.get(k + 1).getValue() == hand.get(k + 2).getValue()) {
                threeofakind = true; //is a subset of four a kind. Three values must be the same.

            }
            if ((k < 1) && (hand.get(k + 4).getValue() == 12 && hand.get(k).getValue() == 0 || //checking to see if we have an ace
                    hand.get(k).getValue() + 1 == hand.get(k + 1).getValue())          // and king (special case).
                    && hand.get(k + 1).getValue() + 1 == hand.get(k + 2).getValue() && //checks for consecutive values.
                    hand.get(k + 2).getValue() + 1 == hand.get(k + 3).getValue() &&
                    hand.get(k + 3).getValue() + 1 == hand.get(k + 4).getValue()) {

                straight = true;
            }
            if ((k < 1) && hand.get(k).getSuit() == hand.get(k + 1).getSuit() && //compares suit values.
                    hand.get(k + 1).getSuit() == hand.get(k + 2).getSuit() &&
                    hand.get(k + 2).getSuit() == hand.get(k + 3).getSuit() &&
                    hand.get(k + 3).getSuit() == hand.get(k + 4).getSuit()) {

                flush = true; // is true if the suit values of each card is same.
                if (straight == true) {
                    straightflush = true; // will be true if straight is true since flush will already be true.
                    royalflush = hand.get(0).getValue() == 0 && hand.get(1).getValue() == 9;


                    //royal flush is special case. If first card in sorted hand is ace
                    //and second card is 10 and since straight flush is true, we have
                    //royal flush is true.

                }

            }
        }

        fullhouse = threeofakind & pair; //only true if pair and three of a kind are true.

        if (royalflush)
            return "You have a Royal Flush!! Win 800€ (Your cash : " + addEuro(800) + " €) "; //add money.
        if (straightflush)
            return "You have a Straight Flush!! Win 50€  (Your cash :" + addEuro(50) + " €) ";
        if (fourofakind)
            return "You have a Four of a Kind!! Win 25€ (Your cash :" + addEuro(25) + " €) ";
        if (fullhouse)
            return "You have a Full House!! Win 9€ (Your cash :" + addEuro(9) + " €) ";
        if (flush)
            return "You have a Flush!! Win 6€ (Your cash :" + addEuro(6) + " €) ";
        if (straight)
            return "You have a Straight!! Win 4€ (Your cash :" + addEuro(4) + " €) ";
        if (threeofakind)
            return "You have a Three of a Kind! Win 3€ (Your cash :" + addEuro(3) + " €) ";
        if (twopair)
            return "You have Two Pairs! Win 2€ (Your cash :" + addEuro(2) + " €) ";
        if (pair)
            return "You have One Pair! Win 1€ (Your cash :" + addEuro(1) + " €) ";
        else
            return "You have No Pair! You lose 10€ (Your cash :" + addEuro(-10) + " €) "; //minus money.

    }
}
