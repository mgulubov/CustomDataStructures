package iteration;

import junit.framework.*;

public class ArrayIteratorTestCase extends TestCase {
	private Object[] _array;
	private Iterator _iterator;
	
	protected Iterator createIterator(Object[] array) {
		return new ArrayIterator(array);
	}
	
	protected Iterator createIterator(Object[] array, int startIndex, int length) {
		return new ArrayIterator(array, startIndex, length);
	}
	
	public void testForwardIteration() {
		this._array = new Object[]{
				"A", "B", "C", "D"
		};
		this._iterator = createIterator(this._array);
		
		this._iterator.first();
		assertFalse(this._iterator.isDone());
		assertSame("A", this._iterator.current());
		
		this._iterator.next();
		assertFalse(this._iterator.isDone());
		assertSame("B", this._iterator.current());
		
		this._iterator.next();
		assertFalse(this._iterator.isDone());
		assertSame("C", this._iterator.current());
		
		this._iterator.next();
		assertFalse(this._iterator.isDone());
		assertSame("D", this._iterator.current());
		
		this._iterator.next();
		assertTrue(this._iterator.isDone());
		try {
			this._iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException iobe) {
			//expected
		}
	}
	
	public void testForwardIterationWithinLimits() {
		this._array = new Object[]{
				"A", "B", "C", "D", "E", "F"
		};
		this._iterator = createIterator(this._array, 2, 3);
		
		this._iterator.first();
		assertFalse(this._iterator.isDone());
		assertSame("C", this._iterator.current());
		
		this._iterator.next();
		assertFalse(this._iterator.isDone());
		assertSame("D", this._iterator.current());
		
		this._iterator.next();
		assertFalse(this._iterator.isDone());
		assertSame("E", this._iterator.current());
		
		this._iterator.next();
		assertTrue(this._iterator.isDone());
		try {
			this._iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException iobe) {
			//expected
		}
	}
	
	public void testBackwardIteration() {
		this._array = new Object[]{
				"A", "B", "C", "D"
		};
		this._iterator = createIterator(this._array);
		
		this._iterator.last();
		assertFalse(this._iterator.isDone());
		assertSame("D", this._iterator.current());
		
		this._iterator.previous();
		assertFalse(this._iterator.isDone());
		assertSame("C", this._iterator.current());
		
		this._iterator.previous();
		assertFalse(this._iterator.isDone());
		assertSame("B", this._iterator.current());
		
		this._iterator.previous();
		assertFalse(this._iterator.isDone());
		assertSame("A", this._iterator.current());
		
		this._iterator.previous();
		assertTrue(this._iterator.isDone());
		try {
			this._iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException iobe) {
			//expected
		}
	}
	
	public void testBackwarIterationWithinLimits() {
		this._array = new Object[]{
				"A", "B", "C", "D", "E", "F"
		};
		this._iterator = createIterator(this._array, 2, 3);
		
		this._iterator.last();
		assertFalse(this._iterator.isDone());
		assertSame("E", this._iterator.current());
		
		this._iterator.previous();
		assertFalse(this._iterator.isDone());
		assertSame("D", this._iterator.current());
		
		this._iterator.previous();
		assertFalse(this._iterator.isDone());
		assertSame("C", this._iterator.current());
		
		this._iterator.previous();
		assertTrue(this._iterator.isDone());
		try {
			this._iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException iobe) {
			//expected
		}
	}
}
