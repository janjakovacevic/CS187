package structures;

import comparators.IntegerComparator;
import structures.StudentArrayHeap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;


public class MaxQueue<V> implements PriorityQueue<Integer, V>{
	
	private int size;
	private Comparator<Integer> comparator;
	private StudentArrayHeap<Integer, V> heap;
	
	public MaxQueue(){
		size = 0;
		comparator = new IntegerComparator();
		heap = new StudentArrayHeap<Integer, V>(comparator);
	}
	
	/**
	 * Enqueues the specified {@code value} into this {@link PriorityQueue} with
	 * the specified {@code priority}. This runs in O(log(size)) time. For
	 * convenience this method returns the modified {@link PriorityQueue}.
	 * 
	 * @param priority
	 *            the priority of this enqueue
	 * @param value
	 *            the value being enqueued
	 * @return the modified {@link PriorityQueue}.
	 * @throws NullPointerException
	 *             if {@code prioirty} is {@code null} or {@code value} is
	 *             {@code null}.
	 */
	
	public MaxQueue<V> enqueue(Integer priority, V value){
		
		if(priority == null || value == null){
			throw new NullPointerException();
		}
		
		heap.add(priority, value);
		size++;
		
		return this;

	}

	/**
	 * Removes the value with the highest priority in this {@link PriorityQueue}
	 * and then returns it. This runs in O(log(size)) time.
	 * 
	 * @return the value with the highest priority in this {@link PrioirtyQueue}
	 * @throws IllegalStateException
	 *             if this {@link PriorityQueue} is empty.
	 */
	
	public V dequeue(){
		
		if(isEmpty()){
			throw new IllegalStateException();
		}

		V removed = peek();
		size--;
		
		heap.remove();
		
		return removed;
	}

	/**
	 * Returns the value with the highest priority in this {@link PriorityQueue}.
	 * 
	 * @return the value with the highest priority in this {@link PriorityQueue}.
	 * @throws IllegalStateException
	 *             if this {@link PriorityQueue} is empty.
	 */
	public V peek(){
	
		if(isEmpty()){
			throw new IllegalStateException();
		}
		
		return heap.peek();
	}
	

	/**
	 * Returns an {@link Iterator} over all of the entries in this
	 * {@link PriorityQueue}. The order of these elements is unspecified and a
	 * call to {@link Iterator#remove()} results in an
	 * {@link UnsupportedOperationException}.
	 * 
	 * @return an {@link Iterator} over all of the values in this
	 *         {@link PriorityQueue}.
	 */
	public Iterator<Entry<Integer, V>> iterator(){
		return heap.asList().iterator();
	}

	/**
	 * Returns the {@link Comparator} that is used to determine the ordering of
	 * {@link Entry}s in this {@link PriorityQueue}.
	 * 
	 * @return the {@link Comparator} that is used to determine the ordering of
	 *         {@link Entry}s in this {@link PriorityQueue}.
	 */
	public Comparator<Integer> getComparator(){
		return this.comparator;
	}

	/**
	 * Returns the total number of elements in this {@link PriorityQueue}
	 * 
	 * @return the total number of elements in this {@link PriorityQueue}
	 */
	public int size(){
		return size;
	}

	/**
	 * Returns {@code true} if this {@link PrioirtyQueue} has no elements and
	 * {@code false} otherwise.
	 * 
	 * @return {@code true} if this {@link PrioirtyQueue} has no elements and
	 *         {@code false} otherwise.
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
}

	
	
	
	

