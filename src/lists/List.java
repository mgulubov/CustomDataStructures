package lists;

import iteration.Iterator;

public interface List {
	/**
	 * Inserts an Object in the desired location
	 * @param index - 
	 * 		index at which the Object is to be inserted
	 * @param value -
	 * 		the value of the Object
	 * @throws IndexOutOfBoundsException
	 */
	public void insert(int index, Object value) throws IndexOutOfBoundsException;
	/**
	 * Adds an Object at the end of the List. Equivalent to insert(size() - 1, value);
	 * @param value -
	 * 		the value of the Object
	 */
	public void add(Object value);
	/**
	 * Clears the list
	 */
	public void clear();
	/**
	 * Sets an Object at the desired location. 
	 * 		If there is another Object at that location, it is replaced by 'value'
	 * @param index -
	 * 		the index where the Object is to be set
	 * @param value -
	 * 		the value of the Object that is to be set
	 * @return -
	 * 		returns the value of the previous Object at the specified index
	 * @throws IndexOutOfBoundsException
	 */
	public Object set(int index, Object value) throws IndexOutOfBoundsException;
	/**
	 * Get the value of the Object at the specified index
	 * @param index -
	 * 		the index whose value is to be returned
	 * @return - 
	 * 		returns the Object value at the specified index
	 * @throws IndexOutOfBoundsException
	 */
	public Object get(int index) throws IndexOutOfBoundsException;
	/**
	 * Deletes the Object at the specified location
	 * @param index -
	 * 		the index of the Object that is to be deleted
	 * @return -
	 * 		returns the value of the deleted Object
	 * @throws IndexOutOfBoundsException
	 */
	public Object delete(int index) throws IndexOutOfBoundsException;
	/**
	 * Deletes the first Object with the specified value
	 * @param value -
	 * 		the value that is to be deleted
	 * @return - 
	 * 		returns True if an Object was deleted and 
	 * 		False if no object with that value was found
	 */
	public boolean delete(Object value);
	/**
	 * Get the index of the first Object with that value
	 * @param value -
	 * 		the value of the Object whose index is to be returned
	 * @return -
	 * 		returns the index of the first Object with the specified value
	 * 		returns -1 if no Object with that value was found
	 */
	public int indexOf(Object value);
	/**
	 * Get the number of objects in the list
	 * @return - 
	 * 		returns the number of Objects in the list.
	 * 		returns 1 if there is 1 Object
	 * 		returns 0 if there are no Objects
	 */
	public int size();
	/**
	 * Check if there is at least one Object with the specified value
	 * @param value -
	 * 		the value of the Object that we are searching for
	 * @return - 
	 * 		True if at least one Object with that value was found
	 * 		False if no Objects with that value were found
	 */
	public boolean contains(Object value);
	/**
	 * Check if the list is empty
	 * @return - 
	 * 		True if the list is empty // size = 0;
	 * 		False if there is at least one element // size => 1;
	 */
	public boolean isEmpty();
	/**
	 * Create an ArrayIterator from the current list
	 * @return
	 * 		returns an Iterator from the current list
	 */
	public Iterator iterator();
	/**
	 * Create an ArrayIterator from the list with specific parameters
	 * @param 
	 * 		startIndex - the starting object
	 * @param 
	 * 		length - the TOTAL number of objects, exp. - iterator(2, 3) will return 3 elements
	 * @return
	 * 		returns an iterator with specific boundaries
	 */
	public Iterator iterator(int startIndex, int length);
}
