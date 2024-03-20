/**
 * Implementation of an ArrayStack.
 */

import java.util.NoSuchElementException;

public class ArrayStack<T> {

    /*
     * The initial capacity of the ArrayStack.
     */
    public static final int INITIAL_CAPACITY = 9;
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new ArrayStack.
     */
    public ArrayStack() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Adds the data to the top of the stack.
     * If sufficient space is not available in the backing array, resize it to
     * double the current length.
     *
     * Amortized O(1).
     *
     * @param data the data to add to the top of the stack
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Error: data is empty.");
        }

        if (size == backingArray.length) {
            T[] tempArray = (T[]) new Object[backingArray.length * 2];
            for (int i = 0; i < backingArray.length; i++) {
                tempArray[i] = backingArray[i];
            }
            backingArray = tempArray;
        }
        backingArray[size++] = data;
    }

    /**
     * Removes and returns the data from the top of the stack without shrinking the backing array.
     * Replace any spots that are poped from with null.
     *
     * O(1).
     *
     * @return the data formerly located at the top of the stack
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Error: stack is empty.");
        }
        T temp = peek();
        size--;
        backingArray[size] = null;
        return temp;
    }

    /**
     * Returns the data from the top of the stack without removing it.
     *
     * O(1).
     *
     * @return the data from the top of the stack
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Error: stack is empty.");
        }
        return backingArray[size - 1];
    }

    /**
     * Returns the backing array of the stack.
     *
     * @return the backing array of the stack
     */
    public T[] getBackingArray() {
        return backingArray;
    }

    /**
     * Returns the size of the stack.
     *
     * @return the size of the stack
     */
    public int size() {
        return size;
    }
}
