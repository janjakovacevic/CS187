package guessme;

/**
 * This class defines a linked list node storing an integer.
 * Use primitive type int (do not use wrapper class Integer)
 * You must provide the following methods:
 * - a constructor
 * - a setInfo method and a getInfo method
 * - a setLink method and a getLink method
 */
public class LLIntegerNode {
	// TODO
	private int info;
	private LLIntegerNode link;
	
public LLIntegerNode(int info){
	this.info = info;
	link = null;
}

public void setInfo(int i){
	info = i;
}

public int getInfo(){
	return info;
}

public void setLink(LLIntegerNode l){
	link = l;
}

public LLIntegerNode getLink(){
	return link;
}

}
