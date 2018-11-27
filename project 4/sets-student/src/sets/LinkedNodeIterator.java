package sets;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedNodeIterator<E> implements Iterator<E> {
    // TODO (1) define data variables
    private LinkedNode<E> top;
	
  
  // Constructors
  public LinkedNodeIterator(LinkedNode<E> head) {
      // TODO (2) choose appropriate parameters and do the initialization
      top = head;
  }

  @Override
  public boolean hasNext() {
    // TODO (3)
	  return (top != null);
  }

  @Override
  public E next() {
    // TODO (4)
	 if(top == null) throw new NoSuchElementException();
	 else{
      E front = top.getData();
      top = top.getNext();
      return front;
	 }     
  }

  @Override
  public void remove() {
    // Nothing to change for this method
    throw new UnsupportedOperationException();
  }
}
