package sorting;

import lists.List;
import lists.ArrayList;

public class InsertionSortListSorter implements ListSorter {
	private final Comparator _comparator;
	
	public InsertionSortListSorter(Comparator comparator) {
		assert comparator != null : "comparator can't be null";
		this._comparator = comparator;
	}
	
	public List sort(List list) {
		assert list != null : "list can't be null";
		
		List result = new ArrayList(list.size());
		result.add(list.get(0));
		
		for (int leftIndex = 1; leftIndex < list.size(); leftIndex++) {
			Object leftObject = list.get(leftIndex);
			int rightIndex = result.size();
			
			while (rightIndex > 0) {
				Object rightObject = result.get(rightIndex - 1);
				int check = this._comparator.compare(leftObject, rightObject);
				
				if (check > 0) {
					break;
				}
				
				rightIndex--;
			}
			
			result.insert(rightIndex, leftObject);
		}
		
		return result;
	}	
}
