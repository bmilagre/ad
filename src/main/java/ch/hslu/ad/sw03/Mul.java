package ch.hslu.ad.sw03;

public class Mul extends TreeNode<Integer>{

    public Mul(TreeNode<Integer> left, TreeNode<Integer> right) {
        super();
        super.setLeft(left);
        super.setRight(right);
    }

    @Override
    public Integer eval() {
        return super.getLeft().eval() * super.getRight().eval();
    }
}
