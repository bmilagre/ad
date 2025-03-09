package ch.hslu.ad.sw03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    private BinaryTree tree;
    private TreeNode root;

    @BeforeEach
    void setUp() {
        // Create a simple binary search tree
        //       G
        //      / \
        //     B   J
        //    / \   \
        //   A   F   N
        //      /   / \
        //     E   M   O
        root = new TreeNode("G");
        TreeNode b = new TreeNode("B");
        TreeNode a = new TreeNode("A");
        TreeNode f = new TreeNode("F");
        TreeNode e = new TreeNode("E");
        TreeNode j = new TreeNode("J");
        TreeNode n = new TreeNode("N");
        TreeNode m = new TreeNode("M");
        TreeNode o = new TreeNode("O");

        root.setLeft(b);
        root.setRight(j);
        b.setLeft(a);
        b.setRight(f);
        f.setLeft(e);
        j.setRight(n);
        n.setLeft(m);
        n.setRight(o);

        tree = new BinaryTree(root);
    }

    @Test
    void testSearchExistingValue() {
        TreeNode result = tree.search(root, "E");
        assertNotNull(result);
        assertEquals("E", result.getValue());
    }

    @Test
    void testSearchNonExistingValue() {
        TreeNode result = tree.search(root, "Z");
        assertNull(result);
    }

    @Test
    void testInsertNewValue() {
        tree.insert(root, "C");
        TreeNode result = tree.search(root, "C");
        assertNotNull(result);
        assertEquals("C", result.getValue());
    }

    @Test
    void testInsertExistingValue() {
        tree.insert(root, "E");
        TreeNode result = tree.search(root, "E");
        assertNotNull(result);
        assertEquals("E", result.getValue());
    }

    @Test
    void testSearchEmptyTree() {
        BinaryTree emptyTree = new BinaryTree(null);
        TreeNode result = emptyTree.search(null, "A");
        assertNull(result);
    }

    @Test
    void testInorderTraversal() {  
        // Inorder-Traversierung sollte die Knoten in dieser Reihenfolge besuchen:
        // A -> B -> E -> F -> G -> J -> M -> N -> O

        tree.inorderTraversal();
    }
} 