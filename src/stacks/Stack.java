package stacks;

import queues.Queue;

public interface Stack extends Queue {
	/**
	 * Inserts an Object in the Stack
	 * @param value
	 */
	public void push(Object value);
	
	/**
	 * Deletes an Object from the Stack
	 * @return - returns the Object that's deleted
	 * @throws EmptyStackExeption
	 */
	public Object pop() throws EmptyStackException;
	
	/**
	 * returns the Object that\s to be deleted next
	 */
	public Object peek() throws EmptyStackException;
	
	public int size();
	public boolean isEmpty();
	public void clear();
	
	public Object[] toArray();
}
