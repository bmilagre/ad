package ch.hslu.ad.sw09;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FixedSizeHeapTest {

    private FixedSizeHeap heap;

    @BeforeEach
    void setUp() {
        heap = new FixedSizeHeap(16);
    }

    @Test
    void testInsertAndRemoveElements() {
        heap.push(20);
        heap.push(10);
        heap.push(5);
        heap.push(12);
        heap.push(7);
        heap.push(50);

        // Größtes Element zuerst
        assertEquals(50, heap.pop());
        assertEquals(20, heap.pop());
        assertEquals(12, heap.pop());
        assertEquals(10, heap.pop());
        assertEquals(7, heap.pop());
        assertEquals(5, heap.pop());

        // Jetzt ist Heap leer
        assertEquals(0, heap.pop());
    }

    @Test
    void testFullAndEmptyHeap() {
        // Fülle Heap mit 15 Elementen (max Größe abzüglich Dummy 0)
        for (int i = 1; i <= 15; i++) {
            heap.push(i);
        }

        // Danach sind alle Elemente drin
        for (int i = 15; i >= 1; i--) {
            assertEquals(i, heap.pop());
        }

        // Heap ist leer
        assertEquals(0, heap.pop());
    }

    @Test
    void testHeapReorganization() {
        heap.push(10);
        heap.push(40);
        heap.push(30);
        heap.push(5);
        heap.push(1);

        // 40 sollte oben sein
        assertEquals(40, heap.pop());

        // Danach 30
        assertEquals(30, heap.pop());

        // Danach 10
        assertEquals(10, heap.pop());

        // Danach 5
        assertEquals(5, heap.pop());

        // Danach 1
        assertEquals(1, heap.pop());

        // Danach leer
        assertEquals(0, heap.pop());
    }

    @Test
    void testEqualElements() {
        heap.push(20);
        heap.push(20);
        heap.push(20);

        assertEquals(20, heap.pop());
        assertEquals(20, heap.pop());
        assertEquals(20, heap.pop());
        assertEquals(0, heap.pop());
    }
}
