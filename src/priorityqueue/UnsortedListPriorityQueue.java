package priorityqueue;

import lists.List;
import lists.ArrayList;
import queues.Queue;
import queues.EmptyQueueException;
import sorting.Comparator;

public class UnsortedListPriorityQueue implements Queue {
	private final List _list;
	private final Comparator _comparator;
	
	public UnsortedListPriorityQueue(Comparator comparator) {
		assert comparator != null : "comparator can't be null";
		this._comparator = comparator;
		this._list = new ArrayList();
	}
	
	public void enqueue(Object value) {
		this._list.add(value);
	}
	
	public Object dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		int index = findIndex();
		return this._list.delete(index);
	}
	
	private int findIndex() {
		int index = 0;
		
		if (size() > 1) {
			
			for (int i = index + 1; i < this._list.size(); i++) {
				Object left = this._list.get(index);
				Object right = this._list.get(i);
				int check = this._comparator.compare(left, right);
				
				if (check < 0) {
					index = i;
				}
			}
		}
		
		return index;
	}
	
	public Object peek() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		int index = findIndex();
		return this._list.get(index);
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
