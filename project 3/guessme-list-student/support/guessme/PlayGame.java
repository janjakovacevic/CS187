package guessme;

import javax.swing.JOptionPane;

public class PlayGame {
	// Computer as the player of the game
	public static void main(String[] args) {
		LinkedListGame gamer = new LinkedListGame();
		
		JOptionPane.showMessageDialog(null, "Think of a number between 1000 and 9999.\n Click OK when you are ready...",
				"Let's play a game", JOptionPane.INFORMATION_MESSAGE);
		
		int guess=0, nmatches=0;
		while(!gamer.isOver()) {
			// take guess
			guess = gamer.getGuess();
			String userInput = JOptionPane.showInputDialog("I guess your number is " + guess + ". How many digits are matched?");
			if (userInput == null)
				System.exit(0);
			try {
				nmatches = Integer.parseInt(userInput.trim());
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Invalid. Please enter a number between 0 and 4", "Warning",
						JOptionPane.WARNING_MESSAGE);
				continue;
			}
			// the number of matches must be between 0 and 4
			if (nmatches < 0 || nmatches > 4) {
				JOptionPane.showMessageDialog(null, "Invalid. Please enter a number between 0 and 4", "Warning",
						JOptionPane.WARNING_MESSAGE);
				continue;
			}
			// update based on user input
			if(gamer.updateGuess(nmatches)==false) {
				JOptionPane.showMessageDialog(null, "Something is wrong. I don't think your number exists...", "Mistake",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		}
		System.out.println("I got it. Your number was "+guess+".");
		System.out.println("I did it in "+gamer.numGuesses()+" rounds. Here is the list of my guesses:");
		System.out.println(gamer.priorGuessesString());
	}
}
