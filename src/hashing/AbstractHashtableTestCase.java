package hashing;

import junit.framework.*;

public abstract class AbstractHashtableTestCase extends TestCase {
	private static final int TEST_SIZE = 1000;
	private Hashtable _hashtable;
	
	protected abstract Hashtable createHashtable(int size);
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this._hashtable = createHashtable(TEST_SIZE);
		for (int i = 0; i < TEST_SIZE; ++i) {
			this._hashtable.add(String.valueOf(i));
		}
	}
	
	protected void tearDown() throws Exception {
		this._hashtable = null;
		super.tearDown();
	}
	
	public void testContains() {
		for (int i = 0; i < TEST_SIZE; ++i) {
			assertTrue(this._hashtable.contains(String.valueOf(i)));
		}
	}
	
	public void testDoesntContain() {
		for (int i = 0; i < TEST_SIZE; ++i) {
			assertFalse(this._hashtable.contains(String.valueOf(i + TEST_SIZE)));
		}
	}
	
	public void testAddingTheSameValueDoesntChangeSize() {
		assertEquals(TEST_SIZE, this._hashtable.size());
		
		for (int i = 0; i < TEST_SIZE; ++i) {
			this._hashtable.add(String.valueOf(i));
			assertEquals(TEST_SIZE, this._hashtable.size());
		}
	}
}
