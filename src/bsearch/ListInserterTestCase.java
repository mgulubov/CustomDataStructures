package bsearch;

import junit.framework.*;
import lists.List;
import lists.ArrayList;
import sorting.Comparator;
import sorting.NaturalComparator;
import iteration.Iterator;

public class ListInserterTestCase extends TestCase {
	private static int INITIAL_SIZE = 1024;
	private List _list;
	private Comparator _comparator;
	private ListSearcher _searcher;
	private ListInserter _inserter;
	
	protected ListInserter createListInserter(ListSearcher searcher) {
		return new ListInserter(searcher);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this._comparator = NaturalComparator.INSTANCE;
		this._searcher = new IterativeBinarySearchListSearcher(this._comparator);
		this._list = new ArrayList(INITIAL_SIZE);
		this._inserter = createListInserter(this._searcher);
	}
	
	protected void tearDown() throws Exception {
		this._comparator = null;
		this._searcher = null;
		this._list = null;
		this._inserter = null;
		
		super.tearDown();
	}
	
	private void verify() {
		int previousValue = Integer.MIN_VALUE;
		Iterator iterator = this._list.iterator();
		
		for (iterator.first(); !iterator.isDone(); iterator.next()) {
			int currentValue = (int)iterator.current();
			assertTrue(currentValue >= previousValue);
			previousValue = currentValue;
		}
	}
	
	public void testInsertInOrderForward() {
		for (int i = 0; i < INITIAL_SIZE; i++) {
			assertEquals(i, this._inserter.insert(this._list, new Integer(i)));
		}
	}
	
	public void testInsertInOrderReverse() {
		for (int i = INITIAL_SIZE; i > 0; i--) {
			assertEquals(0, this._inserter.insert(this._list, new Integer(i)));
		}
		
		verify();
	}
	
	public void testInsertRandomValues() {
		for (int i = 0; i < INITIAL_SIZE; i++) {
			this._inserter.insert(this._list, new Integer((int) (INITIAL_SIZE * Math.random())));
		}
		
		verify();
	}
}
