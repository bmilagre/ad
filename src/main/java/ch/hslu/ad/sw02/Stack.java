package ch.hslu.ad.sw02;

/**
 * Implementation of a Singly Linked Lists
 * @param <T>
 */
public class Stack<T> implements StackInterface<T> {
    private Object arr[];
    private int capacity;
    private int top;

    public Stack(int size) {
        this.arr = new Object[size];
        this.capacity = size;
        this.top = -1;
    }

    @Override
    public void push(T value) {
        if(top == (capacity-1)) {
            throw new StackOverflowError("Stack is full");
        }

        this.arr[++top] = value;
    }

    @Override
    public T pop() {
        if(top == -1) {
            throw new StackOverflowError("Stack is empty");
        }

        return (T) this.arr[top--];
    }

    @Override
    public int size() {
        return (this.top + 1);
    }
}
