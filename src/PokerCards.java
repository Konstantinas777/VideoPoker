
public class PokerCards implements Comparable<PokerCards> { //  Interface

    private int suit;
    private int value;
    private final static String[] suits = {"♣", "♦", "♥", "♠"};
    private final static String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};


    //Constructor
    public PokerCards(int s, int v) {
        suit = s;
        value = v;
    }

    public int getSuit() { //method that returns suit integer
        return suit;
    }

    public int getValue() {
        return value;
    }

    //method : suit and value
    public String toString() {
        String info = values[value] + " of " + suits[suit];
        return info;
    }

    // method : cards are comparing to each other - next Sorting method
    public int compareTo(PokerCards other) {
        if (this.getValue() > other.getValue())
            return 1;
        else if (this.getValue() < other.getValue())
            return -1;
        else
            return 0;
    }

}


