package bstrees;

import junit.framework.*;
import sorting.NaturalComparator;

public class BinarySearchTreeTestCase extends TestCase {
	private Node _a;
	private Node _d;
	private Node _f;
	private Node _h;
	private Node _i;
	private Node _k;
	private Node _l;
	private Node _m;
	private Node _p;
	private Node _root;
	private BinarySearchTree _tree;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this._a = new Node("A");
		this._h = new Node("H");
		this._k = new Node("K");
		this._p = new Node("P");
		this._f = new Node("F", null, this._h);
		this._m = new Node("M", null, this._p);
		this._d = new Node("D", this._a, this._f);
		this._l = new Node("L", this._k, this._m);
		this._i = new Node("I", this._d, this._l);
		this._root = this._i;
		
		this._tree = new BinarySearchTree(NaturalComparator.INSTANCE);
		this._tree.insert(this._i.getValue());
		this._tree.insert(this._d.getValue());
		this._tree.insert(this._l.getValue());
		this._tree.insert(this._a.getValue());
		this._tree.insert(this._f.getValue());
		this._tree.insert(this._k.getValue());
		this._tree.insert(this._m.getValue());
		this._tree.insert(this._h.getValue());
		this._tree.insert(this._p.getValue());
	}
	
	public void testInsert() {
		assertEquals(this._root, this._tree.getRoot());
	}
	
	public void testEquals() {
		assertEquals(this._i, this._tree.search(this._i.getValue()));
		assertEquals(this._d, this._tree.search(this._d.getValue()));
		assertEquals(this._l, this._tree.search(this._l.getValue()));
		assertEquals(this._a, this._tree.search(this._a.getValue()));
		assertEquals(this._f, this._tree.search(this._f.getValue()));
		assertEquals(this._k, this._tree.search(this._k.getValue()));
		assertEquals(this._m, this._tree.search(this._m.getValue()));
		assertEquals(this._h, this._tree.search(this._h.getValue()));
		assertEquals(this._p, this._tree.search(this._p.getValue()));
		
		assertNull(this._tree.search("UNKNOWN"));
	}
	
	public void testDeleteSingleLeaf() {
		Node deleted = this._tree.delete(this._h.getValue());
		assertNotNull(deleted);
		assertEquals(this._h.getValue(), deleted.getValue());
		
		this._f.setLarger(null);
		assertEquals(this._root, this._tree.getRoot());
	}
	
	public void testDeleteNodeWithOneChild() {
		Node deleted = this._tree.delete(this._m.getValue());
		assertNotNull(deleted);
		assertEquals(this._m.getValue(), deleted.getValue());
		
		Node successor = this._m.successor();
		Node parrent = this._m.getParent();
		assertEquals(successor, this._p);
		assertEquals(this._l, parrent);
		
		if (this._m.isLarger()) {
			parrent.setLarger(successor);
		} else {
			parrent.setSmaller(successor);
		}
		
		assertEquals(this._root, this._tree.getRoot());
	}
	
	public void testDeleteNodeWithTwoChildren() {
		Node deleted = this._tree.delete(this._i.getValue());
		assertNotNull(deleted);
		assertEquals(this._i.getValue(), deleted.getValue());
		
		this._i.setValue(this._k.getValue());
		this._l.setSmaller(null);
		
		assertEquals(this._root, this._tree.getRoot());
	}
}