package sorting;

import lists.List;
import lists.LinkedList;
import iteration.Iterator;

public class MergeSortListSorter implements ListSorter {
	private final Comparator _comaprator;
	
	public MergeSortListSorter(Comparator comparator) {
		assert comparator != null : "comaprator can't be null";
		this._comaprator = comparator;
	}
	
	public List sort(List list) {
		assert list != null : "list can't be null";
		
		return mergeSort(list, 0, list.size() - 1);
	}
	
	private List mergeSort(List list, int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			List result = new LinkedList();
			Object value = list.get(startIndex);
			result.add(value);
			return result;
		}
		
		int middle = startIndex + (endIndex - startIndex) / 2;
		
		List leftArray = mergeSort(list, startIndex, middle);
		List rightArray = mergeSort(list, middle + 1, endIndex);
		
		return merge(leftArray, rightArray);
	}
	
	private List merge(List leftArray, List rightArray) {
		List result = new LinkedList();
		
		Iterator left = leftArray.iterator();
		Iterator right = rightArray.iterator();
		
		left.first();
		right.first();
		
		while (!(left.isDone() && right.isDone())) {
			if (left.isDone()) {
				result.add(right.current());
				right.next();
			} else if (right.isDone()) {
				result.add(left.current());
				left.next();
			} else {
				int check = this._comaprator.compare(left.current(), right.current());
				
				if (check > 0) {
					result.add(right.current());
					right.next();
				} else if (check < 0) {
					result.add(left.current());
					left.next();
				} else {
					result.add(left.current());
					left.next();
				}
			}
		}
		
		return result;
	}
}
