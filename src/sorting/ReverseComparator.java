package sorting;

public class ReverseComparator implements Comparator {
	private final Comparator _comparator;
	
	public ReverseComparator(Comparator comparator) {
		assert comparator != null : "comparator can't be null";
		this._comparator = comparator;
	}
	
	public int compare(Object left, Object right) {
		return this._comparator.compare(right, left);
	}
}
