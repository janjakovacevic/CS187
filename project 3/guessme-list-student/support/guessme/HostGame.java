package guessme;

import java.util.Random;
import java.util.Scanner;

public class HostGame {
	// Computer as the host of the game
	public static void main(String[] args) {
		Random rnd = new Random();
		Scanner conIn = new Scanner(System.in);
		
		int groundtruth = rnd.nextInt(9000)+1000;
		
		System.out.println("I have thought of a number for you to guess. Let's play!");
		
		int nguesses = 0;
		while(true) {
			// take guess
			System.out.print("What's your guess? Input a 4-digit integer: ");
			int guess;
			try {
				guess = conIn.nextInt();
			} catch(Exception e) {
				conIn.nextLine();
				System.out.println("Invalid input!");
				continue;
			}
			if(guess<1000 || guess>9999) {
				System.out.println("Your number is out of range!");
				continue;
			}
			nguesses ++;
			int nmatches = LinkedListGame.numMatches(guess, groundtruth);
			if(nmatches==4) {
				System.out.print("You have won! ");
				break;
			}
			else {
				System.out.println("Almost there. Number of matches: "+nmatches);
			}
		}
		System.out.println("The number I had was "+groundtruth);
		System.out.println("You got it in "+nguesses+" rounds.");
		conIn.close();
	}
}
