package ch.hslu.ad.sw02;

public interface QueueInterface<T> {

    /**
     * Add the element to the queue.
     * @param element
     */
    void enqueue(T element);

    /**
     * Returns the oldest element from the queue
     * @return the oldest element
     */
    T dequeue();

    /**
     * Returns the oldest element from the queue without removing it.
     * @return oldest element
     */
    T peek();

    /**
     * Returns the boolean state if the queue is empty
     * @return empty state
     */
    boolean isEmpty();

    /**
     * Returns the boolean state if the queue is full.
     * @return
     */
    boolean isFull();

    /**
     * Returns the current size of the queue.
     * @return current size of queue.
     */
    int size();
}
