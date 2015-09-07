package sorting;

public class NaturalComparator implements Comparator {
	public static final NaturalComparator INSTANCE = new NaturalComparator();
	
	private NaturalComparator() {
		//private constructor
	}
	
	public int compare(Object left, Object right) {
		assert left != null : "left can't be null";
		return ((Comparable)left).compareTo(right);
	}
}
