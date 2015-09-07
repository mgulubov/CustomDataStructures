package bstrees;

public class Node implements Cloneable {
	private Object _value;
	private Node _parent;
	private Node _smaller;
	private Node _larger;
	
	public Node (Object value) {
		this(value, null, null);
	}
	
	public Node (Object value, Node smaller, Node larger) {
		setValue(value);
		setSmaller(smaller);
		setLarger(larger);
		
		if (getSmaller() != null) {
			getSmaller().setParent(this);
		}
		
		if (getLarger() != null) {
			getLarger().setParent(this);
		}
	}
	
	public void setValue(Object value) {
		assert value != null : "value can't be null";
		this._value = value;
	}
	
	public Object getValue() {
		return this._value;
	}
	
	public void setParent(Node parent) {
		this._parent = parent;
	}
	
	public Node getParent() {
		return this._parent;
	}
	
	public void setSmaller(Node smaller) {
		assert getLarger() != smaller : "larger can't be == smaller";
		this._smaller = smaller;
	}
	
	public Node getSmaller() {
		return this._smaller;
	}
	
	public void setLarger(Node larger) {
		assert getSmaller() != larger : "smaller can't be == larger";
		this._larger = larger;
	}
	
	public Node getLarger() {
		return this._larger;
	}
	
	public boolean isRoot() {
		return this.getParent() == null;
	}
	
	public boolean isSmaller() {
		return !(isRoot()) && this.getParent().getSmaller() == this;
	}
	
	public boolean isLarger() {
		return !(isRoot()) && this.getParent().getLarger() == this;
	}
	
	public Node minimum() {
		Node node = this;
		
		while (node.getSmaller() != null) {
			node = node.getSmaller();
		}
		
		return node;
	}
	
	public Node maximum() {
		Node node = this;
		
		while (node.getLarger() != null) {
			node = node.getLarger();
		}
		
		return node;
	}
	
	public Node successor() {
		Node node = this;
		
		if (node.getLarger() != null) {
			return node.getLarger().minimum();
		}
		
		while (node.isLarger()) {
			node = node.getParent();
		}
		
		return node.getParent();
	}
	
	public Node predecessor() {
		Node node = this;
		
		if (node.getSmaller() != null) {
			return node.getSmaller().maximum();
		}
		
		while (node.isSmaller()) {
			node = node.getParent();
		}
		
		return node.getParent();
	}
	
	public int size() {
		return size(this);
	}
	
	public boolean equals(Object key) {
		if (key == null || key.getClass() != this.getClass()) {
			return false;
		}
		
		if (key == this) {
			return true;
		}
		
		Node keyNode = (Node) key;
		
		return this.getValue().equals(keyNode.getValue())
				&& equalsSmaller(keyNode.getSmaller())
				&& equalsLarger(keyNode.getLarger());
	}
	
	private int size(Node node) {
		int result = 0;
		
		if (node != null) {
			result = 1 + size(node.getSmaller()) + size(node.getLarger());
		}
		
		return result;
	}
	
	private boolean equalsSmaller(Node keyNode) {
		Node smaller = this.getSmaller();
		
		return smaller == null && keyNode == null
				|| smaller != null && smaller.equals(keyNode);
	}
	
	private boolean equalsLarger(Node keyNode) {
		Node larger = this.getLarger();
		
		return larger == null && keyNode == null
				|| larger != null && larger.equals(keyNode);
	}
}
