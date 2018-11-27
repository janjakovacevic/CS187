package guessme;

/**
 * A LinkedList-based implementation of the Guess-A-Number game
 */
public class LinkedListGame {

	// TODO: declare data members as necessary
    private LLIntegerNode PG;
    private LLIntegerNode allNumbers;
    private boolean end = false;
    private int numOfGuesses = 0;
    private int guess = 1000;
   
    
   
	
	/********************************************************
	 * NOTE: for this project you must use linked lists
	 * implemented by yourself. You are NOT ALLOWED to use
	 * Java arrays of any type, or any class in the java.util
	 * package (such as ArrayList).
	 *******************************************************/	 
	
	/********************************************************
	 * NOTE: you are allowed to add new methods if necessary,
	 * but DO NOT remove any provided method, and do NOT add
	 * new files (as they will be ignored by the autograder).
	 *******************************************************/
	
	// LinkedListGame constructor method
	public LinkedListGame() {
		
		// TODO
		
		
		 PG = null;
		 end = false;
		 numOfGuesses = 0;
		 guess = 1000;
		 allNumbers = new LLIntegerNode(1000);
		 LLIntegerNode r = allNumbers;
			for(int i = 1001; i < 10000; i++){
				LLIntegerNode current = new LLIntegerNode(i);
				r.setLink(current);
				r = current;
			}		
		
	}
	
	// Resets data members and game state so we can play again
	public void reset() {
		// TODO
	 
	 PG = null;
	 end = false;
	 numOfGuesses = 0;
	 guess = 1000;
	 allNumbers = new LLIntegerNode(1000);
	 LLIntegerNode r = allNumbers;
		for(int i = 1001; i < 10000; i++){
			LLIntegerNode current = new LLIntegerNode(i);
			r.setLink(current);
			r = current;
			
		}
	}
	
	// Returns true if n is a prior guess; false otherwise.
	public boolean isPriorGuess(int n) {
		// TODO
		
		LLIntegerNode head = PG;
		if(head == null){
			return false;
		}
		else{
		while(head != null){
			if(head.getInfo() == n){
			 return true;
			}
			head = head.getLink();

		}
		}
			
		return false;
	
	}
	
	// Returns the number of guesses so far.
	public int numGuesses() {
		// TODO
		return numOfGuesses;
	}
	
	/**
	 * Returns the number of matches between integers a and b.
	 * You can assume that both are 4-digits long (i.e. between 1000 and 9999).
	 * The return value must be between 0 and 4.
	 * 
	 * A match is the same digit at the same location. For example:
	 *   1234 and 4321 have 0 match;
	 *   1234 and 1114 have 2 matches (1 and 4);
	 *   1000 and 9000 have 3 matches (three 0's).
	 */
	public static int numMatches(int a, int b) {
		// TODO
		int matches = 0;
		String aStr = Integer.toString(a);
		String bStr = Integer.toString(b);
			
		for(int i = 0; i < 4; i++){
		if(aStr.charAt(i) == bStr.charAt(i))
			matches++;
		}
			
			return matches;

	}
	
	/**
	 * Returns true if the game is over; false otherwise.
	 * The game is over if the number has been correctly guessed
	 * or if no candidate is left.
	 */
	public boolean isOver() {
		// TODO
		return end;
	}
	
	/**
	 * Returns the guess number and adds it to the list of prior guesses.
	 * The insertion should occur at the end of the prior guesses list,
	 * so that the order of the nodes follow the order of prior guesses.
	 */	
	public int getGuess() {
		// TODO: add guess to the list of prior guesses.
		LLIntegerNode tail = PG;
		LLIntegerNode last = new LLIntegerNode(guess);
		
		if(tail != null){
			while(tail.getLink() != null){
				tail = tail.getLink();
			}
			tail.setLink(last);
			numOfGuesses++;
		}
		
		else{
			PG = last;
			numOfGuesses++;
		}
		
		return guess;
		
	}
	
	/**
	 * Updates guess based on the number of matches of the previous guess.
	 * If nmatches is 4, the previous guess is correct and the game is over.
	 * Check project description for implementation details.
	 * 
	 * Returns true if the update has no error; false if no candidate 
	 * is left (indicating a state of error);
	 */
	public boolean updateGuess(int nmatches) {
		// TODO
		LLIntegerNode first = allNumbers;
		LLIntegerNode NChead = null;
		LLIntegerNode NCtail = null;
		
		//boolean added = false;
		
		if(nmatches == 4){
			end = true;
		    return true;
		}
		else{
			//LLIntegerNode first = allNumbers;
			while(first != null){
				if(numMatches(guess, first.getInfo()) == nmatches){
					if(NChead == null){
					  NChead = new LLIntegerNode(first.getInfo());
					  NCtail = NChead;
					 // added = true;
					}
				
					else{ 
						LLIntegerNode middle = new LLIntegerNode(first.getInfo());
						NCtail.setLink(middle);
						NCtail = middle;
					}
				}
			first = first.getLink();			
			}
			allNumbers = NChead;
			
			
			if(allNumbers == null){
				end = true;
				return false;
			}
			else
				guess = allNumbers.getInfo();
				return true;
		}
	}	
	
	
	// Returns the head of the prior guesses list.
	// Returns null if there hasn't been any prior guess
	public LLIntegerNode priorGuesses() {
		// TODO
		 if(PG != null)
			 return PG;
		 else
		return null;
	}
	
	/**
	 * Returns the list of prior guesses as a String. For example,
	 * if the prior guesses are 1000, 2111, 3222, in that order,
	 * the returned string should be "1000, 2111, 3222", in the same order,
	 * with every two numbers separated by a comma and space, except the
	 * last number (which should not be followed by either comma or space).
	 *
	 * Returns an empty string if here hasn't been any prior guess
	 */
	public String priorGuessesString() {
		// TODO
		String priorGuesses = "";
		LLIntegerNode current = PG;
		if(current == null)
			return priorGuesses;
		else{
		while(current != null){
			priorGuesses += "" + current.getInfo() + ", ";
			current = current.getLink();
		}
	
		return priorGuesses.substring(0, priorGuesses.length() - 2);
		}
	}
	
}
