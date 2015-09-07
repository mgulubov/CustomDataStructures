package stacks;

import junit.framework.*;

public abstract class AbstractStackTestCase extends TestCase {
	private static final String VALUE_A = "A";
	private static final String VALUE_B = "B";
	private static final String VALUE_C = "C";
	private static final String VALUE_D = "D";
	private Stack _stack;
	
	protected abstract Stack createStack();
	
	protected void setUp() throws Exception {
		super.setUp();
		this._stack = createStack();
	}
	
	protected void tearDown() throws Exception {
		this._stack = null;
		super.tearDown();
	}
	
	public void testPush() {
		assertEquals(0, this._stack.size());
		assertTrue(this._stack.isEmpty());
		
		this._stack.push(VALUE_A);
		assertEquals(1, this._stack.size());
		assertFalse(this._stack.isEmpty());
		assertSame(VALUE_A, this._stack.peek());
		
		this._stack.push(VALUE_B);
		assertEquals(2, this._stack.size());
		assertFalse(this._stack.isEmpty());
		assertSame(VALUE_B, this._stack.peek());
		
		this._stack.push(VALUE_C);
		assertEquals(3, this._stack.size());
		assertFalse(this._stack.isEmpty());
		assertSame(VALUE_C, this._stack.peek());
	}
	
	public void testPop() {
		assertEquals(0, this._stack.size());
		assertTrue(this._stack.isEmpty());
		
		try {
			this._stack.peek();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertEquals(0, this._stack.size());
		assertTrue(this._stack.isEmpty());
		
		try {
			this._stack.pop();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertEquals(0, this._stack.size());
		assertTrue(this._stack.isEmpty());
		
		this._stack.push(VALUE_A);
		this._stack.push(VALUE_B);
		this._stack.push(VALUE_C);
		
		assertEquals(3, this._stack.size());
		assertFalse(this._stack.isEmpty());
		assertSame(VALUE_C, this._stack.peek());
		
		assertSame(VALUE_C, this._stack.pop());
		assertEquals(2, this._stack.size());
		assertFalse(this._stack.isEmpty());
		assertSame(VALUE_B, this._stack.peek());
		
		assertSame(VALUE_B, this._stack.pop());
		assertEquals(1, this._stack.size());
		assertFalse(this._stack.isEmpty());
		assertSame(VALUE_A, this._stack.peek());
		
		assertSame(VALUE_A, this._stack.pop());
		assertEquals(0, this._stack.size());
		assertTrue(this._stack.isEmpty());
		
		try {
			this._stack.peek();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertEquals(0, this._stack.size());
		assertTrue(this._stack.isEmpty());
		
		try {
			this._stack.pop();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertEquals(0, this._stack.size());
		assertTrue(this._stack.isEmpty());
	}
	
	public void testPushPop() {
		this._stack.push(VALUE_A);
		this._stack.push(VALUE_A);
		this._stack.push(VALUE_B);
		
		assertSame(VALUE_B, this._stack.peek());
		assertSame(VALUE_B, this._stack.pop());
		
		assertSame(VALUE_A, this._stack.peek());
		assertSame(VALUE_A, this._stack.pop());
		
		this._stack.push(VALUE_C);
		this._stack.push(VALUE_D);
		
		assertSame(VALUE_D, this._stack.peek());
		assertSame(VALUE_D, this._stack.pop());
		
		assertSame(VALUE_C, this._stack.peek());
		assertSame(VALUE_C, this._stack.pop());
		
		assertSame(VALUE_A, this._stack.peek());
		assertSame(VALUE_A, this._stack.pop());
		
		assertEquals(0, this._stack.size());
		assertTrue(this._stack.isEmpty());
		
		try {
			this._stack.peek();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertEquals(0, this._stack.size());
		assertTrue(this._stack.isEmpty());
		
		try {
			this._stack.pop();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertEquals(0, this._stack.size());
		assertTrue(this._stack.isEmpty());
	}
	
	public void testToArray() {
		this._stack = createStack();
		
		this._stack.push(VALUE_A);
		this._stack.push(VALUE_B);
		this._stack.push(VALUE_C);
		
		Object[] actual = this._stack.toArray();
		Object[] expected = new Object[]{
				VALUE_A, VALUE_B, VALUE_C
		};
		
		assertEquals(expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertSame(expected[i], actual[i]);
		}
	}
}
