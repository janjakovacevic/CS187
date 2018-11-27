package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
	

	LLNode<T> head;
	int size;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T pop() throws StackUnderflowException {
    // TODO
	
		T popped = top();
		head  =  head.getNext(); 
		size--;
		return popped;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T top() throws StackUnderflowException {
    // TODO
		 if ( head  ==  null )
			 throw   new  StackUnderflowException();  
		 return   head.getData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
    // TODO
     return (head  ==  null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
    // TODO
		
    return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T elem) {
    // TODO

		LLNode<T> curr  =  new LLNode<T>(elem); 
		curr.setNext(head);
		head  =  curr ;
		size++;	

		
	}

}
