package practice.tree.ex02;

/**
 * @Description 二叉查找树
 * @Created by XP
 * @Date 2019/6/30
 */
public class BinarySearchTree {

    private Node tree;

    public Node getTree() {
        return tree;
    }

    /**
     * 向二叉查找树种添加一个节点
     *
     * @param data
     * @return
     */
    public boolean addNode(int data) {
        if (this.tree == null) {
            Node root = new Node(data);
            this.tree = root;
            return true;
        }
        Node p = tree;
        while (p != null) {
            if (data < p.data) {
                if (p.left == null) {
                    Node left = new Node(data);
                    p.left = left;
                    return true;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    Node right = new Node(data);
                    p.right = right;
                    return true;
                }
                p = p.right;
            }
        }
        return true;
    }

    /**
     * 查找一个节点
     *
     * @param data
     * @return
     */
    public Node findNode(int data) {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p != null) {
            if (p.data == data) {
                return p;
            } else if (p.data > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    /**
     * 删除节点
     *
     * @param data
     * @return
     */
    public boolean deleteNode(int data) {
        if (tree == null) {
            return false;
        }
        Node p = tree;
        Node pParent = null;
        //查找待删除节点
        while (p != null && p.data != data) {
            pParent = p;
            if (p.data > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return false;
        }
        //待删除节点有两个子节点时，先查找到待删除节点所在子树中的最小节点，
        //将待删除节点右子树中最小的节点和待删除节点进行交换
        if (p.left != null && p.right != null) {
            Node mp = p.right;
            Node mpParent = p;
            while (mp.left != null) {
                mpParent = mp;
                mp = mp.left;
            }
            p.data = mp.data;
            p = mp;
            pParent = mpParent;
        }
        //待删除节点为子节点或者为有一个子节点的树
        Node temp = null;
        if (p.left != null) {
            temp = p.left;
        } else if (p.right != null) {
            temp = p.right;
        }

        if (pParent == null) {
            tree = temp;
        } else if (pParent.left == p) {
            pParent.left = temp;
        } else {
            pParent.right = temp;
        }
        return true;
    }

    /**
     * 中序遍历
     *
     * @param
     */
    public void inOrder(Node tree) {
        if (tree == null) return;
        inOrder(tree.left);
        System.out.println(tree.data);
        inOrder(tree.right);
    }


    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
