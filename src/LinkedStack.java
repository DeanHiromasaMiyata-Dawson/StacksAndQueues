/**
 * Non-circular implementation of a LinkedStack. It should NOT be circular.
 */

import java.util.NoSuchElementException;

public class LinkedStack<T> {
    private LinkedNode<T> head;
    private int size;

    /**
     * Adds the data to the top of the stack.
     *
     * O(1).
     *
     * @param data the data to add to the top of the stack
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Error: data is empty.");
        }

        LinkedNode<T> temp = new LinkedNode<>(data, head);
        head = temp;
        size++;
    }

    /**
     * Removes and returns the data from the top of the stack.
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
        head = head.getNext();
        size--;
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

        return head.getData();
    }

    /**
     * Returns the head node of the stack.
     *
     * @return the node at the head of the stack
     */
    public LinkedNode<T> getHead() {
        return head;
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
