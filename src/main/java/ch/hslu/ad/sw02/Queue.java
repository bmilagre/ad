package ch.hslu.ad.sw02;

public class Queue<T> implements QueueInterface<T> {
    private final Object[] arr;
    private final int capacity;
    private int head;
    private int tail;

    public Queue(int size) {
        this.arr = new Object[size];
        this.capacity = size;
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public void enqueue(T element) {
        if (this.tail >= this.capacity) {
            this.tail = 0;
        }

        this.arr[this.tail] = element;
        this.tail++;
    }

    @Override
    public T dequeue() {
        if (this.isEmpty()) {
            return null;
        }

        if(this.head >= this.capacity) {
            this.head = 0;
        }

        T element = (T) this.arr[this.head];
        this.arr[this.head] = null;
        this.head++;

        return element;
    }

    @Override
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }

        return (T) this.arr[this.head];
    }

    @Override
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    @Override
    public boolean isFull() {
        return this.tail == this.capacity;
    }

    @Override
    public int size() {
        return this.tail - this.head;
    }

    @Override
    public String toString() {
        return "[Queue] size: " + this.size() + "; isEmpty: " + this.isEmpty() + "; isFull: " + this.isFull() + "; Content:" + "";
    }
}
