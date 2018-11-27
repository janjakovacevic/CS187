package sets;

import java.util.Iterator;

/**
 * A LinkedList-based implementation of Set
 */

  /********************************************************
   * NOTE: Before you start, check the Set interface in
   * Set.java for detailed description of each method.
   *******************************************************/
  
  /********************************************************
   * NOTE: for this project you must use linked lists
   * implemented by yourself. You are NOT ALLOWED to use
   * Java arrays of any type, or any Collection-based class 
   * such as ArrayList, Vector etc. You will receive a 0
   * if you use any of them.
   *******************************************************/ 

  /********************************************************
   * NOTE: you are allowed to add new methods if necessary,
   * but do NOT add new files (as they will be ignored).
   *******************************************************/

public class LinkedSet<E> implements Set<E> {
  private LinkedNode<E> head = null;
  private int size;
  // Constructors
  public LinkedSet() {
  }

  public LinkedSet(E e) {
    this.head = new LinkedNode<E>(e, null);
  }

  private LinkedSet(LinkedNode<E> head) {
    this.head = head;
  }

  @Override
  public int size() {
    // TODO (1)
	  Iterator<E> iter = iterator();
	  while(iter.hasNext()){
		 iter.next();
	      size++;
		 }    
  
    return size;
  }

  @Override
  public boolean isEmpty() {
    // TODO (2)
	  
    return (head == null);
  }

  @Override
  public Iterator<E> iterator() {
    return new LinkedNodeIterator<E>(this.head);
  }

  @Override
  public boolean contains(Object o) {
    // TODO (3)
	  
	  Iterator<E> iter = iterator();
	  while(iter.hasNext()){
		  if(iter.next().equals(o)){
			  return true;
		  }
		  //iter.next();
	   }
	  
	  return false; 
	}

  @Override
  public boolean isSubset(Set<E> that) {
    // TODO (4)
	  
	  Iterator<E> iter = iterator();
	  while(iter.hasNext()){
	   if(!that.contains(iter.next())){
		   return false;
	   }
	   }
	  return true;
	  }

  @Override
  public boolean isSuperset(Set<E> that) {
    // TODO (5)
	  
	  Iterator<E> iter = that.iterator();
	  while(iter.hasNext()){
	   if(!this.contains(iter.next())){
		   return false;
	   }
	   }
	  return true;
  }
  

  @Override
  public Set<E> adjoin(E e) {
	  // TODO (6)
	 
	 LinkedNode<E> added = new LinkedNode<E>(e, head);
		  if(this.contains(e)){
			  return this;
		  }
		  else{
			  Set<E> set = new LinkedSet<E>(added);
			  return set;
		  }
	  
	  }

  @Override
  public Set<E> union(Set<E> that) {
    // TODO (7)
	  Set<E> set = new LinkedSet<E>(head);
	  Iterator<E> iter2 = that.iterator();
	  while(iter2.hasNext()){
		  E abc = iter2.next();
		  if(!set.contains(abc)){
			 set = set.adjoin(abc);
		  }
	  }
    return set;
  }

  @Override
  public Set<E> intersect(Set<E> that) {
    // TODO (8)
	  Set<E> set = new LinkedSet<E>();
	  Iterator<E> iter = iterator();
	  while(iter.hasNext()){
		  E abc = iter.next();
		  if(that.contains(abc)){
			 set = set.adjoin(abc);
	  }
	  }
    return set;
  }

  @Override
  public Set<E> subtract(Set<E> that) {
    // TODO (9)
	  Set<E> set = new LinkedSet<E>();
	  Iterator<E> iter = iterator();
	  while(iter.hasNext()){
		  E abc = iter.next();
		  if(!that.contains(abc)){
			 set = set.adjoin(abc);
	  }
	  }
    return set;
  }

  @Override
  public Set<E> remove(E e) {
    // TODO (10)
	  
	  Set<E> set = new LinkedSet<E>();
	  Iterator<E> iter = iterator();
	  while(iter.hasNext()){
		  E abc = iter.next();
		  if(!abc.equals(e)){
			  set = set.adjoin(abc);
		  }
	  }
	  return set;
	  }
	  
/*	  LinkedNode<E> curr = head;
	  
	  if(curr == null){
		  return this;
	  }
	  
	  if(curr.getData().equals(e)){
		  curr = curr.getNext();
	  }
	  
	  LinkedNode<E> newNode = new LinkedNode<E>(curr.getData(), null);
	  curr = curr.getNext();
	  while(curr != null){
		  E data = curr.getData();
		  if(!data.equals(e)){
			  LinkedNode<E> another = new LinkedNode<E>(data, newNode);
			  curr = curr.getNext();
			  newNode = another;
		  }
		  else
			  curr = curr.getNext();
			//  return this;
	  }
	  Set<E> set = new LinkedSet<E>(newNode);
	  
	  return set; 
} */

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (! (o instanceof Set)) {
      return false;
    }
    Set<E> that = (Set<E>)o;
    return this.isSubset(that) && that.isSubset(this);
  }

  @Override
    public int hashCode() {
    int result = 0;
    for (E e : this) {
      result += e.hashCode();
    }
    return result;
  }
}
