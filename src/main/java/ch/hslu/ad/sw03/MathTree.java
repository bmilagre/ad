package ch.hslu.ad.sw03;

import ch.hslu.ad.sw03.Number;
import ch.hslu.ad.sw03.Add;
import ch.hslu.ad.sw03.Mul;

public class MathTree {

    public static void main(String[] args) {
        TreeNode n = new Mul(new Add(new Number(2), new Number(3)), new Number(4));
        System.out.println (n.eval());
        System.out.println (n.toString());
    }
}
