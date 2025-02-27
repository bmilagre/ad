package ch.hslu.ad.sw02;

public interface StackInterface<T>  {
    /**
     * Adds the element to the end of the stack.
     * @param element
     */
    void push(T element);

    /**
     * Returns the last element of the stack.
     * @return String
     */
    T pop();

    /**
     * Returns the size of the stack.
     * @return size of stack.
     */
    int size();
}
