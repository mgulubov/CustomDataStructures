package sorting;

import junit.framework.*;

public class MergeSortListSorterTestCase extends AbstractListSorterTestCase {
	protected ListSorter createListSorter(Comparator comparator) {
		return new MergeSortListSorter(comparator);
	}
}
