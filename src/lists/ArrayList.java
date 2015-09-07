package lists;

import iteration.Iterator;
import iteration.ArrayIterator;

public class ArrayList implements List {
	private Object[] _array;
	private int _capacity;
	private int _size;
	private static final int INITIAL_CAPACITY = 14;
	
	public ArrayList() {
		this._capacity = INITIAL_CAPACITY;
		this._array = new Object[this._capacity];
		this._size = 0;
	}
	
	public ArrayList(Object[] array) throws NullPointerException {
		assert array != null : "array can't be null";
		this._capacity = INITIAL_CAPACITY;
		this._array = new Object[this._capacity];
		this._size = 0;
		addValues(array);
	}
	
	public ArrayList(int capacity) {
		assert capacity > 0 : "capacity must be > 0";
		this._capacity = capacity;
		this._array = new Object[this._capacity];
		this._size = 0;
	}
	
	private void addValues(Object[] array) {
		for (int i = 0; i < array.length; i++) {
			insert(i, array[i]);
		}
	}
	
	public void insert(int index, Object value) throws IndexOutOfBoundsException {
		if (index > this._size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		assert value != null : "value can't be null";
		
		checkCapacity();
		
		System.arraycopy(this._array, index, this._array, index + 1, this._size - index);
		this._array[index] = value;
		this._size++;
	}
	
	public void add(Object value) {
		assert value != null : "value can't be null";
		insert(this._size, value);
	}
	
	private void checkCapacity() {
		if (this._size >= this._capacity) {
			int newCapacity = (this._capacity + (this._capacity / 2)) + 1;
			this._capacity = newCapacity;
			Object[] newArray = new Object[this._capacity];
			System.arraycopy(this._array, 0, newArray, 0, this._size);
			this._array = newArray;
		}
	}
	
	public Object delete(int index) throws IndexOutOfBoundsException {
		checkIfOutOfBounds(index);
		
		Object deletedValue = this._array[index];
		this._array[index] = null;
		System.arraycopy(this._array, index + 1, this._array, index, this._size - (index + 1));
		this._size--;
		
		return deletedValue;
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
	
	private void checkIfOutOfBounds(int index) {
		if (isOutOfBounds(index)) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private boolean isOutOfBounds(int index) {
		return index >= this._size || index < 0;
	}
	
	public Object set(int index, Object value) throws IndexOutOfBoundsException {
		checkIfOutOfBounds(index);
		assert value != null : "value can't be null";
		
		Object oldValue = this._array[index];
		this._array[index] = value;
		
		return oldValue;
	}
	
	public Object get(int index) throws IndexOutOfBoundsException {
		checkIfOutOfBounds(index);
		return this._array[index];
	}
	
	public int indexOf(Object value) {
		assert value != null : "value can't be null";
		
		for (int i = 0; i < this._size; i++) {
			if (this._array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean contains(Object value) {
		assert value != null : "value can't be null";
		int index = indexOf(value);
		if (index != -1) {
			return true;
		}
		return false;
	}
	
	public int size() {
		return this._size;
	}
	
	public void clear() {
		this._capacity = INITIAL_CAPACITY;
		this._array = new Object[this._capacity];
		this._size = 0;
	}
	
	public boolean isEmpty() {
		return this._size == 0;
	}
	
	public Iterator iterator() {
		return new ArrayIterator(this._array, 0, this._size);
	}
	
	public Iterator iterator(int startIndex, int length) {
		return new ArrayIterator(this._array, startIndex, length);
	}
}
