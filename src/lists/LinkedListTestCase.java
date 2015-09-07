package lists;

import junit.framework.*;

public class LinkedListTestCase extends AbstractListTestCase {
	protected List createList() {
		return new LinkedList();
	}
	
	protected List createList(Object[] array) {
		return new LinkedList(array);
	}
}
