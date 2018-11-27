package fizzbuzz;

import java.util.Scanner;

public class FizzCommander {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);
		try {

			System.out.println("Enter a fizz number and a buzz number:");
			final int fizz = conIn.nextInt();
			final int buzz = conIn.nextInt();
			FizzBuzz fb = new FizzBuzz(fizz, buzz);
			
			int upper = 40;
			System.out.println("FizzBuzz values of 1 to "+upper+":");
			int i;
			for(i=1;i<upper;i++) {
				System.out.print(fb.getValue(i)+", ");
			}
			System.out.println(fb.getValue(i));
			
		} finally {
			conIn.close();
		}
	}
}