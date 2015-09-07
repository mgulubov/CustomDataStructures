package bsearch;

import lists.List;
import lists.ArrayList;
import sorting.Comparator;
import sorting.NaturalComparator;
import junit.framework.*;

public abstract class AbstractListSearcherTestCase extends TestCase {
	private static final Object[] VALUES = {
		"B", "C", "D", "F", "H", "I", "J", "K", "L", "M", "P", "Q"
	};
	private List _list;
	private final Comparator _comparator = NaturalComparator.INSTANCE;
	private ListSearcher _searcher;
	
    protected abstract ListSearcher createListSearcher(Comparator comparator);
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this._list = new ArrayList(VALUES);
		this._searcher = createListSearcher(this._comparator);
	}
	
	protected void tearDown() throws Exception {
		this._list = null;
		this._searcher = null;
		
		super.tearDown();
	}
	
	public void testSearchExistingValues() {
		for (int i = 0; i < this._list.size(); i++) {
			int searchResult = this._searcher.search(this._list, this._list.get(i));
			assertEquals(i, searchResult);
		}
	}
	
	public void testSearchForNonExistingValueBeforeFirstElement() {
		assertEquals(-1, this._searcher.search(this._list, "A"));
	}
	
	public void testSearchForNonExistingValueAfterLastElement() {
		assertEquals(-13, this._searcher.search(this._list, "Z"));
	}
	
	public void testSearchForNonExistingValueInMiddleOfList() {
		assertEquals(-5, this._searcher.search(this._list, "G"));
	}
}
