package ch.hslu.ad.sw02;

/**
 * linked list of type single (only head attr)
 * @param <T> data type
 */
public final class NodeList<T> {
    private Node<T> head;

    public void add(Node<T> node) {
        if (head == null) {
            head = node;
        } else {
            node.setNext(head);
            this.head = node;
        }
    }

    public int size() {
        Node<T> currentPos = head;
        int count = 0;

        while(currentPos != null) {
            currentPos = currentPos.getNext();
            count++;
        }

        return count;
    }

    public boolean exists(final T value) {
        Node<T> currentPos = head;

        while (currentPos != null) {
            if (currentPos.getValue() == value) {
                return true;
            }

            currentPos = currentPos.getNext();
        }

        return false;
    }

    public T getFirst() {
        Node<T> oldHead = head;
        this.head = oldHead.getNext();
        return oldHead.getValue();
    }

    public Node<T> getHead() {
        return this.head;
    }

    // ToDo: return 0 when empty
    public void remove(final T value) {
        if (head.getValue() == value) {
            head = head.getNext();
            return;
        }

        Node<T> currentPos = head;
        Node<T> prevPos = null;

        while (currentPos != null) {
            if (currentPos.getValue() == value) {
                prevPos.setNext(currentPos.getNext());
                break;
            }

            prevPos = currentPos;
            currentPos = currentPos.getNext();
        }
    }
}
