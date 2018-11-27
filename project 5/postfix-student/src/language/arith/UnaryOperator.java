package language.arith;

import language.Operand;
import language.Operator;


public abstract class UnaryOperator<T> implements Operator<T>{

	protected Operand<T> op0;
	
	public final int getNumberOfArguments() {
		return 1;
	}
	
	public void setOperand(int i, Operand<T> operand) {
		if(operand == null)
			throw new NullPointerException("Could not set null operand.");
		if(i > 0)
			throw new IllegalArgumentException("Binary operator only accepts operands 0 and 1 but recieved " + i + ".");
		if(i == 0){
			if(op0 != null)
				throw new IllegalStateException("Position " + i + " has been previously set.");
			op0 = operand;
		} else {
			if(op0 != null)
				throw new IllegalStateException("Position " + i + " has been previously set.");
			op0 = operand;
		}
	}
	
}
