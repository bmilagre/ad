package ch.hslu.ad.sw03;

public class Number extends TreeNode<Integer> {

    public Number(int value) {
        super(value);
        super.setLeft(null);
        super.setRight(null);
    }

    @Override
    public Integer eval() {
        return super.getValue();
    }

    @Override
    public String toString() {
        return super.getValue().toString();
    }
}
