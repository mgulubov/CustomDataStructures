package bstrees;

public class RBNode {
	private Object _value;
	private RBNode _parent;
	private RBNode _smaller;
	private RBNode _larger;
	private Color _color;
	
	public RBNode(Object value, Color color, RBNode smaller, RBNode larger) {
		setValue(value);
		setColor(color);
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
	
	public void setColor(Color color) {
		assert color != null : "color can't be null";
		assert color == Color.BLACK || color == Color.RED : "color can't be != red || black";
		this._color = color;
	}
	
	public Color getColor() {
		return this._color;
	}
	
	public void setSmaller(RBNode smaller) {
		assert smaller != getLarger() : "smaller can't be == larger";
		this._smaller = smaller;
	}
	
	public RBNode getSmaller() {
		return this._smaller;
	}
	
	public void setLarger(RBNode larger) {
		assert larger != getSmaller() : "larger can't be == smaller";
		this._larger = larger;
	}
	
	public RBNode getLarger() {
		return this._larger;
	}
	
	public void setParent(RBNode parent) {
		this._parent = parent;
	}
	
	public RBNode getParent() {
		return this._parent;
	}
	
	public RBNode getGrandparent() {
		assert getParent() != null : "not root node";
		assert getParent().getParent() != null : "not child of root node";
		return getParent().getParent();
	}
	
	public RBNode getSibling() {
		RBNode parent = getParent();
		assert parent != null : "not root node";
		
		if (parent.isSmaller()) {
			return parent.getLarger();
		} else {
			return parent.getSmaller();
		}
	}
	
	public RBNode getUncle() {
		RBNode parent = getParent();
		assert parent != null : "not root node";
		assert parent.getParent() != null : "not child of root node";
		
		return parent.getSibling();
	}
	
	public boolean isSmaller() {
		RBNode parent = getParent();
		return !parent.isRoot() && parent.getSmaller() == this;
	}
	
	public boolean isLarger() {
		RBNode parent = getParent();
		return !parent.isRoot() && parent.getLarger() == this;
	}
	
	public boolean isRoot() {
		return getParent() == null;
	}
	
	public RBNode maximum() {
		RBNode node = this;
		
		while (node.getLarger() != null) {
			node = node.getLarger();
		}
		
		return node;
	}
	
	public RBNode minimum() {
		RBNode node = this;
		
		while (node.getSmaller() != null) {
			node = node.getSmaller();
		}
		
		return node;
	}
	
	public RBNode successor() {
		RBNode node = this;
		
		if (node.getLarger() != null) {
			return node.getLarger().minimum();
		}
		
		while (node.isLarger()) {
			node = node.getParent();
		}
		
		return node.getParent();
	}
	
	public RBNode predecessor() {
		RBNode node = this;
		
		if (node.getSmaller() != null) {
			return node.getSmaller().maximum();
		}
		
		while (node.isSmaller()) {
			node = node.getParent();
		}
		
		return node.getParent();
	}
	
	public boolean equals(Object key) {
		if (key == null || key.getClass() != getClass()) {
			return false;
		}
		
		if (key == this) {
			return true;
		}
		
		RBNode nodeKey = (RBNode)key;
		
		return this.getValue().equals(nodeKey.getValue())
				&& equalsSmaller(nodeKey.getSmaller())
				&& equalsLarger(nodeKey.getLarger());
	}
	
	private boolean equalsSmaller(RBNode key) {
		RBNode smaller = this.getSmaller();
		return smaller == null && key == null
				|| smaller != null && smaller.equals(key);
	}
	
	private boolean equalsLarger(RBNode key) {
		RBNode larger = this.getLarger();
		return larger == null && key == null
				|| larger != null && larger.equals(key);
	}
	
	public int size() {
		return size(this);
	}
	
	private int size(RBNode node) {
		if (node == null) {
			return 0;
		}
		
		return 1 + size(node.getSmaller()) + size(node.getLarger());
	}
}
