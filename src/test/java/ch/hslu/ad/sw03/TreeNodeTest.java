package ch.hslu.ad.sw03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    @Test
    void testConstructorAndGetValue() {
        TreeNode node = new TreeNode("A");
        assertEquals("A", node.getValue());
    }

    @Test
    void testSetAndGetLeft() {
        TreeNode parent = new TreeNode("A");
        TreeNode left = new TreeNode("B");
        parent.setLeft(left);
        assertEquals(left, parent.getLeft());
    }

    @Test
    void testSetAndGetRight() {
        TreeNode parent = new TreeNode("A");
        TreeNode right = new TreeNode("C");
        parent.setRight(right);
        assertEquals(right, parent.getRight());
    }

    @Test
    void testToString() {
        TreeNode parent = new TreeNode("A");
        TreeNode left = new TreeNode("B");
        TreeNode right = new TreeNode("C");
        parent.setLeft(left);
        parent.setRight(right);
        
        String expected = "[TreeNode] value=A, left=B, right=C]";
        assertEquals(expected, parent.toString());
    }

    @Test
    void testToStringWithNullChildren() {
        TreeNode node = new TreeNode("A");
        String expected = "[TreeNode] value=A, left=null, right=null]";
        assertEquals(expected, node.toString());
    }
} 