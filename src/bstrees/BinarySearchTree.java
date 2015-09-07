package bstrees;

import sorting.Comparator;
import sorting.NaturalComparator;

public class BinarySearchTree {
	private final Comparator _comparator;
	private Node _root;
	
	public BinarySearchTree() {
		this(NaturalComparator.INSTANCE);
	}
	
	public BinarySearchTree(Comparator comparator) {
		assert comparator != null : "comparator can't be null";
		this._comparator = comparator;
	}
	
	public Node search(Object value) {
		assert value != null : "value can't be null";
		
		Node node = this._root;
		
		while (node != null) {
			int check = this._comparator.compare(node.getValue(), value);
			
			if (check == 0) {
				break;
			}
			
			node = check < 0 ? node.getLarger() : node.getSmaller();
		}
		
		return node;
	}
	
	public Node insert(Object value) {
		Node parent = null;
		Node node = this._root;
		
		int check = 0;
		while (node != null) {
			parent = node;
			check = this._comparator.compare(node.getValue(), value);
			node = check <= 0 ? node.getLarger() : node.getSmaller();
		}
		
		Node inserted = new Node(value);
		inserted.setParent(parent);
		
		if (parent == null) {
			this._root = inserted;
		} else if (check < 0) {
			parent.setLarger(inserted);
		} else {
			parent.setSmaller(inserted);
		}
		
		return inserted;
	}
	
	public Node delete(Object value) {
		Node node = search(value);
		if (node == null) {
			return null;
		}
		
		Node deleted = node.getSmaller() != null && node.getLarger() != null
				? node.successor()
				: node;
		assert deleted != null : "deleted can't be null";
		
		Node replacement = deleted.getSmaller() != null 
				? deleted.getSmaller()
			    : deleted.getLarger();
		if (replacement != null) {
			replacement.setParent(deleted.getParent());
		}
		
		if (deleted == this._root) {
			this._root = replacement;
		}
		if (deleted.isSmaller()) {
			deleted.getParent().setSmaller(replacement);
		} else {
			deleted.getParent().setLarger(replacement);
		}
		
		if (deleted != node) {
			Object deletedValue = node.getValue();
			
			node.setValue(deleted.getValue());
			deleted.setValue(deletedValue);
		}
		
		return deleted;
	}
	
	public Node getRoot() {
		return this._root;
	}
}
