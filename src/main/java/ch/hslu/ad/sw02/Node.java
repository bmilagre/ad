package ch.hslu.ad.sw02;

/**
 * Represents a node for the node list
 * @param <T> data type
 */
public final class Node<T> {
    private Node<T> next;
    private T value;


    public Node(final T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return this.value;
    }


    public void setValue(final T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return this.next;
    }


    public void setNext(final Node<T> next) {
        this.next = next;
    }
}
