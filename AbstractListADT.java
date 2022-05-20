/**
 * AbstractListADT superclass for Vector
 * 
 * @author CS160 Spring 2022
 * @param <E> object to store in container
 */
public abstract class AbstractListADT<E> implements ListADT<E> {
	
	protected int size;

	/**
	 * @return – Returns the number of elements in the vector.
	 */
	public int size() {
		return size;
	}

	/**
	 * @return – Returns whether the container is empty.
	 */	
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Remove all the elements of the vector container
	 */
	public void clear() {
		size = 0;
	}
	
	/**
	 * Get the element at the index. If the index is invalid an error occurs.
	 * @param index of vector from which to return an element
	 * @return the element at the given index
	 * @throws IllegalArgumentException if index is invalid
	 */
	public abstract E at(int index);

}
