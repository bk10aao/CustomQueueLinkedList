package org.customqueuelinkedlist;

import java.util.NoSuchElementException;

public class CustomQueueLinkedList<E> implements Queue<E> {
    private Node head;

    private int size = 0;
    private int capacity = 11;

    public CustomQueueLinkedList() { }

    public CustomQueueLinkedList(final int capacity) {
        this.capacity = capacity;
    }

    public boolean add(final E item){
        if(size == capacity)
            throw new IllegalStateException("Capacity reached");
        if(item == null)
            throw new NullPointerException("Null item not supported");
        if(this.head == null)
            head = new Node(item);
        else {
            Node currentNode = head;
            while(currentNode.nextNode != null)
                currentNode = currentNode.nextNode;
            currentNode.nextNode = new Node(item);
        }
        size++;
        return true;
    }

    public E element() {
        if(size == 0)
            throw new NoSuchElementException("Empty Queue");
        return peek();
    }

    public boolean offer(final E item) {
        if(item == null)
            throw new NullPointerException("Null item not supported");
        try {
            add(item);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public E peek() {
        if(size == 0)
            throw new NoSuchElementException("Empty Queue");
        return head.data;
    }

    public E poll() {
        if(size == 0)
            return null;
        E headValue = head.data;
        head = head.nextNode;
        size--;
        return headValue;
    }

    public E remove() {
        if(size == 0)
            throw new NoSuchElementException("Empty Queue");
        E headValue = head.data;
        head = head.nextNode;
        size--;
        return headValue;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if(size == 0)
            return "{ }";
        StringBuilder stringBuilder = new StringBuilder("{ ");
        int index = 0;
        for (Node x = head; x != null; x = x.nextNode, index++)
            stringBuilder.append(x.data).append(", ");
        return stringBuilder.replace(stringBuilder.lastIndexOf(", "), stringBuilder.length(), " }").toString();
    }

    private class Node {

        private final E data;
        private Node nextNode;

        public Node(E data) {
            this.data = data;
        }
    }
}
