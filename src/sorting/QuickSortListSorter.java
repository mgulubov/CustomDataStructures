package sorting;

import lists.List;

public class QuickSortListSorter implements ListSorter {
	private final Comparator _comparator;
	
	public QuickSortListSorter(Comparator comparator) {
		assert comparator != null : "comparator can't be null";
		this._comparator = comparator;
	}
	
	public List sort(List list) {
		assert list != null : "list cam't be null";
		
		qSort(list, 0, list.size() - 1);
		
		return list;
	}
	
	private void qSort(List list, int startIndex, int endIndex) {
		if (startIndex >= endIndex || startIndex < 0) {
			return;
		}
		if (endIndex > list.size()) {
			return;
		}
		
		Object key = list.get(endIndex);
		int pivotIndex = getPivotIndex(list, key, startIndex, endIndex - 1);
		
		if (this._comparator.compare(list.get(pivotIndex), key) < 0) {
			pivotIndex++;
		}
		swap(list, pivotIndex, endIndex);
		
		qSort(list, 0, pivotIndex - 1);
		qSort(list, pivotIndex + 1, endIndex);
	}
	
	private int getPivotIndex(List list, Object key, int leftIndex, int rightIndex) {
		if (leftIndex == rightIndex) {
			return leftIndex;
		}
		
		while (leftIndex < rightIndex) {
			if (this._comparator.compare(key, list.get(leftIndex)) > 0) {
				leftIndex++;
			} else if (this._comparator.compare(key, list.get(rightIndex)) < 0) {
				rightIndex--;
			}
			swap(list, leftIndex, rightIndex);
		}
		
		return leftIndex;
	}
	
	private void swap(List list, int left, int right) {
		Object tmp = list.get(left);
		list.set(left, list.get(right));
		list.set(right, tmp);
	}
}