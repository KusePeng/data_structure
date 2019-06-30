package practice.tree.ex01;

/**
 * @Description 二叉树测试类
 * @Created by XP
 * @Date 2019/6/30
 */
public class Main {

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree(10);

        BinaryTree.TreeNode left = bt.getRoot().addLeftNode(9);
        left.addLeftNode(2);
        left.addRightNode(3);

        BinaryTree.TreeNode right = bt.getRoot().addRightNode(12);
        right.addLeftNode(11);
        right.addRightNode(13);

        bt.perOrder(bt.getRoot());

    }
}
