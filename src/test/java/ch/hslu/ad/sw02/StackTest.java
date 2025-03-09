package ch.hslu.ad.sw02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack<String> stack;
    private Stack<String> stack2;

    @BeforeEach
    void setUp() {
        this.stack = new Stack<>(1);
        this.stack2 = new Stack<>(4);
    }

    @Test
    void testIfStackIsEmptyWhenInitializing() {
        assertEquals(0, this.stack.size());
    }

    @Test
    void testIfStackHasOneElementWhenPushingInteger() {
        Stack<Integer> stack2 = new Stack<>(5);
        stack2.push(-25);
        assertEquals(-25, stack2.pop());
    }

    void testIfStackHasOneElementWhenPushing() {
        stack.push("Test");
        assertEquals(1, this.stack.size());
    }

    @Test
    void testIfStackIsFullWhenPushing() {
        assertThrows(StackOverflowError.class, () -> {
            stack.push("Test");
            stack.push("Test2");
        }, "Check if stack returns error when full.");
    }

    @Test
    void testIfStackReturnsCorrectElementWhenPopping() {
        stack2.push("Test1");
        stack2.push("Test2");
        stack2.push("Test3");
        assertEquals("Test3", stack2.pop());
    }
}