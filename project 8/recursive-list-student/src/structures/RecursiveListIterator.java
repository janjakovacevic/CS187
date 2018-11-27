package structures;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class RecursiveListIterator<T> implements Iterator<T> {

	private LLNode<T> top;

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return (top != null);
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		if(top == null) 
			throw new NoSuchElementException();
		else{
			T front = top.data;
			top = top.next;
			return front;
		}
	}
}


// Constructors
/* public RecursiveListIterator(LLNode<T> head) {
    top = head;
}*/

