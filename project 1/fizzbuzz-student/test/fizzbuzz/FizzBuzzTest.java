package fizzbuzz;

import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzTest {
	private final FizzBuzz ThreeFour = new FizzBuzz(3, 4);
	private final FizzBuzz TwoFive = new FizzBuzz(2, 5);

	@Test
	public void testNotFizzOrBuzzTrivial() {
		assertEquals("getValue returns incorrect value", "1",
				ThreeFour.getValue(1));	
		assertEquals("getValue returns incorrect value", "2",
				ThreeFour.getValue(2));		
	}
	
	@Test
	public void testFizzOrBuzzTrivial() {
		assertEquals("getValue returns incorrect value", "fizz",
				ThreeFour.getValue(3));
		assertEquals("getValue returns incorrect value", "buzz",
				ThreeFour.getValue(4));		
	}
	
	@Test
	public void testNotFizzOrBuzz() {
		assertEquals("getValue returns incorrect value", "59",
				ThreeFour.getValue(59));
		assertEquals("getValue returns incorrect value", "3",
				TwoFive.getValue(3));
		assertEquals("getValue returns incorrect value", "143",
				TwoFive.getValue(143));

	}
	
	@Test
	public void testFizzOrBuzz() {
		assertEquals("getValue returns incorrect value", "fizz",
				ThreeFour.getValue(9));
		assertEquals("getValue returns incorrect value", "buzz",
				ThreeFour.getValue(8));
		assertEquals("getValue returns incorrect value", "fizz",
				ThreeFour.getValue(13));
		assertEquals("getValue returns incorrect value", "buzz",
				ThreeFour.getValue(116));
		assertEquals("getValue returns incorrect value", "fizz",
				ThreeFour.getValue(13125));

		assertEquals("getValue returns incorrect value", "buzz",
				TwoFive.getValue(59));
		assertEquals("getValue returns incorrect value", "fizz",
				TwoFive.getValue(29));
		assertEquals("getValue returns incorrect value", "buzz",
				TwoFive.getValue(11511));
		assertEquals("getValue returns incorrect value", "fizz",
				TwoFive.getValue(4342));
	}

	@Test
	public void testFizzAndBuzz() {
		assertEquals("getValue returns incorrect value", "fizzbuzz",
			ThreeFour.getValue(12));
		assertEquals("getValue returns incorrect value", "fizzbuzz",
			ThreeFour.getValue(32));
		assertEquals("getValue returns incorrect value", "fizzbuzz",
			ThreeFour.getValue(45));
		assertEquals("getValue returns incorrect value", "fizzbuzz",
			TwoFive.getValue(100));
		assertEquals("getValue returns incorrect value", "fizzbuzz",
			TwoFive.getValue(521));
		assertEquals("getValue returns incorrect value", "fizzbuzz",
			ThreeFour.getValue(4310));
	}

	@Test
	public void testGetValuesSimple() {
		assertArrayEquals("getValues returns incorrect values", new String[] {
				"1", "2", "fizz", "buzz", "5" }, ThreeFour.getValues(1, 5));
	}

	@Test
	public void testGetValuesOffset() {
		assertArrayEquals("getValues returns incorrect values", new String[] {
				"2", "fizz", "buzz", "5", "fizz" },
				ThreeFour.getValues(2, 6));
	}
}