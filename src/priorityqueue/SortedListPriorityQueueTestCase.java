package priorityqueue;

import junit.framework.*;
import queues.Queue;
import sorting.Comparator;

public class SortedListPriorityQueueTestCase extends AbstractPriorityQueueTestCase {
	protected Queue createPriorityQueue(Comparator comparator) {
		return new SortedListPriorityQueue(comparator);
	}
}
