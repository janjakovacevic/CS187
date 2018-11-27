package language.arith;

//import language.UnaryOperator;
import language.Operand;

/**
 * The {@code NegateOperator} is an operator that performs negation on a single integer
 * @author jcollard
 *
 */

public class NegateOperator extends UnaryOperator<Integer> {

	// You will notice that this class extends BinaryOperator.
	// That is not correct as negate is a unary operator.  You should first
    // write an abstract class called UnaryOperator, paralleling
	// BinaryOperator, that abstracts out all the bits common
	// across UnaryOperators.
	
	public Operand<Integer> performOperation() {
		if(op0 == null)
			throw new IllegalStateException("Could not perform operation prior to operands being set.");
		Integer result = 0 - op0.getValue();
		return new Operand<Integer>(result);
	}

	
	
}
