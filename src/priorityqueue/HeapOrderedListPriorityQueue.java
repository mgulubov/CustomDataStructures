package priorityqueue;

import queues.Queue;
import queues.EmptyQueueException;
import lists.List;
import lists.ArrayList;
import sorting.Comparator;

public class HeapOrderedListPriorityQueue implements Queue {
	private final Comparator _comparator;
	private final List _list;
	
	public HeapOrderedListPriorityQueue(Comparator comparator) {
		assert comparator != null : "comparator can't be null";
		this._comparator = comparator;
		this._list = new ArrayList();
	}
	
	public void enqueue(Object value) {
		this._list.add(value);
		if (size() > 1) {
			swim(size() - 1);
		}
	}
	
	private void swim(int index) {
		int parent = (index - 1) / 2;
		
		if (parent < 0) {
			return;
		} else {
			if (this._comparator.compare(this._list.get(parent), this._list.get(index)) < 0) {
				swap(parent, index);
				swim(parent);
			}
		}
	}
	
	private void swap(int left, int right) {
		Object tmp = this._list.get(left);
		this._list.set(left, this._list.get(right));
		this._list.set(right, tmp);
	}
	
	public Object dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		Object returnValue = this._list.get(0);
		
		if (size() > 1) {
			this._list.set(0, this._list.get(size() - 1));
			sink(0);
		}
		
		this._list.delete(size() - 1);
		return returnValue;
	}
	
	private void sink(int index) {
		int leftChild = (index * 2) + 1;
		int rightChild = (index * 2) + 2;
		
		if (leftChild > size() - 1) {
			return;
		}
		
		int biggestChild = leftChild;
		if (rightChild < size()) {
			if (this._comparator.compare(this._list.get(leftChild), this._list.get(rightChild)) < 0) {
				biggestChild = rightChild;
			}
		}
		
		if (this._comparator.compare(this._list.get(index), this._list.get(biggestChild)) < 0) {
			swap(index, biggestChild);
			sink(biggestChild);
		}
	}
	
	public Object peek() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		return this._list.get(0);
	}
	
	public int size() {
		return this._list.size();
	}
	
	public boolean isEmpty() {
		return this._list.isEmpty();
	}
	
	public void clear() {
		this._list.clear();
	}
}
