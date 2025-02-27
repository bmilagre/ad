package ch.hslu.ad.sw02;

import java.util.ArrayList;

public class Stack<T> implements StackInterface<T> {
    private Object arr[];
    private int capacity;
    private int top;

    public Stack(int size) {
        arr = new Object[size];
        capacity = size;
        top = -1;
    }

    @Override
    public void push(T value) {
        if(top == (capacity-1)) {
            throw new StackOverflowError("Stack is full");
        }

        arr[++top] = value;
    }

    @Override
    public T pop() {
        if(top == -1) {
            throw new StackOverflowError("Stack is empty");
        }

        return (T) arr[top--];
    }

    @Override
    public int size() {
        return (this.top + 1);
    }
}
