package lists;

import stacks.ListStack;
import stacks.Stack;
import iteration.Iterator;

public class UndoableList implements List {
	private List _list;
	private Stack _undoStack;
	
	public UndoableList() {
		this._list = new ArrayList();
		this._undoStack = new ListStack();
	}
	
	public UndoableList(Object[] array) {
		this._list = new ArrayList(array);
		this._undoStack = new ListStack();
	}
	
	private interface UndoAction {
		public void execute();
	}
	
	public void insert(int index, Object value) throws IndexOutOfBoundsException {
		try {
			this._list.insert(index, value);
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
		this._undoStack.push(new UndoInsertAction(index));
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
	
	public void add(Object value) {
		insert(size(), value);
	}
	
	public Object delete(int index) throws IndexOutOfBoundsException {
		try {
			Object value = this._list.delete(index);
			this._undoStack.push(new UndoDeleteAction(index, value));
			return value;
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private final class UndoDeleteAction implements UndoAction {
		private final Object _value;
		private final int _index;
		
		private UndoDeleteAction(int index, Object value) {
			this._index = index;
			this._value = value;
		}
		
		public void execute() {
			_list.insert(this._index, this._value);
		}
	}
	
	public boolean delete(Object value) {
		assert value != null : "value can't be null";
		int index = indexOf(value);
		if (index != -1) {
			delete(index);
			return true;
		}
		return false;
	}
	
	public Object set(int index, Object value) throws IndexOutOfBoundsException {
		try {
			Object oldValue = this._list.set(index, value);
			this._undoStack.push(new UndoSetAction(index, oldValue));
			return oldValue;
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private final class UndoSetAction implements UndoAction {
		private final Object _value;
		private final int _index;
		
		private UndoSetAction(int index, Object value) {
			this._index = index;
			this._value = value;
		}
		
		public void execute() {
			_list.set(this._index, this._value);
		}
	}
	
	public void clear() {
		this._list.clear();
		this._undoStack.clear();
	}
	
	//private final class UndoClearAction implements UndoAction {
		//TO DO
	//}
	
	public boolean canUndo() {
		return !(this._undoStack.isEmpty());
	}
	
	public void undo() {
		((UndoAction)this._undoStack.pop()).execute();
	}
	
	public Object get(int index) throws IndexOutOfBoundsException {
		try {
			return this._list.get(index);
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
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
	
	public Iterator iterator() {
		return this._list.iterator();
	}
	
	public Iterator iterator(int startIndex, int length) {
		return this._list.iterator(startIndex, length);
	}
}
