package iteration;

public interface Iterator {
	/**
	 * Sets current() on the first element
	 */
	public void first();
	/**
	 * Sets current() on the last element
	 */
	public void last();
	/**
	 * Move current() to next element
	 */
	public void next();
	/**
	 * Move current() to previous element
	 */
	public void previous();
	/**
	 * Checks if current() points to an element
	 * @return -
	 * 		True - if current() does not point to an element
	 * 		False - if current() points to an element
	 */		
	public boolean isDone();
	/**
	 * Returns the currently select element
	 * @return
	 * 		Returns the Object value of the currently selected element
	 * @throws IteratorOutOfBoundsException if current() does not point to an element
	 */
	public Object current() throws IteratorOutOfBoundsException;
}
