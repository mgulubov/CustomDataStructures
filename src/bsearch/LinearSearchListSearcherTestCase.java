package bsearch;

import junit.framework.*;
import lists.List;
import sorting.Comparator;

public class LinearSearchListSearcherTestCase extends AbstractListSearcherTestCase {
	protected ListSearcher createListSearcher(Comparator comparator) {
		return new LinearSearchListSearcher(comparator);
	}
}
