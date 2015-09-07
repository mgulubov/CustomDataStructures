package bsearch;

import lists.List;
import sorting.Comparator;

public class LinearSearchListSearcher implements ListSearcher {
	private final Comparator _comparator;
	
	public LinearSearchListSearcher(Comparator comparator) {
		assert comparator != null : "comparator can't be null";
		this._comparator = comparator;
	}
	
	public int search(List list, Object key) {
		assert list != null : "list can't be null";
		
		int index = list.size();
		
		while (index > 0) {
			int check = this._comparator.compare(key, list.get(index - 1));
			
			if (check == 0) {
				return index - 1;
			} else {
				if (check > 0) {
					break;
				} else {
					index--;
				}
			}
		}
		
		return -(index + 1);
	}
}
