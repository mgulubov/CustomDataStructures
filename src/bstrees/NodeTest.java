package bstrees;

import junit.framework.*;

public class NodeTest extends TestCase {
	private Node _a;
	private Node _d;
	private Node _f;
	private Node _h;
	private Node _i;
	private Node _k;
	private Node _l;
	private Node _m;
	private Node _p;
	
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
	}
	
	public void testMinimum() {
		assertSame(this._a, this._a.minimum());
		assertSame(this._a, this._d.minimum());
		assertSame(this._f, this._f.minimum());
		assertSame(this._h, this._h.minimum());
		assertSame(this._a, this._i.minimum());
		assertSame(this._k, this._k.minimum());
		assertSame(this._k, this._l.minimum());
		assertSame(this._m, this._m.minimum());
		assertSame(this._p, this._p.minimum());
	}
	
	public void testMaximum() {
		assertSame(this._a, this._a.maximum());
		assertSame(this._h, this._d.maximum());
		assertSame(this._h, this._f.maximum());
		assertSame(this._h, this._h.maximum());
		assertSame(this._p, this._i.maximum());
		assertSame(this._k, this._k.maximum());
		assertSame(this._p, this._l.maximum());
		assertSame(this._p, this._m.maximum());
		assertSame(this._p, this._p.maximum());
	}
	
	public void testSuccessor() {
		assertSame(this._d, this._a.successor());
		assertSame(this._f, this._d.successor());
		assertSame(this._h, this._f.successor());
		assertSame(this._i, this._h.successor());
		assertSame(this._k, this._i.successor());
		assertSame(this._l, this._k.successor());
		assertSame(this._m, this._l.successor());
		assertSame(this._p, this._m.successor());
		assertNull(this._p.successor());
	}
	
	public void testPredecessor() {
		assertNull(this._a.predecessor());
		assertSame(this._a, this._d.predecessor());
		assertSame(this._d, this._f.predecessor());
		assertSame(this._f, this._h.predecessor());
		assertSame(this._h, this._i.predecessor());
		assertSame(this._i, this._k.predecessor());
		assertSame(this._k, this._l.predecessor());
		assertSame(this._l, this._m.predecessor());
		assertSame(this._m, this._p.predecessor());
	}
	
	public void testIsSmaller() {
		assertTrue(this._a.isSmaller());
		assertTrue(this._d.isSmaller());
		assertFalse(this._f.isSmaller());
		assertFalse(this._h.isSmaller());
		assertFalse(this._i.isSmaller());
		assertTrue(this._k.isSmaller());
		assertFalse(this._l.isSmaller());
		assertFalse(this._m.isSmaller());
		assertFalse(this._p.isSmaller());
	}
	
	public void testIsLarger() {
		assertFalse(this._a.isLarger());
		assertFalse(this._d.isLarger());
		assertTrue(this._f.isLarger());
		assertTrue(this._h.isLarger());
		assertFalse(this._i.isLarger());
		assertFalse(this._k.isLarger());
		assertTrue(this._l.isLarger());
		assertTrue(this._m.isLarger());
		assertTrue(this._p.isLarger());
	}
	
	public void testSize() {
		assertEquals(1, this._a.size());
		assertEquals(4, this._d.size());
		assertEquals(2, this._f.size());
		assertEquals(1, this._h.size());
		assertEquals(9, this._i.size());
		assertEquals(1, this._k.size());
		assertEquals(4, this._l.size());
		assertEquals(2, this._m.size());
		assertEquals(1, this._p.size());
	}
	
	public void testEquals() {
		Node a = new Node("A");
		Node h = new Node("H");
		Node k = new Node("K");
		Node p = new Node("P");
		Node f = new Node("F", null, h);
		Node m = new Node("M", null, p);
		Node d = new Node("D", a, f);
		Node l = new Node("L", k, m);
		Node i = new Node("I", d, l);
		
		assertEquals(a, this._a);
		assertEquals(d, this._d);
		assertEquals(f, this._f);
		assertEquals(h, this._h);
		assertEquals(i, this._i);
		assertEquals(k, this._k);
		assertEquals(l, this._l);
		assertEquals(m, this._m);
		assertEquals(p, this._p);
		assertFalse(this._i.equals(null));
		assertFalse(this._f.equals(this._d));
	}
}
