package org.customqueuelinkedlist;

import java.util.NoSuchElementException;

/**
 * @param <T>
 */
public interface Queue<T> {

    /**
     * Add item to end of queue
     * @param item to be added to queue
     * @return boolean true if added else false
     * @throws NullPointerException on null item
     */
    boolean add(T item);

    /**
     * Retrieve but not remove head of queue
     * @return element at head of queue
     * @throws NoSuchElementException empty queue
     */
    T element();

    /**
     * Offer item to end of queue
     * @param item to be added to queue
     * @return boolean true if added else false
     * @throws NullPointerException on null item
     */
    boolean offer(T item);

    /**
     * Retrieves, but does not remove, the head of this queue
     * @return item at head of queue
     * @throws NoSuchElementException on empty queue
     */
    T peek();

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     * @return item at head of queue, else null
     */
    T poll();

    /**
     * Remove item from front of queue
     * @return T item returned
     * @throws NullPointerException on null item
     */
    T remove();

    /**
     * Get size of queue
     * @return Integer of size queue
     */
    int size();
}