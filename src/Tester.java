import java.util.Scanner;

public class Tester extends PokerPlayer {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int again = 1;
        while (again == 1) { //as long as the user wants to keep playing
            PokerGame pokerGame = new PokerGame(); //starting new pokerGame.
            pokerGame.play(); //calling play method
            System.out.println();

            if (money > 0) {
                System.out.println("Would you like to play again?(1 - yes/0 - no)");
                again = input.nextInt(); //integer entered determines if we play or break out of loop
            }
        }

        System.out.println("Thank you for playing,made by Konstantinas K.      Your cash :" + money); //get money.

    }

}

