package lists;

import iteration.Iterator;
import iteration.IteratorOutOfBoundsException;

public class LinkedList implements List {
	private final Element _headAndTail = new Element(null);
	private int _size;
	
	public LinkedList() {
		clear();
	}
	
	public LinkedList(Object[] array) {
		assert array != null : "array can't be null";
		
		clear();
		
		for (int i = 0; i < array.length; i++) {
			insert(i, array[i]);
		}
	}
	
	private final class Element {
		private Object _value;
		private Element _next;
		private Element _previous;
		
		private Element(Object value) {
			setValue(value);
		}
		
		private void setValue(Object value) {
			this._value = value;
		}
		
		private Object getValue() {
			return this._value;
		}
		
		private void setPrevious(Element previous) {
			this._previous = previous;
		}
		
		private Element getPrevious() {
			return this._previous;
		}
		
		private void setNext(Element next) {
			this._next = next;
		}
		
		private Element getNext() {
			return this._next;
		}
		
		private void insertBefore(Element next) {
			Element previous = next.getPrevious();
			
			previous.setNext(this);
			next.setPrevious(this);
			
			this.setPrevious(previous);
			this.setNext(next);
		}
		
		private void detach() {
			Element next = this.getNext();
			Element previous = this.getPrevious();
			
			next.setPrevious(previous);
			previous.setNext(next);
			
			this.setNext(_headAndTail);
			this.setPrevious(_headAndTail);
			this.setValue(null);
		}
	}
	
	public void insert(int index, Object value) throws IndexOutOfBoundsException {
		assert value != null : "value can't be null";
		
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Element element = new Element(value);
		Element next = getElement(index);
		
		element.insertBefore(next);
		this._size++;
	}
	
	public void add(Object value) {
		insert(size(), value);
	}
	
	private Element getElement(int index) {
		int middleIndex =  size() / 2;
		
		if (index < middleIndex) {
			return searchFromStart(index);
		} else {
			return searchFromEnd(index);
		}
	}
	
	private Element searchFromStart(int index) {
		Element element = this._headAndTail;
		
		for (int i = index; i >= 0; i--) {
			element = element.getNext();
		}
		
		return element;
	}
	
	private Element searchFromEnd(int index) {
		Element element = this._headAndTail;
		
		for (int i = size() - index; i > 0; i--) {
			element = element.getPrevious();
		}
		
		return element;
	}
	
	public Object delete(int index) throws IndexOutOfBoundsException {
		checkIfOutOfBounds(index);
		
		Element deletedElement = getElement(index);
		Object deletedValue = deletedElement.getValue();
		
		deletedElement.detach();
		this._size--;
		
		return deletedValue;
	}
	
	public boolean delete(Object value) {
		assert value != null : "value can't be null";
		int index = indexOf(value);
		
		if (index == -1) {
			return false;
		}
		
		delete(index);
		return true;
	}
	
	private void checkIfOutOfBounds(int index) {
		if (isOutOfBounds(index)) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private boolean isOutOfBounds(int index) {
		return index < 0 || index >= size();
	}
	
	public Object set(int index, Object value) throws IndexOutOfBoundsException {
		assert value != null : "value can't be null";
		checkIfOutOfBounds(index);
		
		Element element = getElement(index);
		Object oldValue = element.getValue();
		
		element.setValue(value);
		
		return oldValue;
	}
	
	public Object get(int index) throws IndexOutOfBoundsException {
		checkIfOutOfBounds(index);
		
		Element element = getElement(index);
		
		return element.getValue();
	}
	
	public int indexOf(Object value) {
		assert value != null : "value cna't be null";
		
		Element element = this._headAndTail.getNext();
		int index = -1;
		
		for (int i = 0; i < size(); i++) {
			if (element.getValue().equals(value)) {
				index = i;
				break;
			}
			element = element.getNext();
		}
		
		return index;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return this._size;
	}
	
	public void clear() {
		this._size = 0;
		this._headAndTail.setNext(_headAndTail);
		this._headAndTail.setPrevious(_headAndTail);
	}
	
	public boolean contains(Object value) {
		assert value != null : "value can't be null";
		int index = indexOf(value);
		
		if (index == -1) {
			return false;
		}
		
		return true;
	}
	
	public Iterator iterator() {
		return new LinkedListIterator();
	}
	
	public Iterator iterator(int startIndex, int length) {
		return new LinkedListIterator(startIndex, length);
	}
	
	private final class LinkedListIterator implements Iterator {
		private Element _currentElement;
		private final Element _firstElement;
		private Element _lastElement;
		private final int _startIndex;
		private final int _endIndex;
		private int _currentIndex;
		
		public LinkedListIterator() {
			this._firstElement = _headAndTail;
			this._lastElement = _headAndTail;
			this._startIndex = 0;
			this._endIndex = (size() - this._startIndex) - 1;
		}
		
		public LinkedListIterator(int startIndex, int length) {
			this._firstElement = getElement(startIndex - 1);
			this._startIndex = startIndex;
			this._endIndex = (startIndex + length) - 1;
			this._lastElement = getElement(this._endIndex + 1);
		}
		
		public void first() {
			this._currentElement = this._firstElement.getNext();
			this._currentIndex = this._startIndex;
		}
		
		public void next() {
			this._currentElement = this._currentElement.getNext();
			this._currentIndex++;
		}
		
		public void last() {
			this._currentElement = this._lastElement.getPrevious();
			this._currentIndex = this._endIndex;
		}
		
		public void previous() {
			this._currentElement = this._currentElement.getPrevious();
			this._currentIndex--;
		}
		
		public Object current() throws IteratorOutOfBoundsException {
			if (isDone()) {
				throw new IteratorOutOfBoundsException();
			}
			
			return this._currentElement.getValue();
		}
		
		public boolean isDone() {
			return this._currentIndex < this._startIndex
					|| this._currentIndex > this._endIndex
					|| this._currentElement == null;
		}
	}
}
