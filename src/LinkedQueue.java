/**
 * Non-circular implementation of a LinkedQueue.
 */

import java.util.NoSuchElementException;

public class LinkedQueue<T> {
    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int size;

    /**
     * Adds the data to the back of the queue.
     *
     * O(1).
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Error: data is empty.");
        }

        LinkedNode<T> temp = new LinkedNode<>(data);
        if (size == 0) {
            head = temp;
        } else {
            tail.setNext(temp);
        }
        tail = temp;
        size++;
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * O(1).
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Error: queue is empty.");
        }

        T temp = head.getData();
        head = head.getNext();
        if (size-- == 0) {
            tail = null;
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

        return head.getData();
    }

    /**
     * Returns the head node of the queue.
     *
     * @return the node at the head of the queue
     */
    public LinkedNode<T> getHead() {
        return head;
    }

    /**
     * Returns the tail node of the queue.
     *
     * @return the node at the tail of the queue
     */
    public LinkedNode<T> getTail() {
        return tail;
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
