package practice.tree.ex01;

/**
 * @Description 二叉树前、中、后序遍历
 * @Created by XP
 * @Date 2019/6/30
 */
public class BinaryTree {

    private TreeNode root;//根节点

    public BinaryTree(int data) {
        TreeNode rootNode = new TreeNode(data);
        this.root = rootNode;
    }

    public TreeNode getRoot() {
        return root;
    }


    /**
     * 前序遍历
     *
     * @param node
     */
    public void perOrder(TreeNode node) {
        if (node == null) return;
        System.out.println(node.data);
        perOrder(node.leftNode);
        perOrder(node.rightNode);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.leftNode);
        System.out.println(node.data);
        inOrder(node.rightNode);
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.leftNode);
        postOrder(node.rightNode);
        System.out.println(node.data);

    }

    /**
     * 二叉树节点类
     */
    public static class TreeNode {
        public int data;
        public TreeNode leftNode;
        public TreeNode rightNode;


        public TreeNode(int data) {
            this.data = data;
        }

        /**
         * 添加左孩子节点
         *
         * @param data
         * @return
         */
        public TreeNode addLeftNode(int data) {
            TreeNode leftNode = new TreeNode(data);
            this.setLeftNode(leftNode);
            return leftNode;
        }

        /**
         * 添加右边孩子节点
         *
         * @param data
         * @return
         */
        public TreeNode addRightNode(int data) {
            TreeNode rightNode = new TreeNode(data);
            this.setRightNode(rightNode);
            return rightNode;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }
    }
}
