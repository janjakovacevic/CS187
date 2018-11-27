package largeinteger;

public class LargeIntegerExample {
	/** The main method below shows you two examples of how our LargeInteger
	 *  class may be used to compute large factorial numbers and powers that
	 *  don't fit in Java's primitive integer data types. It will only work
	 *  after you have completed all the required methods above.
	 */
	public static void main(String args[]) {
		System.out.println("Large factorial numbers:");
		for(int i=10;i<=20;i++) {
			System.out.println(i+"!="+LargeInteger.factorial(i));
		}
		System.out.println("=======================");
		System.out.println("First ten powers of 187:");
		for(int i=0;i<=10;i++) {
			System.out.println("187^"+i+"="+LargeInteger.pow(187, i));
		}
	}
}
