package decks;

import junit.framework.*;
import stacks.EmptyStackException;

public class DeckTestCase extends TestCase {
	private static final String VALUE_A = "A";
	private static final String VALUE_B = "B";
	private static final String VALUE_C = "C";
	private static final String VALUE_D = "D";
	private Deck _deck;
	
	protected void setUp() throws Exception {
		super.setUp();
		this._deck = new DeckStack();
	}
	
	protected void tearDown() throws Exception {
		this._deck = null;
		super.tearDown();
	}
	
	public void testAddInBack() {
		assertTrue(this._deck.isEmpty());
		assertEquals(0, this._deck.size());
		assertEquals(0, this._deck.backSize());
		assertEquals(0, this._deck.frontSize());
		try {
			this._deck.peekInBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		this._deck.addInBack(VALUE_A);
		assertFalse(this._deck.isEmpty());
		assertEquals(1, this._deck.size());
		assertEquals(1, this._deck.backSize());
		assertEquals(0, this._deck.frontSize());
		assertSame(VALUE_A, this._deck.peekInBack());
		assertSame(VALUE_A, this._deck.peek());
		try {
			this._deck.peekInFront();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		this._deck.addInBack(VALUE_B);
		assertFalse(this._deck.isEmpty());
		assertEquals(2, this._deck.size());
		assertEquals(2, this._deck.backSize());
		assertEquals(0, this._deck.frontSize());
		assertSame(VALUE_B, this._deck.peekInBack());
		assertSame(VALUE_B, this._deck.peek());
		try {
			this._deck.peekInFront();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		this._deck.addInBack(VALUE_C);
		assertFalse(this._deck.isEmpty());
		assertEquals(3, this._deck.size());
		assertEquals(3, this._deck.backSize());
		assertEquals(0, this._deck.frontSize());
		assertSame(VALUE_C, this._deck.peekInBack());
		assertSame(VALUE_C, this._deck.peek());
		try {
			this._deck.peekInFront();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
	}
	
	public void testdeleteFromBack() {
		try {
			this._deck.deleteFromBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		this._deck.addInBack(VALUE_A);
		this._deck.addInBack(VALUE_B);
		this._deck.addInBack(VALUE_C);
		
		assertSame(VALUE_C, this._deck.deleteFromBack());
		assertFalse(this._deck.isEmpty());
		assertEquals(2, this._deck.size());
		assertEquals(2, this._deck.backSize());
		assertEquals(0, this._deck.frontSize());
		assertSame(VALUE_B, this._deck.peek());
		assertSame(VALUE_B, this._deck.peekInBack());
		
		assertSame(VALUE_B, this._deck.deleteFromBack());
		assertFalse(this._deck.isEmpty());
		assertEquals(1, this._deck.size());
		assertEquals(1, this._deck.backSize());
		assertEquals(0, this._deck.frontSize());
		assertSame(VALUE_A, this._deck.peek());
		assertSame(VALUE_A, this._deck.peekInBack());
		
		assertSame(VALUE_A, this._deck.deleteFromBack());
		assertTrue(this._deck.isEmpty());
		assertEquals(0, this._deck.size());
		assertEquals(0, this._deck.backSize());
		assertEquals(0, this._deck.frontSize());
		
		try {
			this._deck.peek();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		try {
			this._deck.peekInBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		try {
			this._deck.deleteFromBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
	}
	
	public void testPush() {
		assertTrue(this._deck.isEmpty());
		assertEquals(0, this._deck.backSize());
		assertEquals(0, this._deck.frontSize());
		assertEquals(0, this._deck.size());
		
		try {
			this._deck.peek();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		try {
			this._deck.peekInFront();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		try {
			this._deck.peekInBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		this._deck.addInFront(VALUE_A);
		assertFalse(this._deck.isEmpty());
		assertEquals(0, this._deck.backSize());
		assertEquals(1, this._deck.frontSize());
		assertEquals(1, this._deck.size());
		assertSame(VALUE_A, this._deck.peek());
		assertSame(VALUE_A, this._deck.peekInFront());
		try {
			this._deck.peekInBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		this._deck.addInFront(VALUE_B);
		assertFalse(this._deck.isEmpty());
		assertEquals(0, this._deck.backSize());
		assertEquals(2, this._deck.frontSize());
		assertEquals(2, this._deck.size());
		assertSame(VALUE_B, this._deck.peek());
		assertSame(VALUE_B, this._deck.peekInFront());
		try {
			this._deck.peekInBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		this._deck.addInFront(VALUE_C);
		assertFalse(this._deck.isEmpty());
		assertEquals(0, this._deck.backSize());
		assertEquals(3, this._deck.frontSize());
		assertEquals(3, this._deck.size());
		assertSame(VALUE_C, this._deck.peek());
		assertSame(VALUE_C, this._deck.peekInFront());
		try {
			this._deck.peekInBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
	}
	
	public void testdeleteFromFront() {
		try {
			this._deck.deleteFromFront();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		try {
			this._deck.deleteFromBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		this._deck.addInFront(VALUE_A);
		this._deck.addInFront(VALUE_B);
		this._deck.addInFront(VALUE_C);
		
		assertSame(VALUE_C, this._deck.deleteFromFront());
		assertEquals(2, this._deck.size());
		assertEquals(2, this._deck.frontSize());
		assertEquals(0, this._deck.backSize());
		assertSame(VALUE_B, this._deck.peek());
		assertSame(VALUE_B, this._deck.peekInFront());
		try {
			this._deck.deleteFromBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertSame(VALUE_B, this._deck.deleteFromFront());
		assertEquals(1, this._deck.size());
		assertEquals(1, this._deck.frontSize());
		assertEquals(0, this._deck.backSize());
		assertSame(VALUE_A, this._deck.peek());
		assertSame(VALUE_A, this._deck.peekInFront());
		try {
			this._deck.deleteFromBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertSame(VALUE_A, this._deck.deleteFromFront());
		assertEquals(0, this._deck.size());
		assertEquals(0, this._deck.frontSize());
		assertEquals(0, this._deck.backSize());
		
		try {
			this._deck.peek();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		try {
			this._deck.peekInFront();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		try {
			this._deck.deleteFromBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		try {
			this._deck.deleteFromFront();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
	}
	
	public void testEnqueuePushdeleteFromBackdeleteFromFront() {
		this._deck.addInBack(VALUE_A);
		this._deck.addInFront(VALUE_B);
		this._deck.addInFront(VALUE_C);
		this._deck.addInBack(VALUE_D);
		
		assertFalse(this._deck.isEmpty());
		assertFalse(this._deck.frontIsEmpty());
		assertFalse(this._deck.backIsEmpty());
		assertEquals(4, this._deck.size());
		assertEquals(2, this._deck.backSize());
		assertEquals(2, this._deck.frontSize());
		assertSame(VALUE_D, this._deck.peekInBack());
		assertSame(VALUE_C, this._deck.peekInFront());
		
		assertSame(VALUE_D, this._deck.deleteFromBack());
		assertFalse(this._deck.isEmpty());
		assertFalse(this._deck.frontIsEmpty());
		assertFalse(this._deck.backIsEmpty());
		assertEquals(3, this._deck.size());
		assertEquals(1, this._deck.backSize());
		assertEquals(2, this._deck.frontSize());
		assertSame(VALUE_A, this._deck.peekInBack());
		assertSame(VALUE_C, this._deck.peekInFront());
		
		assertSame(VALUE_C, this._deck.deleteFromFront());
		assertFalse(this._deck.isEmpty());
		assertEquals(2, this._deck.size());
		assertFalse(this._deck.frontIsEmpty());
		assertFalse(this._deck.backIsEmpty());
		assertEquals(1, this._deck.backSize());
		assertEquals(1, this._deck.frontSize());
		assertSame(VALUE_A, this._deck.peekInBack());
		assertSame(VALUE_B, this._deck.peekInFront());
		
		assertSame(VALUE_A, this._deck.deleteFromBack());
		assertFalse(this._deck.isEmpty());
		assertEquals(1, this._deck.size());
		assertFalse(this._deck.frontIsEmpty());
		assertTrue(this._deck.backIsEmpty());
		assertEquals(0, this._deck.backSize());
		assertEquals(1, this._deck.frontSize());
		assertSame(VALUE_B, this._deck.peekInFront());
		try {
			this._deck.peekInBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertSame(VALUE_B, this._deck.deleteFromFront());
		assertTrue(this._deck.isEmpty());
		assertEquals(0, this._deck.size());
		assertTrue(this._deck.frontIsEmpty());
		assertTrue(this._deck.backIsEmpty());
		assertEquals(0, this._deck.backSize());
		assertEquals(0, this._deck.frontSize());
		try {
			this._deck.peekInBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		try {
			this._deck.peekInFront();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		try {
			this._deck.deleteFromBack();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		try {
			this._deck.deleteFromFront();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
	}
}
