package priorityqueue;

import queues.Queue;
import queues.EmptyQueueException;
import sorting.Comparator;
import lists.List;
import lists.ArrayList;

public class SortedListPriorityQueue implements Queue {
	private final List _list;
	private final Comparator _comparator;
	
	public SortedListPriorityQueue(Comparator comparator) {
		assert comparator != null : "comparator can't be null";
		this._comparator = comparator;
		this._list = new ArrayList();
	}
	
	public void enqueue(Object value) {
		assert value != null : "value can't be null";
		
		int index = findCorrectIndex(value);
		this._list.insert(index, value);
	}
	
	private int findCorrectIndex(Object value) {
			int index = size();
			
			if (index > 1) {
				for (int i = index - 1; i > 0; i--) {
					Object left = this._list.get(i);
					int check = this._comparator.compare(left, value);
					
					if (check < 0) {
						break;
					}
					
					index--;
				}
			}
			
			return index;
	}
	
	public Object dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		return this._list.delete(size() - 1);
	}
	
	public Object peek() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		return this._list.get(size() - 1);
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
