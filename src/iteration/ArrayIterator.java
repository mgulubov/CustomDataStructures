package iteration;

public class ArrayIterator implements Iterator {
	private final Object[] _array;
	private final int _start;
	private final int _end;
	private int _current;
	
	public ArrayIterator(Object[] array) {
		assert array != null : "array can't be null";
		
		this._array = array;
		this._start = 0;
		this._end = this._array.length - 1;
	}
	
	public ArrayIterator(Object[] array, int startIndex, int length) {
		assert array != null : "array can't be null";
		assert startIndex >= 0 : "startIndex can't be < 0";
		assert startIndex < array.length : "startIndex can't be >= array.length";
		assert length > 0 : "endIndex can't be <= 0";
		assert length < array.length : "length can't be > array.length";
		
		this._array = array;
		this._start = startIndex;
		this._end = (this._start + length) - 1;
	}
	
	public void first() {
		this._current = this._start;
	}
	
	public void next() {
		this._current++;
	}
	
	public void last() {
		this._current = this._end;
	}
	
	public void previous() {
		this._current--;
	}
	
	public Object current() throws IteratorOutOfBoundsException {
		if (isDone()) {
			throw new IteratorOutOfBoundsException();
		}
		return this._array[this._current];
	}
	
	public boolean isDone() {
		return this._current < this._start || this._current > this._end;
	}
}
