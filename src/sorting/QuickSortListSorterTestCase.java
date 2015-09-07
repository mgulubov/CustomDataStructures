package sorting;

import junit.framework.*;
import lists.List;

public class QuickSortListSorterTestCase extends AbstractListSorterTestCase {
	protected ListSorter createListSorter(Comparator comparator) {
		return new QuickSortListSorter(comparator);
	}
}
