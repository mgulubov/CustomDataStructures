package stacks;

import lists.List;
import lists.LinkedList;
import iteration.Iterator;

public class UndoableList implements List {
	private List _list;
	private Stack _undoStack;
	
	public UndoableList() {
		this._list = new LinkedList();
		this._undoStack = new ListStack();
	}
	
	private interface UndoAction {
		public void execute();
	}
	
	public void insert(int index, Object value) {
		this._list.insert(index, value);
		this._undoStack.push(new UndoInsertAction(index));
	}
	
	public void add(Object value) {
		insert(size(), value);
	}
	
	private final class UndoInsertAction implements UndoAction {
		private final int _index;
		
		private UndoInsertAction(int index) {
			this._index = index;
		}
		
		public void execute() {
			_list.delete(this._index);
		}
	}
	
	public Object delete(int index) throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		Object value = this._list.delete(index);
		this._undoStack.push(new UndoDeleteAction(index, value));
		return value;
	}
	
	public boolean delete(Object value) {
		int index = this._list.indexOf(value);
		if (index != -1) {
			delete(index);
			return true;
		}
		return false;
	}
	
	private final class UndoDeleteAction implements UndoAction {
		private final int _index;
		private final Object _value;
		
		private UndoDeleteAction(int index, Object value) {
			this._index = index;
			this._value = value;
		}
		
		public void execute() {
			_list.insert(this._index, this._value);
		}
	}
	
	public Object set(int index, Object value) throws IndexOutOfBoundsException {
		Object oldValue;
		try {
			oldValue = this._list.set(index, value);
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
		this._undoStack.push(new UndoSetAction(index, oldValue));
		return oldValue;
	}
	
	private final class UndoSetAction implements UndoAction {
		private final int _index;
		private final Object _value;
		
		private UndoSetAction(int index, Object value) {
			this._index = index;
			this._value = value;
		}
		
		public void execute() {
			_list.set(this._index, this._value);
		}
	}
	
	public Object get(int index) {
		return this._list.get(index);
	}
	
	public int size() {
		return this._list.size();
	}
	
	public int indexOf(Object value) {
		return this._list.indexOf(value);
	}
	
	public boolean isEmpty() {
		return this._list.isEmpty();
	}
	
	public boolean contains(Object value) {
		return this._list.contains(value);
	}
	
	public void clear() {
		this._list.clear();
		this._undoStack.clear();
	}
	
	public Iterator iterator() {
		return this._list.iterator();
	}
	
	public Iterator iterator(int startIndex, int length) {
		return this._list.iterator(startIndex, length);
	}
}