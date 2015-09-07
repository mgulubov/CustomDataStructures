package lists;

import stacks.EmptyStackException;
import junit.framework.*;

public class UndoableListTestCase extends AbstractListTestCase {
	private static final String VALUE_A = "A";
	private static final String VALUE_B = "B";
	private static final String VALUE_C = "C";
	private static final String VALUE_D = "D";
	private UndoableList _list;
	
	protected List createList() {
		return new UndoableList();
	}
	
	protected List createList(Object[] array) {
		return new UndoableList(array);
	}
	
	public void testUndoInsertAction() {
		//Part I
		this._list = new UndoableList();
		assertFalse(this._list.canUndo());
		
		this._list.insert(0, VALUE_A);
		this._list.insert(1, VALUE_B);
		this._list.insert(2, VALUE_C);
		assertTrue(this._list.canUndo());
		
		this._list.undo();
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
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		try {
			this._list.get(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		try {
			this._list.get(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertFalse(this._list.canUndo());
		try {
			this._list.undo();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		//Part II
		this._list = new UndoableList();
		assertFalse(this._list.canUndo());
		
		this._list.insert(0, VALUE_A);
		this._list.insert(1, VALUE_A);
		this._list.insert(2, VALUE_A);
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		try {
			this._list.get(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		try {
			this._list.get(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		
		assertFalse(this._list.canUndo());
		try {
			this._list.undo();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		//Part III
		this._list = new UndoableList();
		assertFalse(this._list.canUndo());
		
		this._list.insert(0, VALUE_A);
		this._list.insert(0, VALUE_B);
		this._list.insert(0, VALUE_C);
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_B, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		try {
			this._list.get(2);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		try {
			this._list.get(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//expected
		}
		assertTrue(this._list.canUndo());
		
		this._list.undo();
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
		
		assertFalse(this._list.canUndo());
		try {
			this._list.undo();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
	}
	
	public void testUndoInsertExistingArray() {
		Object[] array = new Object[]{
				"A", "B"
		};
		this._list = new UndoableList(array);
		
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertFalse(this._list.canUndo());
		
		this._list.insert(1, VALUE_C);
		this._list.insert(3, VALUE_D);
		
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_D, this._list.get(3));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(3, this._list.size());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertFalse(this._list.canUndo());
		
		try {
			this._list.undo();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertFalse(this._list.canUndo());
	}
	
	public void testUndoAdd() {
		this._list = new UndoableList();
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		assertFalse(this._list.canUndo());
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		assertFalse(this._list.canUndo());
		
		try {
			this._list.undo();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		assertFalse(this._list.canUndo());
	}
	
	public void testUndoAddExistingArray() {
		Object[] array = new Object[]{
				"A", "B"
		};
		this._list = new UndoableList(array);
		
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertFalse(this._list.canUndo());
		
		this._list.add(VALUE_C);
		this._list.add(VALUE_D);
		
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertSame(VALUE_D, this._list.get(3));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertFalse(this._list.canUndo());
		
		try {
			this._list.undo();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertFalse(this._list.canUndo());
	}
	
	public void testUndoDeleteByIndex() {
		this._list = new UndoableList();
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertTrue(this._list.canUndo());
		
		assertSame(VALUE_A, this._list.delete(1));
		assertSame(VALUE_B, this._list.delete(1));
		assertSame(VALUE_C, this._list.delete(1));
		assertSame(VALUE_A, this._list.delete(0));
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertTrue(this._list.canUndo());
	}
	
	public void testUndoDeleteByIndexExistingArray() {
		Object[] array = new Object[]{
				"A", "A", "B", "C"
		};
		this._list = new UndoableList(array);
		
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertFalse(this._list.canUndo());
		
		try {
			this._list.undo();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertFalse(this._list.canUndo());
		
		assertSame(VALUE_A, this._list.delete(1));
		assertSame(VALUE_B, this._list.delete(1));
		assertSame(VALUE_C, this._list.delete(1));
		assertSame(VALUE_A, this._list.delete(0));
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertFalse(this._list.canUndo());
	}
	
	public void testUndoDeleteByValue() {
		this._list = new UndoableList();
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_A);
		this._list.add(VALUE_B);
		this._list.add(VALUE_C);
		
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertTrue(this._list.canUndo());
		
		assertTrue(this._list.delete(VALUE_B));
		assertTrue(this._list.delete(VALUE_A));
		assertTrue(this._list.delete(VALUE_C));
		assertTrue(this._list.delete(VALUE_A));
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		this._list.undo();
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertTrue(this._list.canUndo());
	}
	
	public void testUndoDeleteByValueExistingArray() {
		Object[] array = new Object[]{
				"A", "A", "B", "C"
		};
		this._list = new UndoableList(array);
		
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertFalse(this._list.canUndo());
		
		try {
			this._list.undo();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertFalse(this._list.canUndo());
		
		assertTrue(this._list.delete(VALUE_B));
		assertTrue(this._list.delete(VALUE_A));
		assertTrue(this._list.delete(VALUE_C));
		assertTrue(this._list.delete(VALUE_A));
		
		assertEquals(0, this._list.size());
		assertTrue(this._list.isEmpty());
		
		this._list.undo();
		assertEquals(1, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(2, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_C, this._list.get(1));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_C, this._list.get(2));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(4, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertFalse(this._list.canUndo());
		
		try {
			this._list.undo();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_B, this._list.get(2));
		assertSame(VALUE_C, this._list.get(3));
		assertFalse(this._list.canUndo());
	}
	
	public void testUndoSet() {
		this._list = new UndoableList();
		
		this._list.add(VALUE_A);
		this._list.add(VALUE_A);
		this._list.add(VALUE_A);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_A, this._list.get(2));
		assertTrue(this._list.canUndo());
		
		assertSame(VALUE_A, this._list.set(1, VALUE_B));
		assertSame(VALUE_A, this._list.set(2, VALUE_D));
		assertSame(VALUE_A, this._list.set(0, VALUE_C));
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_C, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_D, this._list.get(2));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_D, this._list.get(2));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_A, this._list.get(2));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_A, this._list.get(2));
		assertTrue(this._list.canUndo());
	}
	
	public void testUndoSetExistingArray() {
		Object[] array = new Object[]{
				"A", "A", "A"
		};
		this._list = new UndoableList(array);
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_A, this._list.get(2));
		assertFalse(this._list.canUndo());
		
		try {
			this._list.undo();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertSame(VALUE_A, this._list.set(1, VALUE_B));
		assertSame(VALUE_A, this._list.set(2, VALUE_D));
		assertSame(VALUE_A, this._list.set(0, VALUE_C));
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_C, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_D, this._list.get(2));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_D, this._list.get(2));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_B, this._list.get(1));
		assertSame(VALUE_A, this._list.get(2));
		assertTrue(this._list.canUndo());
		
		this._list.undo();
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_A, this._list.get(2));
		assertFalse(this._list.canUndo());
		
		try {
			this._list.undo();
			fail();
		} catch (EmptyStackException ese) {
			//expected
		}
		
		assertEquals(3, this._list.size());
		assertFalse(this._list.isEmpty());
		assertSame(VALUE_A, this._list.get(0));
		assertSame(VALUE_A, this._list.get(1));
		assertSame(VALUE_A, this._list.get(2));
		assertFalse(this._list.canUndo());
	}
}
