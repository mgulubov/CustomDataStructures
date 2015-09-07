package sorting;

import junit.framework.*;
import lists.List;
import lists.LinkedList;
import iteration.Iterator;

public abstract class AbstractListSorterTestCase extends TestCase {
	private List _sortedList;
	private List _unsortedList;
	
	protected abstract ListSorter createListSorter(Comparator comparator);
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this._unsortedList = new LinkedList();
		
		this._unsortedList.add("test");
		this._unsortedList.add("driven");
		this._unsortedList.add("development");
		this._unsortedList.add("is");
		this._unsortedList.add("one");
		this._unsortedList.add("small");
		this._unsortedList.add("step");
		this._unsortedList.add("for");
		this._unsortedList.add("a");
		this._unsortedList.add("programmer");
		this._unsortedList.add("but");
		this._unsortedList.add("it's");
		this._unsortedList.add("one");
		this._unsortedList.add("giant");
		this._unsortedList.add("leap");
		this._unsortedList.add("for");
		this._unsortedList.add("programming");
		
		this._sortedList = new LinkedList();
		
		this._sortedList.add("a");
		this._sortedList.add("but");
		this._sortedList.add("development");
		this._sortedList.add("driven");
		this._sortedList.add("for");
		this._sortedList.add("for");
		this._sortedList.add("giant");
		this._sortedList.add("is");
		this._sortedList.add("it's");
		this._sortedList.add("leap");
		this._sortedList.add("one");
		this._sortedList.add("one");
		this._sortedList.add("programmer");
		this._sortedList.add("programming");
		this._sortedList.add("small");
		this._sortedList.add("step");
		this._sortedList.add("test");
	}
	
	protected void tearDown() throws Exception {
		this._sortedList = null;
		this._unsortedList = null;
		
		super.tearDown();
	}
	
	public void testSort() {
		ListSorter sorter = createListSorter(NaturalComparator.INSTANCE);
		List result = sorter.sort(this._unsortedList);
		
		assertEquals(this._sortedList.size(), result.size());
		
		Iterator expected = this._sortedList.iterator();
		Iterator actual = result.iterator();
		
		expected.first();
		actual.first();
		
		while(!expected.isDone()) {
			assertSame(expected.current(), actual.current());
			expected.next();
			actual.next();
		}
	}
}