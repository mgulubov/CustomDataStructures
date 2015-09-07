package priorityqueue;

import junit.framework.*;
import queues.Queue;
import sorting.Comparator;

public class HeapOrderdListPriorityQueueTestCase extends AbstractPriorityQueueTestCase {
	protected Queue createPriorityQueue(Comparator comparator) {
		return new HeapOrderedListPriorityQueue(comparator);
	}
}
