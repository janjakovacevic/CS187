package structures;

import java.util.NoSuchElementException;

public class Queue<T> implements UnboundedQueueInterface<T> {

	private int size;
	private Node<T> first;
	private Node<T> last;
	private T[] a;

	public Queue() {
		// TODO 1
		first = null;
		last = null;
		size = 0;
	}

	public Queue(Queue<T> other) {
		// TODO 2
		size = 0;
		Node<T> tempFirst = other.first;
		while (tempFirst != null) {
			this.enqueue(tempFirst.data);
			tempFirst = tempFirst.next;
			
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO 3

		return (size == 0 || first == null);
	}

	@Override
	public int size() {
		// TODO 4

		return size;
	}

	@Override
	public void enqueue(T element) {
		// TODO 5

		Node<T> newNode = new Node<T>(element);
		if (first == null) {
			first = newNode;
		} 
		else {
			last.next = newNode;	
		}
		last = newNode;
		size++;
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		// TODO 6
		if (isEmpty())
			throw new NoSuchElementException();
		else {
			T dequeued = first.data;
			first = first.next;
			size--;

			return dequeued;
		}
	}

	@Override
	public T peek() throws NoSuchElementException {
		// TODO 7
		if (isEmpty())
			throw new NoSuchElementException();
		else {
			return first.data;
		}
	}

	@Override
	public UnboundedQueueInterface<T> reversed() {
		// TODO 8
		Queue<T> umass = new Queue<T>(this);
		Queue<T> john = new Queue<T>();

		a = (T[]) new Object[this.size()];

		int i = 0;
		while (!umass.isEmpty()) {
			a[i] = umass.dequeue();
			i++;
		}

		for (int j = a.length - 1; j > -1; j--) {
			john.enqueue(a[j]);
		}

		return john;
	}
}

class Node<T> {
	public T data;
	public Node<T> next;

	public Node(T data) {
		this.data = data;
	}

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

}
