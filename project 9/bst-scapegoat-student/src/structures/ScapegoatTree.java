package structures;

import java.util.Iterator;
import java.lang.Math;
import java.util.ArrayList;

public class ScapegoatTree<T extends Comparable<T>> extends
		BinarySearchTree<T> {
	private int upperBound = size();
	
	

	@Override
	public void add(T t) {
		// TODO
		
		if(t == null){
			throw new NullPointerException();
		}
		
		BSTNode<T> u = new BSTNode<T>(t, null, null);
		
		root = super.addToSubtree(root, u);
		upperBound++;
		
		if(height() > (Math.log(upperBound)/Math.log(1.5))){
			ArrayList<BSTNode<T>> path = new ArrayList<BSTNode<T>>();
			path = search(root, u, path);
		
			
			balance(findScapegoat(path));
			
			if(balance(findScapegoat(path)).getData().compareTo(findScapegoatParent(path).getData()) < 0){
				findScapegoatParent(path).setLeft(balance(findScapegoat(path)));
			}
			else{
				findScapegoatParent(path).setRight(balance(findScapegoat(path)));
			}
			
		}
		
		
	}
	
	private BSTNode<T> findScapegoat(ArrayList<BSTNode<T>> path){
		
		for(int i = path.size() - 1; i > 0; i--){
			
			if(subtreeSize(path.get(i)) > (2.0*subtreeSize(path.get(i-1))/3.0)){
				return path.get(i-1);
			}
		}
		return null;
	}
	
	private BSTNode<T> findScapegoatParent(ArrayList<BSTNode<T>> path){
		
		for(int i = path.size() - 1; i > 1; i--){	
			if(subtreeSize(path.get(i)) > (2.0*subtreeSize(path.get(i-1))/3.0)){
				return path.get(i-2);
			}
		}
		return null;
	}
	
	private ArrayList<BSTNode<T>> search(BSTNode<T> curr, BSTNode<T> u, ArrayList<BSTNode<T>> tree){
		
		if(curr == null || curr == u){
			return tree;
		}
			if(curr.getData().compareTo(u.getData()) < 0) {
				tree.add(curr);
				search(curr.getRight(), u, tree);
			}
			else{
				tree.add(curr);
				search(curr.getLeft(), u, tree); 
			}
		
		return tree;

	}
	
	
	@Override
	public boolean remove(T element) {
		// TODO
		
		if(element == null){
			throw new NullPointerException();
		}
		
		boolean result = super.remove(element);
		
		if(upperBound > 2*size()){
			root = balance(root);
			upperBound = size();
		}
	
	return result;
	}
}
