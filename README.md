# Queue
Implementation of a Queue using own implementation of LinkedList.
# Methods
1. `add(E item)` - add item to end of queue, returns true if successful else false. Throws IllegalStateException on full queue and NullPointerException on null item.
2. `T element()` - retrieve but not remove head of queue. Throws NoSuchElementException on empty Queue.
3. `boolean offer(T item)` - add item to queue if not at capacity. Returns true if added else false. Throws NullPointerException on null item.
4. `T peek()` - retrieve but not remove item from head of queue. Returns Null if empty.
5. `T poll()` - retrieve and remove item from start of queue. Returns Null if empty.
6. `T remove()` - retrieve and remove item from start of queue. Throws NoSuchElementException on empty queue.