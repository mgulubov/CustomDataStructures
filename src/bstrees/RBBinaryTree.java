package bstrees;

import sorting.Comparator;
import sorting.NaturalComparator;

public class RBBinaryTree {
	private final Comparator _comparator;
	private RBNode _root;
	
	public RBBinaryTree() {
		this(NaturalComparator.INSTANCE);
	}
	
	public RBBinaryTree(Comparator comparator) {
		assert comparator != null : "comparator can't be null";
		this._comparator = comparator;
	}
	
	
}
