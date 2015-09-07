package queues;

import lists.List;
import lists.LinkedList;

public class ListFifoQueue implements Queue {
	private final List _list;
	
	public ListFifoQueue() {
		this._list = new LinkedList();
	}
	
	public void enqueue(Object value) {
		this._list.insert(0, value);
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
