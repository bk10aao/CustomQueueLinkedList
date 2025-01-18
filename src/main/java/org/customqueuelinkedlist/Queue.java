package org.customqueuelinkedlist;

import java.util.NoSuchElementException;

/**
 * @param <T>
 */
public interface Queue<T> {

    /**
     * Add item to end of queue
     * @param item to be added to queue
     * @throws NullPointerException on null item
     * @return boolean true if added else false
     */
    boolean add(T item);

    /**
     * Retrieve but not remove head of queue
     * @throws NoSuchElementException empty queue
     * @return element at head of queue
     */
    T element();

    /**
     * Offer item to end of queue
     * @param item to be added to queue
     * @throws NullPointerException on null item
     * @return boolean true if added else false
     */
    boolean offer(T item);

    /**
     * Retrieves, but does not remove, the head of this queue
     * @throws NoSuchElementException on empty queue
     * @return item at head of queue
     */
    T peek();

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     * @return item at head of queue, else null
     */
    T poll();

    /**
     * Remove item from front of queue
     * @throws NullPointerException on null item
     * @return T item returned
     */
    T remove();

    /**
     * Get size of queue
     * @return Integer of size queue
     */
    int size();
}