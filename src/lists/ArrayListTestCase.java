package lists;

import junit.framework.*;

public class ArrayListTestCase extends AbstractListTestCase {
	protected List createList() {
		return new ArrayList();
	}
	protected List createList(Object[] array) {
		return new ArrayList(array);
	}
	
	public void testGrowBeyonInitialCapacity() {
		List list = new ArrayList(1);
		
		for (int i = 0; i < 1000; i++) {
			list.add(new Integer(i));
		}
	}
}
