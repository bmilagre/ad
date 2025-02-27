package ch.hslu.ad.sw02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void testIfNodeReturnsCorrectValue(){
        Node<Integer> node = new Node<>(33);
        assertEquals(33, node.getValue());
    }

    @Test
    void testIfNodeReturnsNullOnNext(){
        Node<Integer> node = new Node<>(33);
        assertEquals(null, node.getNext());
    }

    @Test
    void testIfNodeReturnsCorrectNextNode(){
        Node<Integer> node = new Node<>(33);
        Node<Integer> next = new Node<>(44);

        node.setNext(next);
        assertEquals(next, node.getNext());
    }

    @Test
    void testIfNodeSavesCorrectValue(){
        Node<Integer> node = new Node<>(33);
        node.setValue(1122);

        assertEquals(1122, node.getValue());
    }
}