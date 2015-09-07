package hashing;

public class LinearProbingHashtable implements Hashtable{
	private Object[] _values;
	
	public LinearProbingHashtable(int size) {
		assert size > 0 : "size can't be <= 0";
		this._values = new Object[size];
	}
	
	private void ensureCapacityForOneMore() {
		if (size() == this._values.length) {
			resize();
		}
	}
	
	private void resize() {
		LinearProbingHashtable tmp = new LinearProbingHashtable(this._values.length * 2);
		
		for (int i = 0; i < this._values.length; i++) {
			if (this._values[i] != null) {
				tmp.add(this._values[i]);
			}
		}
		
		this._values = tmp._values;
	}
	
	private int startingIndexFor(Object value) {
		assert value != null : "value can't be null";
		
		return Math.abs(value.hashCode() % this._values.length);
	}
	
	private int indexFor(Object value) {
		int start = startingIndexFor(value);
		
		int index = indexFor(value, start, this._values.length);
		if (index == -1) {
			index = indexFor(value, 0, start);
			assert index == -1 : "no free slots";
		}
		
		return index;
	}
	
	private int indexFor(Object value, int start, int end) {
		for (int i = start; i < end; i++) {
			if (this._values[i] == null || this._values[i].equals(value)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void add(Object value) {
		ensureCapacityForOneMore();
		this._values[indexFor(value)] = value;
	}
	
	private int indexOf(Object value) {
		int start = startingIndexFor(value);
		
		int index = indexOf(value, start, this._values.length);
		if (index == -1) {
			index = indexOf(value, 0, start);
		}
		
		return index;
	}
	
	private int indexOf(Object value, int start, int end) {
		assert value != null : "value cna't be null";
		
		for (int i = start; i < end; i++) {
			if (this._values[i].equals(value)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean contains(Object value) {
		return indexOf(value) != -1;
	}
	
	public int size() {
		int size = 0;
		
		for (int i = 0; i < this._values.length; i++) {
			if (this._values[i] != null) {
				size++;
			}
		}
		
		return size;
	}
}
