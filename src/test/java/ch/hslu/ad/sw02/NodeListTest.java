package ch.hslu.ad.sw02;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeListTest {

    @Test
    void testIfListIsEmptyWhenInitialized() {
        NodeList<Integer> list = new NodeList<>();
        assertEquals(0, list.size());
    }

    @Disabled
    void testIfListHasCorrectSize2() {
        NodeList<Integer> list = new NodeList<>();
        list.remove(0);

        assertEquals(0, list.size());
    }

    @Test
    void testIfListHasCorrectSize() {
        NodeList<Integer> list = new NodeList<>();
        list.add(new Node<>(1));
        assertEquals(1, list.size());
    }

    @Test
    void testIfValueExistInList() {
        NodeList<Integer> list = new NodeList<>();
        list.add(new Node<>(1));
        list.add(new Node<>(2));
        list.add(new Node<>(3));
        list.add(new Node<>(4));

        assertTrue(list.exists(3));
    }

    @Test
    void testIfgetFirstReturnsCorrectNextValue() {
        Node<Integer> test1 = new Node<>(22);
        Node<Integer> test2 = new Node<>(33);
        Node<Integer> test3 = new Node<>(44);

        NodeList<Integer> list = new NodeList<>();
        list.add(test1);
        list.add(test2);
        list.add(test3);

        assertEquals(44, list.getFirst());
        assertEquals(test2, list.getHead());
    }

    @Test
    void testIfremoveReturnsCorrectNextValue() {
        Node<Integer> test1 = new Node<>(22);
        Node<Integer> test2 = new Node<>(33);
        Node<Integer> test3 = new Node<>(44);
        Node<Integer> test4 = new Node<>(55);
        Node<Integer> test5 = new Node<>(66);

        NodeList<Integer> list = new NodeList<>();
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        list.add(test5);

        list.remove(44);

        assertFalse(list.exists(44));
        assertEquals(test2, test4.getNext());
    }

    @Test
    void testIfremoveReturnsCorrectNextValueTwoNodes() {
        Node<Integer> test1 = new Node<>(22);
        Node<Integer> test2 = new Node<>(33);

        NodeList<Integer> list = new NodeList<>();
        list.add(test1);
        list.add(test2);

        list.remove(22);

        assertFalse(list.exists(22));
        assertEquals(null, test1.getNext());
    }

    @Test
    void testIfremoveValueHead() {
        Node<Integer> test1 = new Node<>(22);
        Node<Integer> test2 = new Node<>(33);

        NodeList<Integer> list = new NodeList<>();
        list.add(test1);
        list.add(test2);

        list.remove(33);

        assertFalse(list.exists(33));
        assertEquals(null, test1.getNext());
    }
}