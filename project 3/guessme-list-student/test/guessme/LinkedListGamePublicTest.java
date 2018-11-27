package guessme;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListGamePublicTest {

	private LinkedListGame gamerA, gamerB;
	
	@Before
	public void before() {
		gamerA = new LinkedListGame();
		gamerB = new LinkedListGame();
	}
	
	@Test(timeout = 1000)
	public void testReset() {
		gamerA.getGuess();
		gamerA.updateGuess(0);
		gamerA.reset();
		assertEquals("numGuesses after reset", 0, gamerA.numGuesses());
		assertFalse("isOver after reset", gamerA.isOver());
		assertEquals("priorGuesses after reset", null, gamerA.priorGuesses());
		assertEquals("priorGuessesString after reset", "", gamerA.priorGuessesString());
	}

	@Test(timeout = 1000)
	public void testFirstGuessAndUpdate() {
		gamerA.reset();
		assertEquals("test first guess", 1000, gamerA.getGuess());
		assertEquals("test first guess", 1, gamerA.numGuesses());
		assertEquals("test first guess", 1000, gamerA.priorGuesses().getInfo());
		assertEquals("test first guess", null, gamerA.priorGuesses().getLink());
		assertEquals("test first guess", "1000", gamerA.priorGuessesString());
		gamerA.updateGuess(0);
		assertFalse("isOver after first update", gamerA.isOver());
	}
	
	@Test(timeout = 1000)
	public void testIsOver() {
		gamerA.reset();
		gamerB.reset();
		assertFalse("gameB not over yet", gamerB.isOver());
		assertEquals("gameB 1st guess", 1000, gamerB.getGuess());
		gamerB.updateGuess(4);
		assertTrue("gameB is over", gamerB.isOver());
		assertFalse("gameA not over yet", gamerA.isOver());
	}

	@Test(timeout = 1000)
	public void testIsPriorGuess() {
		gamerA.reset();
		int g1 = gamerA.getGuess();
		assertTrue("is prior guess", gamerA.isPriorGuess(g1));
		assertFalse("not prior guess", gamerA.isPriorGuess(9999));
		gamerA.updateGuess(0);
		int g2 = gamerA.getGuess();
		assertTrue("is prior guess", gamerA.isPriorGuess(g2));
		assertFalse("not prior guess", gamerA.isPriorGuess(9999));
	}
	
	@Test(timeout = 1000)
	public void testNumGuesses() {
		gamerB.reset();
		assertEquals("number of guesses shold be 0", 0, gamerB.numGuesses());
		assertEquals("number of guesses shold be 0", 0, gamerB.numGuesses());
		gamerB.getGuess();
		assertEquals("number of guesses shold be 1", 1, gamerB.numGuesses());
		assertEquals("number of guesses shold be 1", 1, gamerB.numGuesses());
		gamerB.updateGuess(0);
		gamerB.getGuess();
		assertEquals("number of guesses shold be 2", 2, gamerB.numGuesses());
		assertEquals("number of guesses shold be 2", 2, gamerB.numGuesses());
		gamerB.updateGuess(4);
		gamerB.getGuess();		
		assertEquals("number of guesses shold be 3", 3, gamerB.numGuesses());
		assertEquals("number of guesses shold be 3", 3, gamerB.numGuesses());
	}
	
	@Test(timeout = 1000) 
	public void testUpdateGuessTrivial() {
		gamerB.reset();
		// ground truth number is 1000
		assertEquals("gamerB first guess", 1000, gamerB.getGuess());
		assertTrue("gamerB first update", gamerB.updateGuess(4));
		assertTrue("gamerB game over", gamerB.isOver());
	}
	
	@Test(timeout = 1000)
	public void testUpdateGuess() {
		gamerA.reset();
		// ground truth number is 3242
		assertEquals("gamerA first guess", 1000, gamerA.getGuess());
		assertTrue("gamerA first update", gamerA.updateGuess(0));
		
		assertEquals("gamerA second guess", 2111, gamerA.getGuess());
		assertTrue("gamerA second update", gamerA.updateGuess(0));
		
		assertEquals("gamerA third guess", 3222, gamerA.getGuess());
		assertTrue("gamerA third update", gamerA.updateGuess(3));
		
		assertEquals("gamerA fourth guess", 3223, gamerA.getGuess());
		assertTrue("gamerA fourth update", gamerA.updateGuess(2));
		
		assertEquals("gamerA fifth guess", 3232, gamerA.getGuess());
		assertTrue("gamerA fifth update", gamerA.updateGuess(3));
		
		assertEquals("gamerA sixth guess", 3242, gamerA.getGuess());
		assertTrue("gamerA sixth update", gamerA.updateGuess(4));
		assertTrue("gamerA game over", gamerA.isOver());
		
	}
	
	@Test(timeout = 1000)
	public void testUpdateGuessError() {
		gamerA.reset();
		gamerA.getGuess();	// should be 1000
		gamerA.updateGuess(3);
		gamerA.getGuess();	// should be 1001
		assertFalse("state of error", gamerA.updateGuess(1)); // this number does not exist
															  // updateGuess should return false
		
		gamerA.reset();
		gamerA.getGuess();	// should be 1000
		gamerA.updateGuess(3);
		gamerA.getGuess();	// should be 1001
		gamerA.updateGuess(2);
		gamerA.getGuess();	// should be 1010
		assertFalse("state of error", gamerA.updateGuess(1)); // this number does not exist
															  // updateGuess should return false	
	}

	@Test(timeout = 1000)
	public void testPriorGuesses() {
		gamerB.reset();
		assertEquals("test prior guesses", null, gamerB.priorGuesses());
		
		int g1 = gamerB.getGuess();
		LLIntegerNode pl = gamerB.priorGuesses();
		assertEquals("test prior guesses", g1, pl.getInfo());
		assertEquals("test prior guesses", null, pl.getLink());
		
		gamerB.updateGuess(1);
		int g2 = gamerB.getGuess();
		pl = gamerB.priorGuesses();
		assertEquals("test prior guesses", g1, pl.getInfo());
		assertEquals("test prior guesses", g2, pl.getLink().getInfo());
		
		gamerB.updateGuess(2);
		int g3 = gamerB.getGuess();
		pl = gamerB.priorGuesses();
		assertEquals("test prior guesses", g1, pl.getInfo());
		assertEquals("test prior guesses", g2, pl.getLink().getInfo());
		assertEquals("test prior guesses", g3, pl.getLink().getLink().getInfo());
		
		gamerB.updateGuess(3);
		int g4 = gamerB.getGuess();
		pl = gamerB.priorGuesses();
		assertEquals("test prior guesses", g1, pl.getInfo());
		assertEquals("test prior guesses", g2, pl.getLink().getInfo());
		assertEquals("test prior guesses", g3, pl.getLink().getLink().getInfo());
		assertEquals("test prior guesses", g4, pl.getLink().getLink().getLink().getInfo());
		
		gamerB.updateGuess(3);
		pl = gamerB.priorGuesses();
		assertEquals("test prior guesses", g1, pl.getInfo());
		assertEquals("test prior guesses", g2, pl.getLink().getInfo());
		assertEquals("test prior guesses", g3, pl.getLink().getLink().getInfo());
		assertEquals("test prior guesses", g4, pl.getLink().getLink().getLink().getInfo());		
	}

	@Test(timeout = 1000)
	public void testPriorGuessesString() {
		gamerB.reset();
		assertEquals("test prior guesses string", "", gamerB.priorGuessesString());
		
		int g1 = gamerB.getGuess();
		String g = new String();
		g = g+g1;
		assertEquals("test prior guesses string", g, gamerB.priorGuessesString());
		gamerB.updateGuess(1);

		int g2 = gamerB.getGuess();
		g = g+", "+g2;
		gamerB.updateGuess(2);

		int g3 = gamerB.getGuess();
		g = g+", "+g3;
		gamerB.updateGuess(3);
		
		int g4 = gamerB.getGuess();
		g = g+", "+g4;
		assertEquals("test prior guesses string", g, gamerB.priorGuessesString());
		gamerB.updateGuess(4);
		assertEquals("test prior guesses string", g, gamerB.priorGuessesString());
	}

}


