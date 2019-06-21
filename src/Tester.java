import java.util.Scanner;
public class Tester {

	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int again = 1;
		while (again == 1) { //as long as the user wants to keep playing
		PokerGame pokerGame =new PokerGame(); //starting new pokerGame.
		pokerGame.play(); //calling play method
		
		System.out.println();
		System.out.println("Would you like to play again?(1 - yes/0 - no)");
		again = input.nextInt(); //integer entered determines if we play or break out of loop
		}
		
		System.out.println("Thank you for playing,game made by Konstantinas K. :) ");

	}

}
