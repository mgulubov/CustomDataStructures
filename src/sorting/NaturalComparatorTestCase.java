package sorting;

import junit.framework.*;

public class NaturalComparatorTestCase extends TestCase {
	private static final String VALUE_A = "A";
	private static final String VALUE_B = "B";
	private Comparator _comparator;
	
	public void testLeftLargerThanRight() {
		this._comparator = NaturalComparator.INSTANCE;
		assertEquals(1, this._comparator.compare(VALUE_B, VALUE_A));
	}
	
	public void testRightLargerThanLeft() {
		this._comparator = NaturalComparator.INSTANCE;
		assertEquals(-1, this._comparator.compare(VALUE_A, VALUE_B));
	}
	
	public void testLeftEquelsRight() {
		this._comparator = NaturalComparator.INSTANCE;
		assertEquals(0, this._comparator.compare(VALUE_A, VALUE_A));
	}
	
	public void testReverseComparatorLeftLargerThanRight() {
		this._comparator = new ReverseComparator(NaturalComparator.INSTANCE);
		assertEquals(-1, this._comparator.compare(VALUE_B, VALUE_A));
	}
	
	public void testReverseComparatorRightLargerThanLeft() {
		this._comparator = new ReverseComparator(NaturalComparator.INSTANCE);
		assertEquals(1, this._comparator.compare(VALUE_A, VALUE_B));
	}
	
	public void testReverseComparatorLeftEqualsRight() {
		this._comparator = new ReverseComparator(NaturalComparator.INSTANCE);
		assertEquals(0, this._comparator.compare(VALUE_A, VALUE_A));
	}
}
