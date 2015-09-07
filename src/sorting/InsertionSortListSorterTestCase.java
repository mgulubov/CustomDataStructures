package sorting;

import junit.framework.*;
import lists.List;

public class InsertionSortListSorterTestCase extends AbstractListSorterTestCase {
	protected ListSorter createListSorter(Comparator comparator) {
		return new InsertionSortListSorter(comparator);
	}
}
