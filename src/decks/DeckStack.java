package decks;

import stacks.EmptyStackException;
import stacks.Stack;
import stacks.ListStack;

public class DeckStack implements Deck{
	private Stack _frontStack;
	private Stack _backStack;
	private char _lastStack;
	
	public DeckStack() {
		this._frontStack = new ListStack();
		this._backStack = new ListStack();
	}
	
	public void addInBack(Object value) {
		this._backStack.push(value);
		this._lastStack = 0;
	}
	
	public Object deleteFromBack() throws EmptyStackException {
		if (this._backStack.isEmpty()) {
			throw new EmptyStackException();
		}
		return this._backStack.pop();
	}
	
	public Object peekInBack() throws EmptyStackException {
		if (this._backStack.isEmpty()) {
			throw new EmptyStackException();
		}
		return this._backStack.peek();
	}
	
	public int backSize() {
		return this._backStack.size();
	}
	
	public boolean backIsEmpty() {
		return this._backStack.isEmpty();
	}
	
	public void addInFront(Object value) {
		this._frontStack.push(value);
		this._lastStack = 1;
	}
	
	public Object deleteFromFront() throws EmptyStackException {
		if (this._frontStack.isEmpty()) {
			throw new EmptyStackException();
		}
		return this._frontStack.pop();
	}
	
	public Object peekInFront() throws EmptyStackException {
		if (this._frontStack.isEmpty()) {
			throw new EmptyStackException();
		}
		return this._frontStack.peek();
	}
	
	public int frontSize() {
		return this._frontStack.size();
	}
	
	public boolean frontIsEmpty() {
		return this._frontStack.isEmpty();
	}
	
	public Object deleteLastEntry() throws EmptyStackException {
		if (this._frontStack.isEmpty() && this._backStack.isEmpty()) {
			throw new EmptyStackException();
		}
		
		if (this._lastStack == 0) {
			return deleteFromBack();
		} else {
			return deleteFromFront();
		}
	}
	
	public Object peekLastEntry() throws EmptyStackException {
		if (this._frontStack.isEmpty() && this._backStack.isEmpty()) {
			throw new EmptyStackException();
		}
		
		if (this._lastStack == 0) {
			return peekInBack();
		} else {
			return peekInFront();
		}
	}
	
	public void push(Object value) {
		addInFront(value);
	}
	
	public Object pop() throws EmptyStackException {
		return deleteLastEntry();
	}
	
	public Object peek() throws EmptyStackException {
		return peekLastEntry();
	}
	
	public int size() {
		return frontSize() + backSize();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void enqueue(Object value) {
		push(value);
	}
	
	public Object dequeue() throws EmptyStackException {
		return pop();
	}
	
	public Object[] toArray() {
		Object[] backArray = this._backStack.toArray();
		Object[] frontArray = this._frontStack.toArray();
		Object[] result = new Object[backSize() + frontSize()];
		
		for (int i = 0; i < result.length; i++) {
			if (i < backSize()) {
				result[i] = backArray[i];
				continue;
			}
			
			int m = 0;
			result[i] = frontArray[m];
			m++;
		}
		return result;
	}
	
	public void clear() {
		this._backStack = new ListStack();
		this._frontStack = new ListStack();
		this._lastStack = 3;
	}
}