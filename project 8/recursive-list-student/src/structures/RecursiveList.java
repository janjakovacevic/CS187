package structures;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {

	private int size = 0;
	private boolean removed = false;
	private LLNode<T> head;
	private LLNode<T> node = head;
	private LLNode<T> prev;
	private int count = 1; //insert
	private int pos = 0; //get
	private int nope = 0; //remove
	private int index = 0; //index
	private int r = 0;
	
	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ListInterface<T> insertFirst(T elem) {
		return insertAt(0, elem);
	}

	@Override
	public ListInterface<T> insertLast(T elem) {
		return insertAt(size, elem);
	}

	@Override
	public ListInterface<T> insertAt(int index, T elem) {
		
		if(elem == null){
			throw new NullPointerException();
		}
		
		if(index > size || index < 0){
			throw new IndexOutOfBoundsException();
		}
		
		if(index == 0 && size == 0){ //insertFirst
			head = new LLNode<T>(elem);
			node = head;
			size++;
			
			return this;
		}
		
		LLNode<T> insert = new LLNode<T>(elem);
		
		if(index == 0 && size != 0){
			insert.next = head;
			head = insert;
			node = head;
			size++;
			
			return this;
		}
		
		if(node.next == null){ //insertLast
			count = 1;
			node.next = insert;
			node = head;
			size++;
			
			return this;
		}
		
		if(index == count){
			count = 1;
			insert.next = node.next;
			node.next = insert;
			node = head;
			size++;
			
			return this;
		}
		
		else{
			count++;
			node = node.next;
			return insertAt(index, elem);
		}
	}

	@Override
	public T removeFirst() {
		if(isEmpty()){
			throw new IllegalStateException();
		}
		return removeAt(0);
	}

	@Override
	public T removeLast() {
		if(isEmpty()){
			throw new IllegalStateException();
		}
		return removeAt(size - 1);
	}

	@Override
	public T removeAt(int i) {
		
		if(i >= size || i < 0){
			throw new IndexOutOfBoundsException();
		}
		
		T data = null;
		
		if(i == 0){
			data = head.data;
			head = head.next;
			node = head;
			size--;

			return data;
		}
		
		if(i == nope && nope > 0){
			nope = 0;
			data = node.data;
			prev.next = node.next;
			node = head;
			size--;
			
			return data;
		}
		
		else{
			nope++;
			prev = node;
			node = node.next;
			return removeAt(i);
			
		}
	}

	@Override
	public T getFirst() {
		if(isEmpty()){
			throw new IllegalStateException();
		}
		return get(0);
	}

	@Override
	public T getLast() {
		if(isEmpty()){
			throw new IllegalStateException();
		}
		return get(size - 1);
	}

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		
		if(i >= size || i < 0){
			throw new IndexOutOfBoundsException();
		}
		
		T data = null;
		
		if(i == pos){
			pos = 0;
			data = node.data;
			node = head;
			return data;
		}
		
		else{
			pos++;
			node = node.next;
			return get(i);
		}
		
	}

	@Override
	public boolean remove(T elem) {
		
		if(elem == null){
			throw new NullPointerException();
		}
		
		if(node == null){
			removed = false;
			node = head;
			return removed;
		}
		
		if(node.data.equals(elem)){
			
			if(node == head){
				head = head.next;
				size--;
			}
			
			else{
				prev.next = node.next;
				size--;
			}
		
			removed = true;
			node = head;
			return removed;
		}
		else{
			prev = node;
			node = node.next;
			return remove(elem);
		}
	
	}

	@Override
	public int indexOf(T elem) {
		
		if(elem == null){
			throw new NullPointerException();
		}
		
		if(node == null){
			node = head;
			index = 0;
			return -1;
		}
		
		if(node.data.equals(elem)){
			int toReturn = index;
			index = 0;
			node = head;
			
			return toReturn;
		}
		
		else{
			index++;
			node = node.next;
			return indexOf(elem);
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
}

class LLNode<T>{
	
	public T data;
	public LLNode<T> next;
	
	public LLNode(){
	}

	public LLNode(T data) {
		this.data = data;
		this.next = null;
	}

	public LLNode(T data, LLNode<T> next) {
		this.data = data;
		this.next = next;
	}
	
}
