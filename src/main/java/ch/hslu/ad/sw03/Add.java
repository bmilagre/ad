package ch.hslu.ad.sw03;

public class Add extends TreeNode<Integer> {

    public Add(TreeNode left, TreeNode right) {
        super();
        super.setLeft(left);
        super.setRight(right);
    }

    @Override
    public Integer eval() {
        return super.getLeft().getValue() + super.getRight().getValue();
    }


}
