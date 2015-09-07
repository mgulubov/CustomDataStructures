package decks;

import stacks.Stack;
import stacks.EmptyStackException;

public interface Deck extends Stack {
	
	public void addInBack(Object value);
	public int backSize();
	public Object peekInBack() throws EmptyStackException;
	public boolean backIsEmpty();
	public Object deleteFromBack() throws EmptyStackException;
		
	public void addInFront(Object value);
	public int frontSize();
	public Object peekInFront() throws EmptyStackException;
	public boolean frontIsEmpty();
	public Object deleteFromFront() throws EmptyStackException;
	
	public Object deleteLastEntry() throws EmptyStackException;
	public Object peekLastEntry() throws EmptyStackException;
	
}
