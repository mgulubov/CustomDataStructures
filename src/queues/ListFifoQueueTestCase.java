package queues;

import junit.framework.*;

public class ListFifoQueueTestCase extends AbstractFifoQueueTestCase {
	protected Queue createQueue() {
		return new ListFifoQueue();
	}
}
