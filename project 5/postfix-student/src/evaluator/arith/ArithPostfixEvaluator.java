package evaluator.arith;

import language.Operand;
import language.Operator;
import parser.IllegalPostfixExpressionException;
import parser.PostfixParser.Type;
import parser.Token;
import parser.arith.ArithPostfixParser;
import stack.LinkedStack;
import stack.StackInterface;
import evaluator.PostfixEvaluator;

/**
 * An {@link ArithPostfixEvaluator} is a postfix evaluator over simple arithmetic expressions.
 *
 */
public class ArithPostfixEvaluator implements PostfixEvaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;
	
	/**
	 * Constructs an {@link ArithPostfixEvaluator}
	 */
	public ArithPostfixEvaluator(){
        // TODO Initialize to your LinkedStack
		stack = new LinkedStack<Operand<Integer>>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer evaluate(String expr) throws IllegalPostfixExpressionException {
		ArithPostfixParser parser = new ArithPostfixParser(expr);
		for (Token<Integer> token : parser) {
			Type type = token.getType();
			switch(type){ 
			case OPERAND:
			// TODO What do we do when we see an operand?
				stack.push(token.getOperand());
				break;
			case OPERATOR:
				Operator<Integer> operator = token.getOperator();
            // TODO What do we do when we see an operator?
				if(operator.getNumberOfArguments() == 2){
					if(!stack.isEmpty()){
						Operand<Integer> a = stack.pop();
						operator.setOperand(1, a);
					}
					else	{
						throw new IllegalPostfixExpressionException();
					}
					if(!stack.isEmpty()){
						Operand<Integer> b = stack.pop();
						operator.setOperand(0, b);
					}
					else	{
						throw new IllegalPostfixExpressionException();
					}
					Operand<Integer> score = operator.performOperation();
					stack.push(score);
				}

				else {
					if(!stack.isEmpty()){
						Operand<Integer> a = stack.pop();
						operator.setOperand(0, a);
					}
					else	{
						throw new IllegalPostfixExpressionException();
					}
					Operand<Integer> score = operator.performOperation();
					stack.push(score);
				}
					
				break;
			default:
				throw new IllegalStateException("Parser returned an invalid Type: " + type);
			}							
		}		
		// TODO What do we return?
		if(stack.isEmpty()){
			throw new IllegalPostfixExpressionException();
		}
		if(stack.size() != 1){
			throw new IllegalPostfixExpressionException();
		}
		
		return stack.pop().getValue();
		
	}

}
