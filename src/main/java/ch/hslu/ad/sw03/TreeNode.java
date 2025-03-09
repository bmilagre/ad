package ch.hslu.ad.sw03;

public class TreeNode implements TreeNodeInterface {
    private String value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(String value) {
        this.value = value;
    }

    @Override
    public TreeNode getLeft() {
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
    public TreeNode getRight() {
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
    public String getValue() {
        return this.value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String leftValue = (left != null) ? left.getValue().toString() : "null";
        String rightValue = (right != null) ? right.getValue().toString() : "null";

        return "[TreeNode] value=" + value + ", left=" + leftValue + ", right=" + rightValue + "]";
    }
}
