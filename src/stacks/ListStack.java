package stacks;

import lists.List;
import lists.LinkedList;
import queues.EmptyQueueException;
import iteration.Iterator;

public class ListStack implements Stack{
	private final List _list;
	
	public ListStack() {
		this._list = new LinkedList();
	}
	
	public void push(Object value) {
		this._list.add(value);
	}
	
	public void enqueue(Object value) {
		push(value);
	}
	
	public Object pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return this._list.delete(size() - 1);
	}
	
	public Object dequeue() throws EmptyQueueException {
		try {
			return pop();
		} catch (EmptyStackException ese) {
			throw new EmptyQueueException();
		}
	}
	
	public Object peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
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
	
	public Object[] toArray() {
		Object[] result = new Object[this._list.size()];
		Iterator iterator = this._list.iterator();
		int i = 0;
		for (iterator.first(); !iterator.isDone(); iterator.next()) {
			assert iterator.current() != null : "iterator.current() can't be null";
			result[i] = iterator.current();
			i++;
		}
		
		return result;
	}
}
