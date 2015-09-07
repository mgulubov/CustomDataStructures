package bsearch;

import junit.framework.*;
import lists.List;
import sorting.Comparator;

public class IterativeBinarySearchListSearcherTestCase extends AbstractListSearcherTestCase {
	protected ListSearcher createListSearcher(Comparator comparator) {
		return new IterativeBinarySearchListSearcher(comparator);
	}
}
