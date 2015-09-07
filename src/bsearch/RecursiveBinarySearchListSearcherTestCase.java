package bsearch;

import junit.framework.*;
import sorting.Comparator;
import lists.List;

public class RecursiveBinarySearchListSearcherTestCase extends AbstractListSearcherTestCase {
	protected ListSearcher createListSearcher(Comparator comparator) {
		return new RecursiveBinarySearchListSearcher(comparator);
	}
}
