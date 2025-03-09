package ch.hslu.ad.sw03;

public interface TreeNodeInterface<T> {

    /**
     * Returns the left node of the current node.
     * @return object of the left node.
     */
    TreeNode getLeft();

    /**
     * Adds a node to the left side of the current node.
     * @param left node.
     */
    void setLeft(TreeNode left);

    /**
     * Returns the right node of the current node.
     * @return object of the right node.
     */
    TreeNode getRight();

    /**
     * Adds a node to the right side of the current node.
     * @param right node.
     */
    void setRight(TreeNode right);

    /**
     * Returns the value of the node.
     * @return the value of the node.
     */
    T getValue();

    /**
     * Sets the value of an node
     * @param value
     */
    void setValue(String value);
}
