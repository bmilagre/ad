package ch.hslu.ad.sw02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void testIfQueueHeadHasCorrectPositionAfterEnqueue(){
        Queue<Character> queue = new Queue<Character>(8);
        queue.enqueue('a');
        queue.enqueue('b');

        assertEquals('a', queue.peek());
    }

    @Test
    void testIfQueueReturnsCorrectElementFromDequeue(){
        Queue<Character> queue = new Queue<Character>(8);
        queue.enqueue('a');
        queue.enqueue('b');

        assertEquals('a', queue.dequeue());
    }

    @Test
    void testIfQueueHeadHasCorrectPositionAfterDequeue(){
        Queue<Character> queue = new Queue<Character>(8);
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.dequeue();

        assertEquals('b', queue.peek());
    }

    @Test
    void testIfQueueIsCorrectlyEmpty(){
        Queue<Character> queue = new Queue<Character>(8);
        assertTrue(queue.isEmpty());

        queue.enqueue('a');
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void testIfQueueIsCorrectlyFull(){
        Queue<Character> queue = new Queue<Character>(2);
        queue.enqueue('a');
        queue.enqueue('b');

        assertTrue(queue.isFull());
    }
}