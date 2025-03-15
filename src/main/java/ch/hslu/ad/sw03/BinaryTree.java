package ch.hslu.ad.sw03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinaryTree {
    private static final Logger LOG = LoggerFactory.getLogger(BinaryTree.class);

    private TreeNode<String> root;

    public static void main(String[] args) {
        TreeNode root = new TreeNode<String>("G");
        TreeNode b = new TreeNode<String>("B");
        TreeNode a = new TreeNode<String>("A");
        TreeNode f = new TreeNode<String>("F");
        TreeNode e = new TreeNode<String>("E");
        TreeNode j = new TreeNode<String>("J");
        TreeNode h = new TreeNode<String>("H");
        TreeNode n = new TreeNode<String>("N");
        TreeNode m = new TreeNode<String>("M");
        TreeNode o = new TreeNode<String>("O");

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
        tree.insert("Z");
        tree.search(root, "Z");
        LOG.info("Inorder Traversierung:");
        tree.inorderTraversal();
    }


    public BinaryTree(TreeNode<String> root) {
        this.root = root;
    }

    public TreeNode search(TreeNode<String> node, String value) {
        LOG.info(String.valueOf(node));

        if (node == null) {
            return null;
        }

        if (node.getValue().equals(value)) {
            return node;
        }

        if (value.compareTo(node.getValue().toString()) < 0) {
            return search(node.getLeft(), value);
        }

        if (value.compareTo(node.getValue().toString()) > 0) {
            return search(node.getRight(), value);
        }

        return null;
    }

    public void insert(String value) {
        this.root = insertRec(this.root, value);
    }

    private TreeNode insertRec(TreeNode<String> node, String value) {
        if (node == null) {
            return new TreeNode(value);
        }

        // Wenn der Wert kleiner ist, links einfügen
        if (value.compareTo(node.getValue().toString()) < 0) {
            node.setLeft(insertRec(node.getLeft(), value));
        }

        // Wenn der Wert größer ist, rechts einfügen
        if (value.compareTo(node.getValue().toString()) > 0) {
            node.setRight(insertRec(node.getRight(), value));
        }

        return node;
    }

    public void inorderTraversal() {
        inorderTraversalRec(this.root);
    }

    private void inorderTraversalRec(TreeNode<String> node) {
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
