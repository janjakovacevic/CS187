package largeinteger;

/** Generic LLNode class
 *  Note that both data members are public
 *  so you can access them directly without
 *  having to use the getters and setters.
 */
public class LLNode<T> {
	public T data;
	public LLNode<T> link;
	
	public LLNode() {
		this(null, null);
	}
	public LLNode(T data, LLNode<T> link) {
		this.data = data;
		this.link = link;
	}
}