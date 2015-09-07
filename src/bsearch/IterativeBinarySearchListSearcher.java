package bsearch;

import lists.List;
import sorting.Comparator;

public class IterativeBinarySearchListSearcher implements ListSearcher {
	private final Comparator _comparator;
	
	public IterativeBinarySearchListSearcher(Comparator comparator) {
		assert comparator != null : "comparator can't be null";
		this._comparator = comparator;
	}
	
	public int search(List list, Object key) {
		assert list != null : "list can't be null";
		
		int startIndex = 0;
		int endIndex = list.size() - 1;
		
		while(startIndex <= endIndex) {
			int middleIndex = startIndex + (endIndex - startIndex) / 2;
			int check = this._comparator.compare(key, list.get(middleIndex));
			
			if (check == 0) {
				return middleIndex;
			} else {
				if (check < 0) {
					endIndex = middleIndex - 1;
					continue;
				} else {
					startIndex = middleIndex + 1;
					continue;
				}
			}
		}
		
		return -(startIndex + 1);
	}
}
