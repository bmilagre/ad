package ch.hslu.ad.sw03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinaryTree {
    private static final Logger LOG = LoggerFactory.getLogger(BinaryTree.class);

    private TreeNode root;

    public static void main(String[] args) {
        TreeNode root = new TreeNode("G");
        TreeNode b = new TreeNode("B");
        TreeNode a = new TreeNode("A");
        TreeNode f = new TreeNode("F");
        TreeNode e = new TreeNode("E");
        TreeNode j = new TreeNode("J");
        TreeNode h = new TreeNode("H");
        TreeNode n = new TreeNode("N");
        TreeNode m = new TreeNode("M");
        TreeNode o = new TreeNode("O");

        root.setLeft(b);
        root.setRight(j);
        b.setLeft(a);
        b.setRight(f);
        f.setLeft(e);
        j.setLeft(h);
        j.setRight(n);
        n.setLeft(m);
        n.setRight(o);

        BinaryTree tree = new BinaryTree(root);
        tree.search(root, "E");
        LOG.info("------");
        tree.insert(root, "Z");
        tree.search(root, "Z");
        LOG.info("Inorder Traversierung:");
        tree.inorderTraversal();
    }


    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode search(TreeNode node, String value) {
        LOG.info(String.valueOf(node));

        if (node == null) {
            return null;
        }

        if (node.getValue().equals(value)) {
            return node;
        }

        if (value.compareTo(node.getValue()) < 0) {
            return search(node.getLeft(), value);
        }

        if (value.compareTo(node.getValue()) > 0) {
            return search(node.getRight(), value);
        }

        return null;
    }

    public void insert(TreeNode node, String value) {
        this.root = insertRec(node, value);
    }

    private TreeNode insertRec(TreeNode node, String value) {
        if (node == null) {
            return new TreeNode(value);
        }

        // Wenn der Wert kleiner ist, links einfügen
        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(insertRec(node.getLeft(), value));
        }

        // Wenn der Wert größer ist, rechts einfügen
        if (value.compareTo(node.getValue()) > 0) {
            node.setRight(insertRec(node.getRight(), value));
        }

        return node;
    }

    public void inorderTraversal() {
        inorderTraversalRec(this.root);
    }

    private void inorderTraversalRec(TreeNode node) {
        if (node != null) {
            // Zuerst linker Teilbaum
            inorderTraversalRec(node.getLeft());
            // Dann aktueller Knoten
            LOG.info(node.getValue());
            // Zuletzt rechter Teilbaum
            inorderTraversalRec(node.getRight());
        }
    }
}
