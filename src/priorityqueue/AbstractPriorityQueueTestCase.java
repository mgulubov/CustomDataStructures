package priorityqueue;

import junit.framework.*;
import sorting.Comparator;
import sorting.NaturalComparator;
import queues.Queue;
import queues.EmptyQueueException;

public abstract class AbstractPriorityQueueTestCase extends TestCase {
	private static final String VALUE_A = "A";
	private static final String VALUE_B = "B";
	private static final String VALUE_C = "C";
	private static final String VALUE_D = "D";
	private static final String VALUE_E = "E";
	private Comparator _comparator;
	private Queue _queue;
	
	protected abstract Queue createPriorityQueue(Comparator comparator);
	
	protected void setUp() throws Exception {
		super.setUp();
		this._comparator = NaturalComparator.INSTANCE;
		this._queue = createPriorityQueue(this._comparator);
	}
	
	protected void tearDown() throws Exception {
		this._comparator = null;
		this._queue = null;
		super.tearDown();
	}
	
	public void testEnqueue() {
		assertEquals(0, this._queue.size());
		assertTrue(this._queue.isEmpty());
		try {
			this._queue.peek();
			fail();
		} catch (EmptyQueueException eqe) {
			//expected
		}
		
		this._queue.enqueue(VALUE_A);
		assertEquals(1, this._queue.size());
		assertFalse(this._queue.isEmpty());
		assertSame(VALUE_A, this._queue.peek());
		
		this._queue.enqueue(VALUE_C);
		assertEquals(2, this._queue.size());
		assertFalse(this._queue.isEmpty());
		assertSame(VALUE_C, this._queue.peek());
		
		this._queue.enqueue(VALUE_B);
		assertEquals(3, this._queue.size());
		assertFalse(this._queue.isEmpty());
		assertSame(VALUE_C, this._queue.peek());
		
		this._queue.enqueue(VALUE_D);
		assertEquals(4, this._queue.size());
		assertFalse(this._queue.isEmpty());
		assertSame(VALUE_D, this._queue.peek());
	}
	
	public void testDequeue() {
		assertEquals(0, this._queue.size());
		assertTrue(this._queue.isEmpty());
		
		try {
			this._queue.peek();
			fail();
		} catch (EmptyQueueException eqe) {
			//expected
		}
		
		assertEquals(0, this._queue.size());
		assertTrue(this._queue.isEmpty());
		
		try {
			this._queue.dequeue();
			fail();
		} catch (EmptyQueueException eqe) {
			//expected
		}
		
		assertEquals(0, this._queue.size());
		assertTrue(this._queue.isEmpty());
		
		this._queue.enqueue(VALUE_A);
		this._queue.enqueue(VALUE_C);
		this._queue.enqueue(VALUE_B);
		
		assertEquals(3, this._queue.size());
		assertFalse(this._queue.isEmpty());
		assertSame(VALUE_C, this._queue.peek());
		
		assertSame(VALUE_C, this._queue.dequeue());
		assertEquals(2, this._queue.size());
		assertFalse(this._queue.isEmpty());
		assertSame(VALUE_B, this._queue.peek());
		
		assertSame(VALUE_B, this._queue.dequeue());
		assertEquals(1, this._queue.size());
		assertFalse(this._queue.isEmpty());
		assertSame(VALUE_A, this._queue.peek());
		
		this._queue.enqueue(VALUE_E);
		this._queue.enqueue(VALUE_D);
		
		assertEquals(3, this._queue.size());
		assertFalse(this._queue.isEmpty());
		assertSame(VALUE_E, this._queue.peek());
		
		assertSame(VALUE_E, this._queue.dequeue());
		assertEquals(2, this._queue.size());
		assertFalse(this._queue.isEmpty());
		assertSame(VALUE_D, this._queue.peek());
		
		assertSame(VALUE_D, this._queue.dequeue());
		assertEquals(1, this._queue.size());
		assertFalse(this._queue.isEmpty());
		assertSame(VALUE_A, this._queue.peek());
		
		assertSame(VALUE_A, this._queue.dequeue());
		assertEquals(0, this._queue.size());
		assertTrue(this._queue.isEmpty());
		
		try {
			this._queue.peek();
			fail();
		} catch (EmptyQueueException eqe) {
			//expected
		}
		
		assertEquals(0, this._queue.size());
		assertTrue(this._queue.isEmpty());
		
		try {
			this._queue.dequeue();
			fail();
		} catch (EmptyQueueException eqe) {
			//expected
		}
		
		assertEquals(0, this._queue.size());
		assertTrue(this._queue.isEmpty());
	}
	
	public void testClear() {
		assertEquals(0, this._queue.size());
		assertTrue(this._queue.isEmpty());
		
		try {
			this._queue.peek();
			fail();
		} catch (EmptyQueueException eqe) {
			//expected
		}
		
		assertEquals(0, this._queue.size());
		assertTrue(this._queue.isEmpty());
		
		try {
			this._queue.dequeue();
			fail();
		} catch (EmptyQueueException eqe) {
			//expected
		}
		
		assertEquals(0, this._queue.size());
		assertTrue(this._queue.isEmpty());
		
		this._queue.enqueue(VALUE_B);
		this._queue.enqueue(VALUE_C);
		this._queue.enqueue(VALUE_A);
		
		assertEquals(3, this._queue.size());
		assertFalse(this._queue.isEmpty());
		assertSame(VALUE_C, this._queue.peek());
		
		this._queue.clear();
		assertEquals(0, this._queue.size());
		assertTrue(this._queue.isEmpty());
		
		try {
			this._queue.peek();
			fail();
		} catch (EmptyQueueException eqe) {
			//expected
		}
		
		assertEquals(0, this._queue.size());
		assertTrue(this._queue.isEmpty());
		
		try {
			this._queue.dequeue();
			fail();
		} catch (EmptyQueueException eqe) {
			//expected
		}
		
		assertEquals(0, this._queue.size());
		assertTrue(this._queue.isEmpty());
	}
}
