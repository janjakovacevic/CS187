package structures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> implements
		BSTInterface<T> {
	protected BSTNode<T> root;

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return subtreeSize(root);
	}

	protected int subtreeSize(BSTNode<T> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + subtreeSize(node.getLeft())
					+ subtreeSize(node.getRight());
		}
	}

	public boolean contains(T t) {
		// TODO
		
		return get(t) != null;
	}

	public boolean remove(T t) {
		if (t == null) {
			throw new NullPointerException();
		}
		boolean result = contains(t);
		if (result) {
			root = removeFromSubtree(root, t);
		}
		return result;
	}

	private BSTNode<T> removeFromSubtree(BSTNode<T> node, T t) {
		// node must not be null
		int result = t.compareTo(node.getData());
		if (result < 0) {
			node.setLeft(removeFromSubtree(node.getLeft(), t));
			return node;
		} else if (result > 0) {
			node.setRight(removeFromSubtree(node.getRight(), t));
			return node;
		} else { // result == 0
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else { // neither child is null
				T predecessorValue = getHighestValue(node.getLeft());
				node.setLeft(removeRightmost(node.getLeft()));
				node.setData(predecessorValue);
				return node;
			}
		}
	}

	private T getHighestValue(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getData();
		} else {
			return getHighestValue(node.getRight());
		}
	}

	private BSTNode<T> removeRightmost(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getLeft();
		} else {
			node.setRight(removeRightmost(node.getRight()));
			return node;
		}
	}

	public T get(T t) {
		// TODO
		return getHelper(root, t);
	}
	
	private T getHelper(BSTNode<T> curr, T t){
		
		if(t == null){
			throw new NullPointerException();
		}
		
		if(curr == null){
			return null;
		}

		if(curr.getData().compareTo(t) == 0){
			return curr.getData();
		}

		else{
			if(curr.getData().compareTo(t) > 0){
				return getHelper(curr.getLeft(), t);			
			}
			else{
				return getHelper(curr.getRight(), t);
			}
		}
	}

	
	
	public void add(T t) {
		if (t == null) {
			throw new NullPointerException();
		}
		root = addToSubtree(root, new BSTNode<T>(t, null, null));
	}

	protected BSTNode<T> addToSubtree(BSTNode<T> node, BSTNode<T> toAdd) {
		if (node == null) {
			return toAdd;
		}
		int result = toAdd.getData().compareTo(node.getData());
		if (result <= 0) {
			node.setLeft(addToSubtree(node.getLeft(), toAdd));
		} else {
			node.setRight(addToSubtree(node.getRight(), toAdd));
		}
		return node;
	}

	@Override
	public T getMinimum() {
		// TODO
		if(root == null){
			return null;
		}
		
		return getMinimumHelper(root);
	}
	
	private T getMinimumHelper(BSTNode<T> curr){
		
		if(curr.getLeft() == null){
			return curr.getData();
		}
		else{
			return getMinimumHelper(curr.getLeft());
		}
	}


	@Override
	public T getMaximum() {
		// TODO
		if(root == null){
			return null;
		}
		
		return getMaximumHelper(root);
	}
	
	private T getMaximumHelper(BSTNode<T> curr){
		
		if(curr.getRight() == null){
			return curr.getData();
		}
		else{
			return getMaximumHelper(curr.getRight());
		}
	}

	@Override
	public int height() {
		// TODO
		
		return heightHelper(root);
	}
	
	
	private int heightHelper(BSTNode<T> curr){
		
		if(curr == null){
			return -1;
		}
		else if(curr.getLeft() == null){
			return 1 + heightHelper(curr.getRight());
		}
		else if(curr.getRight() == null){
			return 1 + heightHelper(curr.getLeft());
		}
		else{
			return 1 + Math.max(heightHelper(curr.getLeft()), heightHelper(curr.getRight()));
		}
	}

	public Iterator<T> preorderIterator() {
		// TODO
		Queue<T> queue = new LinkedList<T>();
		preorderTraverse(queue, root);
		return queue.iterator();

	}
	
	private void preorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			queue.add(node.getData());
			preorderTraverse(queue, node.getLeft());
			preorderTraverse(queue, node.getRight());
		}
	}


	public Iterator<T> inorderIterator() {
		Queue<T> queue = new LinkedList<T>();
		inorderTraverse(queue, root);
		return queue.iterator();
	}


	private void inorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			inorderTraverse(queue, node.getLeft());
			queue.add(node.getData());
			inorderTraverse(queue, node.getRight());
		}
	}

	public Iterator<T> postorderIterator() {
		// TODO
		Queue<T> queue = new LinkedList<T>();
		postorderTraverse(queue, root);
		return queue.iterator();
		
	}
	private void postorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			postorderTraverse(queue, node.getLeft());
			postorderTraverse(queue, node.getRight());
			queue.add(node.getData());
		}
	}


	@Override
	public boolean equals(BSTInterface<T> other) {
		// TODO
		
		if(other == null){
			throw new NullPointerException();
		}
		
		return equalsHelper(other.getRoot(), root);
	}

	private boolean equalsHelper(BSTNode<T> other, BSTNode<T> curr){
		
		if(other == null && curr == null){
			return true;
		}
		if(other == null || curr == null){
			return false;
		}
		else{
			return other.getData().equals(curr.getData()) && 
					equalsHelper(other.getLeft(), curr.getLeft()) && 
					equalsHelper(other.getRight(), curr.getRight());
		}
	}

	@Override
	public boolean sameValues(BSTInterface<T> other) {
		// TODO
		
		if(other == null){
			throw new NullPointerException();
		}
		
		ArrayList<T> list1 = new ArrayList<T>();
		ArrayList<T> list2 = new ArrayList<T>();
		
		listHelper(list1, root);
		listHelper(list2, other.getRoot());
		
		if(list1.size() != list2.size()){
			return false;
		}
		else{
			for(int i = 0; i < list1.size(); i++){
				if(list1.get(i) != list2.get(i)){
					return false;
				}
			}
			return true;
		}
	
	}

	@Override
	public boolean isBalanced() {
		// TODO
	
		return isBalancedHelper(root);
	}
	
	private boolean isBalancedHelper(BSTNode<T> curr){
		if(curr == null){
			return true;
		}
		int heightDifference = Math.abs(heightHelper(curr.getLeft()) - heightHelper(curr.getRight()));

		if(heightDifference > 1){
			return false;
		}
		else{
			return true;
		}
	}

	@Override
    @SuppressWarnings("unchecked")

	public void balance() {
		// TODO
		ArrayList<T> tree = new ArrayList<T>();
		listHelper(tree, root);
		
		root = list2BST(tree, 0, tree.size()-1);
		
	}
	
	public BSTNode<T> balance(BSTNode<T> curr) {
		// TODO
		ArrayList<T> tree = new ArrayList<T>();
		listHelper(tree, curr);
		
		curr = list2BST(tree, 0, tree.size()-1);
		
		return curr;
		
	}
	
	private void listHelper(ArrayList<T> list, BSTNode<T> curr){
		
		if(curr != null){
			listHelper(list, curr.getLeft());
			list.add(curr.getData());
			listHelper(list, curr.getRight());
		}
	}
	
	private BSTNode<T> list2BST(ArrayList<T> list, int down, int up) { 
		if (down > up){
			return null;
		}
		int mid = (down + up) / 2;
		BSTNode<T> node = new BSTNode<T>(list.get(mid), null, null);
		node.setLeft(list2BST(list, down, mid - 1));
		node.setRight(list2BST(list, mid + 1, up));
		return node;
	}

	@Override
	public BSTNode<T> getRoot() {
        // DO NOT MODIFY
		return root;
	}

	public static <T extends Comparable<T>> String toDotFormat(BSTNode<T> root) {
		// header
		int count = 0;
		String dot = "digraph G { \n";
		dot += "graph [ordering=\"out\"]; \n";
		// iterative traversal
		Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
		queue.add(root);
		BSTNode<T> cursor;
		while (!queue.isEmpty()) {
			cursor = queue.remove();
			if (cursor.getLeft() != null) {
				// add edge from cursor to left child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getLeft().getData().toString() + ";\n";
				queue.add(cursor.getLeft());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}
			if (cursor.getRight() != null) {
				// add edge from cursor to right child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getRight().getData().toString() + ";\n";
				queue.add(cursor.getRight());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}

		}
		dot += "};";
		return dot;
	}

	public static void main(String[] args) {
		for (String r : new String[] { "a", "b", "c", "d", "e", "f", "g" }) {
			BSTInterface<String> tree = new BinarySearchTree<String>();
			for (String s : new String[] { "d", "b", "a", "c", "f", "e", "g" }) {
				tree.add(s);
			}
			Iterator<String> iterator = tree.inorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();
			iterator = tree.preorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();
			iterator = tree.postorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();

			System.out.println(tree.remove(r));

			iterator = tree.inorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();
		}

		BSTInterface<String> tree = new BinarySearchTree<String>();
		for (String r : new String[] { "a", "b", "c", "d", "e", "f", "g" }) {
			tree.add(r);
		}
		System.out.println(tree.size());
		System.out.println(tree.height());
		System.out.println(tree.isBalanced());
		tree.balance();
		System.out.println(tree.size());
		System.out.println(tree.height());
		System.out.println(tree.isBalanced());
	}
}