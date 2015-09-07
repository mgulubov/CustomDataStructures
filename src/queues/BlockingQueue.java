package queues;

public class BlockingQueue implements Queue {
	private final int _maxCapacity;
	private final Queue _queue;
	private final Object _mutex;
	
	public BlockingQueue(int maxCapacity, Queue queue) {
		assert maxCapacity > 0 : "maxCapacity can't be <= 0";
		assert queue != null : "queue can't be null";
		this._maxCapacity = maxCapacity;
		this._queue = queue;
		this._mutex = new Object();
	}
	
	public void enqueue(Object value) {
		assert value != null : "value can't be null";
		
		synchronized (this._mutex) {
			while (size() >= this._maxCapacity) {
				waitForNotification(this._mutex);
			}
			this._queue.enqueue(value);
			this._mutex.notifyAll();
		}
	}
	
	private void waitForNotification(Object mutex) {
		try {
			this._mutex.wait();
		} catch (InterruptedException ie) {
			//ignore
		}
	}
	
	public Object dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		synchronized (this._mutex) {
			Object value = this._queue.dequeue();
			this._mutex.notifyAll();
			return value;
		}
	}
	
	public Object peek() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		synchronized (this._mutex) {
			return this._queue.peek();
		}
	}
	
	public int size() {
		synchronized (this._mutex) {
			return this._queue.size();
		}
	}
	
	public boolean isEmpty() {
		synchronized (this._mutex) {
			return this._queue.isEmpty();
		}
	}
	
	public void clear() {
		synchronized (this._mutex) {
			this._queue.clear();
		}
	}
}
