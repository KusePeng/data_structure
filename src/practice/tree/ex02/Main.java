package practice.tree.ex02;

/**
 * @Description 二叉查找树测试
 * @Created by XP
 * @Date 2019/6/30
 */
public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.addNode(16);
        bst.addNode(14);
        bst.addNode(20);
        bst.addNode(7);
        bst.addNode(8);
        bst.addNode(19);
        bst.addNode(21);
        bst.inOrder(bst.getTree());
        System.out.println("--------测试删除节点--------");

        bst.deleteNode(20);
        bst.inOrder(bst.getTree());

    }
}
