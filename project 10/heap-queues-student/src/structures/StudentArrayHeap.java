package structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V>{
	
  public StudentArrayHeap(Comparator<P> comparator) {
	  super(comparator);
  }

  public int getLeftChildOf(int index){
	  
	  if(index < 0){
		  throw new IndexOutOfBoundsException();
	  }
  
	  return (2*index + 1);
  }

  public int getRightChildOf(int index){
	  
	  if(index < 0){
		  throw new IndexOutOfBoundsException();
	  }
	
	  return (2*index + 2);
	  
  }

  public int getParentOf(int index){
	  
	  if(index < 1){
		  throw new IndexOutOfBoundsException();
	  }
	
	  return (index - 1)/2;
	  
  }

  /**
   * <p>
   * This results in the entry at the specified index "bubbling up" to a
   * location such that the property of the heap are maintained. This method
   * should run in O(log(size)) time.
   * </p>
   * <p>
   * Note: When add is called, an Entry is placed at the end of the internal
   * array and then this method is called on that index.
   * </p>
   * 
   * @param index
   *            the index to bubble up
   */
  public void bubbleUp(int index){
	  
		  int kid = index;
		  P priority = heap.get(kid).getPriority();
		  int parent = (index-1)/2;
		  while ((kid > 0) &&
				  comparator.compare(priority, heap.get(parent).getPriority()) > 0){
		    swap(kid, parent);
		    kid = parent;
		    parent = (parent-1)/2;
		}	
	
  }

  /**
   * <p>
   * This method results in the entry at the specified index "bubbling down"
   * to a location such that the property of the heap are maintained. This
   * method should run in O(log(size)) time.
   * </p>
   * <p>
   * Note: When remove is called, if there are elements remaining in this
   * {@link AbstractArrayHeap} the bottom most element of the heap is placed
   * at the 0th index and bubbleDown(0) is called.
   * </p>
   * 
   * @param index
   */
  public void bubbleDown(int index){

	 int size = size();
	  
	  P priority = heap.get(index).getPriority();
	  int firstKid = index;
	  int parent = index; 
	  int left = 2*index + 1;
	  int right = 2*index + 2; 
	  
	    while (left < size) {
			  firstKid = left;

			  if (right < size &&
					  comparator.compare(heap.get(left).getPriority(), heap.get(right).getPriority()) < 0){
				  firstKid = right;
			  }
			  
			  if (comparator.compare(priority, heap.get(firstKid).getPriority()) <= 0){
				  swap(index, firstKid);
				  index = firstKid;
			  }
			  
			  if(comparator.compare(priority, heap.get(firstKid).getPriority()) > 0)
			  	break;

			  parent = firstKid;
			  left = 2*parent + 1;
			  right = 2*parent + 2;
		  } 
  }
}
