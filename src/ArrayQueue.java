/**
 * Implementation of an ArrayQueue.
 */

import java.util.NoSuchElementException;

public class ArrayQueue<T> {

    /*
     * The initial capacity of the ArrayQueue.
     */
    public static final int INITIAL_CAPACITY = 9;
    private T[] backingArray;
    private int front;
    private int size;

    /**
     * Constructs a new ArrayQueue.
     */
    public ArrayQueue() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
        front = 0;
        size = 0;
    }

    /**
     * Adds the data to the back of the queue.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array and reset front to 0.
     *
     * Amortized O(1).
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Error: data is empty.");
        }

        if (size == backingArray.length) {
            T[] tempArray = (T[]) new Object[backingArray.length * 2];
            for (int i = 0; i < backingArray.length; i++) {
                tempArray[i] = backingArray[(front + i) % backingArray.length];
            }
            backingArray = tempArray;
            front = 0;
        }
        backingArray[((size++) + front) % backingArray.length] = data;
    }

    /**
     * Removes and returns the data from the front of the queue without shrinking backingArray.
     *
     * Replace any spots that are dequeued from with null.
     *
     * If the queue becomes empty as a result of this call, do not reset front to 0.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Error: queue is empty.");
        }

        T temp = peek();
        backingArray[front] = null;
        front = (front + 1) % backingArray.length;
        if (size-- == 0) {
            front = 0;
        }
        return temp;
    }

    /**
     * Returns the data from the front of the queue without removing it.
     *
     * O(1).
     *
     * @return the data located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Error: queue is empty.");
        }

        return backingArray[front];
    }

    /**
     * Returns the backing array of the queue.
     *
     * @return the backing array of the queue
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the front index of the queue.
     *
     * @return the front index of the queue
     */
    public int getFront() {
        return front;
    }

    /**
     * Returns the size of the queue.
     *
     * @return the size of the queue
     */
    public int size() {
        return size;
    }
}
