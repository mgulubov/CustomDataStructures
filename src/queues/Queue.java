package queues;

public interface Queue {
	/**
	 * Ads an Object to the queue
	 * @param value
	 */
	public void enqueue(Object value);
	
	/**
	 * Deletes an Object from the queue
	 * @return - returns the deleted Object
	 */
	public Object dequeue() throws EmptyQueueException;
	
	/**
	 * Checks the next in-line Object
	 * @return - returns the Object of the next value that's to be deleted
	 */
	public Object peek() throws EmptyQueueException;
	
	/**
	 * 
	 * @return - returns the number of elements in the queue. 0 if empty
	 */
	public int size();
	
	/**
	 * Checks it there are any Objects in the queue
	 * @return - True if the queue is empty. False if there are objects in the queue
	 */
	public boolean isEmpty();
	
	/**
	 * Deletes all objects in the queue
	 */
	public void clear();
}
