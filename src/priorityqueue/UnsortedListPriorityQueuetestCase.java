package priorityqueue;

import junit.framework.*;
import sorting.Comparator;
import queues.Queue;

public class UnsortedListPriorityQueuetestCase extends AbstractPriorityQueueTestCase {
	protected Queue createPriorityQueue(Comparator comparator) {
		return new UnsortedListPriorityQueue(comparator);
	}
}
