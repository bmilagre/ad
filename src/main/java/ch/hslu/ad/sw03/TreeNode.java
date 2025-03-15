package ch.hslu.ad.sw03;

public class TreeNode<T> implements TreeNodeInterface {
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode() {
        this.value = null;
    }

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public TreeNode<T> getLeft() {
        if (this.left != null) {
            return this.left;
        }

        return null;
    }

    @Override
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    @Override
    public TreeNode<T> getRight() {
        if (this.right != null) {
            return this.right;
        }

        return null;
    }

    @Override
    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(Object value) {
        this.value = (T) value;
    }


    public Integer eval() {
        throw new UnsupportedOperationException("Basic TreeNode cannot perform operation");
    }

    @Override
    public String toString() {
        String leftValue = (left != null && left.getValue() != null) ? left.getValue().toString() : "null";
        String rightValue = (right != null && right.getValue() != null) ? right.getValue().toString() : "null";

        return "[TreeNode] value=" + value + ", left=" + leftValue + ", right=" + rightValue + "]";
    }
}
