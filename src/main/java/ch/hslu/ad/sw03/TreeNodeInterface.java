package ch.hslu.ad.sw03;

public interface TreeNodeInterface<T> {

    /**
     * Returns the left node of the current node.
     * @return object of the left node.
     */
    TreeNode<T> getLeft();

    /**
     * Adds a node to the left side of the current node.
     * @param left node.
     */
    void setLeft(TreeNode<T> left);

    /**
     * Returns the right node of the current node.
     * @return object of the right node.
     */
    TreeNode<T> getRight();

    /**
     * Adds a node to the right side of the current node.
     * @param right node.
     */
    void setRight(TreeNode<T> right);

    /**
     * Returns the value of the node.
     * @return the value of the node.
     */
    T getValue();

    /**
     * Sets the value of a node
     * @param value
     */
    void setValue(T value);

    /**
     * Performs a mathematical operation
     * @return result as integer
     */
    Integer eval();
}
