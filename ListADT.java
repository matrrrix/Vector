
import java.util.Iterator; 				// Needed for iterators

/**	Vectors are same as dynamic arrays with the ability to resize itself 
 * automatically when an element is inserted or deleted, with their storage 
 * being handled automatically by the container. 
 * 
 * Vector elements are placed in contiguous storage (an array) so that they
 * can be accessed and traversed using iterators. 
 * 
 * In vectors, data is inserted at the end. Inserting at the end takes 
 * differential time, as sometimes there may be a need of extending the 
 * array. Removing the last element takes only constant time because no 
 * resizing happens. Inserting and erasing at the beginning or in the 
 * middle is linear in time.
 * 
 * @author CS160 Spring 2022
 * @param <E> element type to store in list
 */
public interface ListADT<E> {
	
	/**
	 * Original size of internal array if none other is specified
	 */
	final int DEFAULT_CAPACITY = 10;

	/**
	 * @return the number of elements in the vector.
	 */
	public int size();
	
	/**
	 * @return the size of the storage space currently allocated to the
	 * vector expressed as number of elements.
	 */	
	public int capacity();

	/**
	 * @return – Returns whether the container is empty.
	 */	
	public boolean isEmpty();
	
	// ---------Element access-------------
	
	/**
	 * @return a reference to the first element in the vector
	 */	
	public E front();
	
	/**
	 * @return a reference to the last element in the vector
	 */	
	public E back();
	
	/**
	 * @return a reference to the memory array used internally by the
	 * vector to store its owned elements.
	 */
	public E[] data();
	
	// ---------- Modifiers --------------
	
	/**
	 * Push (add) the element into a vector from the back
	 * @param element - item to insert at the back of the vector
	 */
	public void pushback(E element);
	
	/**
	 * @return pop or remove an element from a vector from the back.
	 */
	public E popback();
	
	/**
	 * insert() – inserts a new element before the element at the specified
	 * position
	 * @param insertPosition - index at which to insert
	 * @param element to insert
	 */
	public void insert(int insertPosition, E element);
	
	/**
	 * It is used to remove elements from a container from the 
	 * specified position.
	 * @param position - index of element to remove
	 */
	public void erase(int position);
	
	/**
	 * It is used to remove elements from a container from the 
	 * startRangePosition (inclusive) to endRangePosition (exclusive).
	 * @param startRangePosition first index to remove
	 * @param endRangePosition stop at this index (but don't erase it)
	 */
	public void erase(int startRangePosition, int endRangePosition);
	
	/**
	 * It is used to swap the contents of one vector with another vector of
	 * same type. Sizes may differ.
	 * @param other vector with which to swap
	 */
	public void swap(Vector<E> other);
	
	/**
	 * Reduces the capacity of the container to fit its size and
	 * destroys all elements beyond the capacity.
	 */
	public void shrinkToFit();

	/**
	 * Resizes the container so that it contains just the first ‘n’ elements.
	 * @param newSize resize to container to this number of elements
	 */
	public void resize(int newSize);
	
	/**
	 * remove all the elements of the vector container
	 */
	public void clear();
	
	/**
	 * **Extra credit
	 * reserve() – Requests that the vector capacity be at least enough 
	 * to contain n elements.
	 */
	// public void reserve(int reserveSize);

	// ----------- Iterators ----------------
	/**
	 * begin()
	 * @return An iterator pointing to the first element.
	 */	
	public Iterator<E> begin();
	
	/**
	 * Extra credit iterator 
	 * -- rbegin()
	 * 
	 * @return A reverse iterator pointing to the last element in the vector
	 * (reverse beginning). It moves from last to first element.
	 */
	// public Iterator<E> rbegin();

}