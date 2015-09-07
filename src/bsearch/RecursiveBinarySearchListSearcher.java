package bsearch;

import lists.List;
import sorting.Comparator;

public class RecursiveBinarySearchListSearcher implements ListSearcher {
	private final Comparator _comparator;
	
	public RecursiveBinarySearchListSearcher(Comparator comparator) {
		assert comparator != null : "comparator can't be null";
		this._comparator = comparator;
	}
	
	public int search(List list, Object key) {
		assert list != null : "list can't be null";
		
		return searchRecursively(list, key, 0, list.size() - 1);
	}
	
	private int searchRecursively(List list, Object key, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return -(startIndex + 1);
		}
		
		int middleIndex = startIndex + (endIndex - startIndex) / 2;
		int check = this._comparator.compare(key, list.get(middleIndex));
		
		if (check > 0) {
			middleIndex = searchRecursively(list, key, middleIndex + 1, endIndex);
		} else if (check < 0) {
			middleIndex = searchRecursively(list, key, startIndex, middleIndex - 1);
		}
		
		return middleIndex;
	}
}
