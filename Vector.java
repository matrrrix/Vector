/**
 *  Program 5
 *  Vector class creates a dynamic array that can grow and shrink as needed
 *  CS108-3
 *  4/06/22
 *  @author  Logan Wolff
  */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class Vector<E> extends AbstractListADT<E> 
implements Iterable<E> {
	
	public static String getIdentificationString() {
 		//returns the number and author of the program
 		String author = "Logan Wolff";
 		String programNum = "5";
		return "Program " + programNum + ", " + author;
 	}	
	
	//initializes capacity and the internal array
	int capacity;
	E[] myList;
	
	//creates a vector with the default capacity of 10
	@SuppressWarnings("unchecked")
	public Vector() {
	    myList = (E[]) new Object[DEFAULT_CAPACITY];
	    size = 0;
	    capacity = DEFAULT_CAPACITY;
	}

	//the parameter is used to create a vector with a given capacity
	@SuppressWarnings("unchecked")
	public Vector(int userCapacity) {
	    myList = (E[]) new Object[userCapacity];
	    size = 0;
	    capacity = userCapacity;
	}

	//creates a copy of a given parameter
	public Vector(Vector<E> userVector) {
		myList = userVector.data();
		size = userVector.size();
		capacity = userVector.capacity();
	}
	
	//returns capacity
	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return capacity;
	}

	@Override
	public E front() {
		//ensures the vector is not empty, then returns the value of the start of the vector
		E front = null;
		if (!isEmpty()) {
		front = myList[0];
		}
		return front;
	}

	@Override
	public E back() {
		//ensures the vector is not empty, then returns the value at the end of the vector
		E back = null;
		if (!isEmpty()) {
			//assigns back to the last non null element of the internal array
			back = myList[size - 1];
		}
		return back;
	}

	@Override
	public E[] data() {
		//returns the internal array
		return myList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		//reinitializes the internal array to clear all objects
		myList = (E[]) new Object[capacity];
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void pushback(E element) {
		//adds an element to the back of the vector if their is capacity, otherwise resizes the vector with double the capacity first
		if (size < capacity) {
			 myList[size] = element;
			}
			else {
				resize(capacity * 2);
				myList[size] = element;
				}
		++size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E popback() {
		//initializes a temporary array and a generic type object for the returning value
		E[] newList;
		E removed = null;
		
		//ensures that the vector is not empty, then finds the last element 
			if (!isEmpty()) {
				int element = size - 1;
				newList = (E[]) new Object[capacity];
				 for (int i = size - 1; i >= 0; i--) {
					 if (myList[i] != null) {
						 break;
					 }
					 else {
					  --element;
					 }
				 }
				 
				 //removes the last element while transferring the other elements into a temporary list
				for (int i = 0; i < myList.length; i++) {
					if (i == element) {
						removed = myList[i];
						newList[i] = null;
					}
						else { 
							newList[i] = myList[i];
						}
				}
				--size;
				//sets the temporary list with the last element removed as the internal array
				myList = newList;
				}
			
		return removed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(int insertPosition, E element) {
		
		//checks if the parameter falls within the vector
		if (!(insertPosition >= 0 && insertPosition < size))
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		
		//holds the current value in the index that the new element is being put into 
		E holdCurrent = myList[insertPosition];
		E holdNext;
		//checks if the insertedposition is the last element to ensure that an arrayoutofbounds does not occur
		if (insertPosition < size - 1) {
			//holds the value of the next element 
			holdNext = myList[insertPosition + 1];
		}
		//inserts the new element
		myList[insertPosition] = element;
		
		
		//increases vector if needed to compensate for increased size
		if (size + 1 > capacity) {
			resize(size + 1);
		}
		else {
			size++;
		}
		
		//moves each element after the inserted position over one index to the right
		for (int i = insertPosition + 1; i < size; i++) {
			holdNext = myList[i];
			myList[i] = holdCurrent;
			holdCurrent = holdNext;
			if (i < size - 1) {
			holdNext = myList[i + 1];
			}
		}
	}

	@Override
	public void erase(int position) {
		//checks if the position falls within the vector
		if (!(position >= 0 && position < size))
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		
		
		myList[position] = null;
		--size;
		
		//moves all elements after the erased position to the left
		for (int i = position; i < size; i++) {
			myList[i] = myList[i + 1];
		}
		myList[size] = null;
	}

	@Override
	public void erase(int startRangePosition, int endRangePosition) {
		//calls the erase method for all values from startRangePosition (inclusive)  until endRangePosition (exclusive)

		for (int i = startRangePosition; i < endRangePosition; i++) {
			erase(startRangePosition);
		}
	}

	@Override
	public void swap(Vector<E> other) {
		
		//declares a temporary vector to use when swapping elements
		Vector<E> temp = new Vector<>(other);
		
		//clears the user given vector to prepare for swapping
		other.clear();
		
		//calls pushback to add all elements from the this internal array
		for(int i = 0; i < size; i++) {
			other.pushback(myList[i]);
		}
		
		//clears this vector to prepare for swapping
		clear();
	
		//uses the temporary vector that has the elements from the user given vector and calls pushback to them onto this internal array
		for (int i = 0; i < temp.size(); i++) {
			pushback(temp.at(i));
		}
	}

	@Override
	public void shrinkToFit() {
		//resizes the array to size to remove all null elements of the internal array
		resize(size);
		capacity = size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void resize(int newSize) {
		
		//creates a temporary array
		 E[] newList;
		 int until;
		 
		 //checks if the newSize is greater than size to ensure an arrayoutofbounds exception does not occur
		 if (newSize > size) {
			 until = size;
		 }
		 else {
			 until = newSize;
		 }
		 
		newList = (E[]) new Object[newSize];
		for (int i = 0; i < until; i++) {
			newList[i] = myList[i];		
		}
		myList = newList;
		capacity = newSize;
		size = newSize;
	}

	
	
	@Override
	public Iterator<E> begin() {
		//creates an iterator
		 Iterator<E> itr = iterator();
		return itr;
	}

	@Override
	public Iterator<E> iterator() {
		//returns an instance of private class VectorIteratorHelper to assist in printing the vector
		return new VectorIteratorHelper();
	}

	@Override
	public E at(int index) {
		//ensure the user given index falls within the vector
		if (!(index >= 0 && index < size))
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		return myList[index];
	}

	private class VectorIteratorHelper implements Iterator<E> {

		private int counter = 0;
		private E[] list = (E[]) myList;
		
		@Override
		public boolean hasNext() {
			return counter != size;
		}

		@Override
		public E next() {
			if (hasNext() && list[counter] != null) {
				return list[counter++];
			}
			return null;
		}
		
	}




}

