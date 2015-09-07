package lists;

import junit.framework.*;
import iteration.Iterator;
import iteration.IteratorOutOfBoundsException;

public abstract class AbstractListTestCase extends TestCase {
	private static final String VALUE_A = "A";
	private static final String VALUE_B = "B";
	private static final String VALUE_C = "C";
	private static final String VALUE_D = "D";
	private List _list;
	
	protected abstract List createList();
	protected abstract List createList(Object[] array);
	
	public void testInsertIntoEmptyList() {
		this._list = createList();
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		this._list.insert(0, VALUE_A);
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
	}
	
	public void testInsertBeforeFirstElement() {
		this._list = createList();
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		this._list.insert(0, VALUE_A);
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		this._list.insert(0, VALUE_B);
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
	}
	
	public void testInsertAfterLastElement() {
		this._list = createList();
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		this._list.insert(0, VALUE_A);
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		this._list.insert(0, VALUE_B);
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		
		this._list.insert(2, VALUE_C);
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
	}
	
	public void testInsertBetweenElements() {
		this._list = createList();
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		this._list.insert(0, VALUE_A);
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		this._list.insert(0, VALUE_B);
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		
		this._list.insert(2, VALUE_C);
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		this._list.insert(1, VALUE_D);
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_D, this._list.get(1));
		assertSame(VALUE_A, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
	}
	
	public void testInsertOutOfBounds() {
		this._list = createList();
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		try {
			this._list.insert(-1, VALUE_A);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		try {
			this._list.insert(1, VALUE_A);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		this._list.insert(0, VALUE_A);
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		try {
			this._list.insert(-1, VALUE_B);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		try {
			this._list.insert(2, VALUE_B);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
	}
	
	public void testCreateListFromExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
	}
	
	public void testInsertBeforeFirstElementExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		this._list.insert(0, VALUE_D);
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_D, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
	}
	
	public void testInsertAfterLastElementExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		this._list.insert(3, VALUE_D);
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertSame(VALUE_D, this._list.get(3));
	}
	
	public void testInsertBetweenElementsExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		this._list.insert(1, VALUE_D);
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_D, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
	}
	
	public void testInsertOutOfBoundsExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		try {
			this._list.insert(-1, VALUE_D);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		try {
			this._list.insert(4, VALUE_D);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
	}
	
	public void testAdd() {
		this._list = createList();
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		this._list.add(VALUE_A);
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		this._list.add(VALUE_B);
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		
		this._list.add(VALUE_C);
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
	}
	
	public void testAddExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		this._list.add(VALUE_D);
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertSame(VALUE_D, this._list.get(3));
		
		this._list.add(VALUE_A);
		assertEquals(5, this._list.size());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertSame(VALUE_D, this._list.get(3));
		assertSame(VALUE_A, this._list.get(4));
		assertFalse(this._list.isEmpty());
	}
	
	public void testDeleteByIndexOnlyElement() {
		this._list = createList();
		
		this._list.add(VALUE_A);
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		assertSame(VALUE_A, this._list.delete(0));
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		try {
			this._list.get(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
	}
	
	public void testDeleteByIndexFirstElement() {
		this._list = createList();
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertSame(VALUE_A, this._list.delete(0));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
	}
	
	public void testDeleteByIndexLastElement() {
		this._list = createList();
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertSame(VALUE_C, this._list.delete(2));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
	}
	
	public void testDeleteByIndexMiddleElement() {
		this._list = createList();
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertSame(VALUE_B, this._list.delete(1));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
	}
	
	public void testDeleteByIndexOutOfBounds() {
		this._list = createList();
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		try {
			this._list.delete(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		try {
			this._list.delete(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		try {
			this._list.delete(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		this._list.add(VALUE_A);
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		try {
			this._list.delete(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		try {
			this._list.delete(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
	}
	
	public void testDeleteByIndexSingleElementExistingArray() {
		Object[] array = new Object[]{
				"A"
		};
		this._list = createList(array);
		
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		
		assertSame(VALUE_A, this._list.delete(0));
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		try {
			this._list.get(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
	}
	
	public void testDeleteByIndexFirstElementExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertSame(VALUE_A, this._list.delete(0));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
	}
	
	public void testDeleteByIndexLastElementExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertSame(VALUE_C, this._list.delete(2));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
	}
	
	public void testDeleteByIndexMiddleElementExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertSame(VALUE_B, this._list.delete(1));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
	}
	
	public void testDeleteByIndexOutOfBoundsExistingArray() {
		Object[] array = new Object[]{
				"A"
		};
		this._list = createList(array);
		
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		try {
			this._list.delete(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		try {
			this._list.delete(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		this._list.add(VALUE_B);
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		
		try {
			this._list.delete(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		
		try {
			this._list.delete(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		
		assertSame(VALUE_A, this._list.delete(0));
		assertSame(VALUE_B, this._list.delete(0));
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		try {
			this._list.delete(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		try {
			this._list.delete(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		try {
			this._list.delete(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
	}
	
	public void testDeleteByValueSingleElement() {
		this._list = createList();
		
		this._list.add(VALUE_A);
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		assertTrue(this._list.delete(VALUE_A));
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		try {
			this._list.get(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
	}
	
	public void testDeleteByValueFirstElement() {
		this._list = createList();
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertTrue(this._list.delete(VALUE_A));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		
		assertFalse(this._list.delete(VALUE_A));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
	}
	
	public void testDeleteByValueLastElement() {
		this._list = createList();
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertTrue(this._list.delete(VALUE_C));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		
		assertFalse(this._list.delete(VALUE_C));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
	}
	
	public void testDeleteByValueMiddleElement() {
		this._list = createList();
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertTrue(this._list.delete(VALUE_B));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		
		assertFalse(this._list.delete(VALUE_B));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
	}
	
	public void testDeleteByValueWhileKeepingEqualNeighbour() {
		//Part I
		this._list = createList();
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_B);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		
		assertTrue(this._list.delete(VALUE_B));
		assertEquals(2, this._list.size());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		//Part II
		this._list = null;
		this._list = createList();
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		
		assertTrue(this._list.delete(VALUE_A));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
	}
	
	public void testDeleteByValueSingleElementExistingArray() {
		Object[] array = new Object[]{
				"A"
		};
		this._list = createList(array);
		
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		assertTrue(this._list.delete(VALUE_A));
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		assertFalse(this._list.delete(VALUE_A));
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		try {
			this._list.get(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
	}
	
	public void testDeleteByValueFirstElementExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertTrue(this._list.delete(VALUE_A));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		
		assertFalse(this._list.delete(VALUE_A));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
	}
	
	public void testDeleteByValueLastElementExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertTrue(this._list.delete(VALUE_C));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		
		assertFalse(this._list.delete(VALUE_C));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
	}
	
	public void testDeleteByValueMiddleElementExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertTrue(this._list.delete(VALUE_B));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		
		assertFalse(this._list.delete(VALUE_B));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
	}
	
	public void testDeleteByValueWhileKeepingEqualNeighbourExistingArray() {
		//Part I
		Object[] array = new Object[]{
				"A", "B", "B"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		
		assertTrue(this._list.delete(VALUE_B));
		assertEquals(2, this._list.size());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		//Part II
		array = null;
		array = new Object[]{
				"A", "A", "B"
		};
		this._list = null;
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		
		assertTrue(this._list.delete(VALUE_A));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
	}
	
	public void testSetOnlyElement() {
		this._list = createList();
		
		this._list.add(VALUE_A);
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		assertSame(VALUE_A, this._list.set(0, VALUE_B));
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
	}
	
	public void testSetFirstElement() {
		this._list = createList();
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertSame(VALUE_A, this._list.set(0, VALUE_D));
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_D, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
	}
	
	public void testSetLastElement() {
		this._list = createList();
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertSame(VALUE_C, this._list.set(2, VALUE_D));
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_D, this._list.get(2));
	}
	
	public void testSetMiddleElement() {
		this._list = createList();
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertSame(VALUE_B, this._list.set(1, VALUE_D));
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_D, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
	}
	
	public void testSetOutOfBounds() {
		this._list = createList();
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		try {
			this._list.set(-1, VALUE_A);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		try {
			this._list.set(0, VALUE_A);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		try {
			this._list.set(1, VALUE_A);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		this._list.add(VALUE_A);
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		try {
			this._list.set(-1, VALUE_B);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		try {
			this._list.set(1, VALUE_B);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
	}
	
	public void testSetOnlyElementExistingArray() {
		Object[] array = new Object[]{
				"A"
		};
		this._list = createList(array);
		
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		
		assertSame(VALUE_A, this._list.set(0, VALUE_B));
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
	}
	
	public void testSetFirstElementExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertSame(VALUE_A, this._list.set(0, VALUE_D));
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_D, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
	}
	
	public void testSetLastElementExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertSame(VALUE_C, this._list.set(2, VALUE_D));
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_D, this._list.get(2));
	}
	
	public void tesSetMiddleElementExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		assertSame(VALUE_B, this._list.set(1, VALUE_D));
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_D, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
	}
	
	public void testSetOutOfBoundsExistingArray() {
		//Part I
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		try {
			this._list.set(-1, VALUE_D);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		try {
			this._list.set(3, VALUE_D);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
	}
	
	public void testClear() {
		this._list = createList();
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		this._list.clear();
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
	}
	
	public void testClearExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		
		this._list.clear();
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
	}
	
	public void testContains() {
		this._list = createList();
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		assertFalse(this._list.contains(VALUE_A));
		assertFalse(this._list.contains(VALUE_B));
		assertFalse(this._list.contains(VALUE_C));
		
		this._list.add(VALUE_A);
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertTrue(this._list.contains(VALUE_A));
		assertFalse(this._list.contains(VALUE_B));
		assertFalse(this._list.contains(VALUE_C));
		
		this._list.add(VALUE_B);
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertTrue(this._list.contains(VALUE_A));
		assertTrue(this._list.contains(VALUE_B));
		assertFalse(this._list.contains(VALUE_C));
		
		this._list.add(VALUE_C);
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertTrue(this._list.contains(VALUE_A));
		assertTrue(this._list.contains(VALUE_B));
		assertTrue(this._list.contains(VALUE_C));
		
		assertSame(VALUE_C, this._list.delete(2));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertTrue(this._list.contains(VALUE_A));
		assertTrue(this._list.contains(VALUE_B));
		assertFalse(this._list.contains(VALUE_C));
		
		assertSame(VALUE_A, this._list.delete(0));
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertFalse(this._list.contains(VALUE_A));
		assertTrue(this._list.contains(VALUE_B));
		assertFalse(this._list.contains(VALUE_C));
		
		assertSame(VALUE_B, this._list.delete(0));
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		assertFalse(this._list.contains(VALUE_A));
		assertFalse(this._list.contains(VALUE_B));
		assertFalse(this._list.contains(VALUE_C));
	}
	
	public void testContainsExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertTrue(this._list.contains(VALUE_A));
		assertTrue(this._list.contains(VALUE_B));
		assertTrue(this._list.contains(VALUE_C));
		
		assertSame(VALUE_C, this._list.delete(2));
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertTrue(this._list.contains(VALUE_A));
		assertTrue(this._list.contains(VALUE_B));
		assertFalse(this._list.contains(VALUE_C));
		
		assertSame(VALUE_A, this._list.delete(0));
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertFalse(this._list.contains(VALUE_A));
		assertTrue(this._list.contains(VALUE_B));
		assertFalse(this._list.contains(VALUE_C));
		
		assertSame(VALUE_B, this._list.delete(0));
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		assertFalse(this._list.contains(VALUE_A));
		assertFalse(this._list.contains(VALUE_B));
		assertFalse(this._list.contains(VALUE_C));
	}
	
	public void testIndexOf() {
		this._list = createList();
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		assertEquals(-1, this._list.indexOf(VALUE_A));
		assertEquals(-1, this._list.indexOf(VALUE_B));
		assertEquals(-1, this._list.indexOf(VALUE_C));
		
		this._list.add(VALUE_A);
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertEquals(0, this._list.indexOf(VALUE_A));
		assertEquals(-1, this._list.indexOf(VALUE_B));
		assertEquals(-1, this._list.indexOf(VALUE_C));
		
		this._list.add(VALUE_A);
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertEquals(0, this._list.indexOf(VALUE_A));
		assertEquals(-1, this._list.indexOf(VALUE_B));
		assertEquals(-1, this._list.indexOf(VALUE_C));
		
		this._list.add(VALUE_B);
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertEquals(0, this._list.indexOf(VALUE_A));
		assertEquals(2, this._list.indexOf(VALUE_B));
		assertEquals(-1, this._list.indexOf(VALUE_C));
		
		this._list.add(VALUE_C);
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertEquals(0, this._list.indexOf(VALUE_A));
		assertEquals(2, this._list.indexOf(VALUE_B));
		assertEquals(3, this._list.indexOf(VALUE_C));
		
		this._list.add(VALUE_C);
		assertEquals(5, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertSame(VALUE_C, this._list.get(4));
		assertEquals(0, this._list.indexOf(VALUE_A));
		assertEquals(2, this._list.indexOf(VALUE_B));
		assertEquals(3, this._list.indexOf(VALUE_C));
		
		assertSame(VALUE_B, this._list.delete(2));
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertEquals(0, this._list.indexOf(VALUE_A));
		assertEquals(-1, this._list.indexOf(VALUE_B));
		assertEquals(2, this._list.indexOf(VALUE_C));
		
		assertSame(VALUE_C, this._list.delete(2));
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertEquals(0, this._list.indexOf(VALUE_A));
		assertEquals(-1, this._list.indexOf(VALUE_B));
		assertEquals(2, this._list.indexOf(VALUE_C));
		
		this._list.clear();
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		assertEquals(-1, this._list.indexOf(VALUE_A));
		assertEquals(-1, this._list.indexOf(VALUE_B));
		assertEquals(-1, this._list.indexOf(VALUE_D));
	}
	
	public void testIndexOfExistingArray() {
		Object[] array = new Object[]{
				"A", "A", "B", "C", "C"
		};
		this._list = createList(array);
		
		assertEquals(5, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertSame(VALUE_C, this._list.get(4));
		assertEquals(0, this._list.indexOf(VALUE_A));
		assertEquals(2, this._list.indexOf(VALUE_B));
		assertEquals(3, this._list.indexOf(VALUE_C));
		
		assertSame(VALUE_B, this._list.delete(2));
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertEquals(0, this._list.indexOf(VALUE_A));
		assertEquals(-1, this._list.indexOf(VALUE_B));
		assertEquals(2, this._list.indexOf(VALUE_C));
		
		assertSame(VALUE_C, this._list.delete(2));
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertEquals(0, this._list.indexOf(VALUE_A));
		assertEquals(-1, this._list.indexOf(VALUE_B));
		assertEquals(2, this._list.indexOf(VALUE_C));
		
		this._list.clear();
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		assertEquals(-1, this._list.indexOf(VALUE_A));
		assertEquals(-1, this._list.indexOf(VALUE_B));
		assertEquals(-1, this._list.indexOf(VALUE_D));
	}
	
	public void testIteratorForward() {
		this._list = createList();
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		
		Iterator iterator = this._list.iterator();
		iterator.first();
		
		assertFalse(iterator.isDone());
		assertSame(VALUE_A, iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(VALUE_B, iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(VALUE_C, iterator.current());
		
		iterator.next();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException iobe) {
			//expected
		}
	}
	
	public void testIteratorBackwards() {
		this._list = createList();
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		Iterator iterator = this._list.iterator();
		
		iterator.last();
		assertFalse(iterator.isDone());
		assertSame(VALUE_C, iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(VALUE_B, iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(VALUE_A, iterator.current());
		
		iterator.previous();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException ioeb) {
			//expected
		}
	}
	
	public void testIteratorWithinLimits() {
		this._list = createList();
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		this._list.add(VALUE_D);
		Iterator iterator = this._list.iterator(1, 2);
		
		iterator.first();
		assertFalse(iterator.isDone());
		assertSame(VALUE_B, iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(VALUE_C, iterator.current());
		
		iterator.next();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException iobe) {
			//expected
		}
	}
	
	public void testIteratorForwardExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		Iterator iterator = this._list.iterator();
		
		iterator.first();
		assertFalse(iterator.isDone());
		assertSame(VALUE_A, iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(VALUE_B, iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(VALUE_C, iterator.current());
		
		iterator.next();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException iobe) {
			//expected
		}
	}
	
	public void testIteratorBackwardsExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C"
		};
		this._list = createList(array);
		Iterator iterator = this._list.iterator();
		
		iterator.last();
		assertFalse(iterator.isDone());
		assertSame(VALUE_C, iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(VALUE_B, iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(VALUE_A, iterator.current());
		
		iterator.previous();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException ioeb) {
			//expected
		}
	}
	
	public void testIteratoWithinLimitsExistingArray() {
		Object[] array = new Object[]{
				"A", "B", "C", "D"
		};
		this._list = createList(array);
		Iterator iterator = this._list.iterator(1, 2);
		
		iterator.first();
		assertFalse(iterator.isDone());
		assertSame(VALUE_B, iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(VALUE_C, iterator.current());
		
		iterator.next();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException iobe) {
			//expected
		}
	}
	
	public void testIteratorExistingArraySameValues() {
		Object[] array = new Object[]{
				"A", "A", "A", "A"
		};
		this._list = createList(array);
		Iterator iterator = this._list.iterator(1, 2);
		
		iterator.first();
		assertFalse(iterator.isDone());
		assertSame(VALUE_A, iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(VALUE_A, iterator.current());
		
		iterator.next();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException iobe) {
			//expected
		}
	}
}