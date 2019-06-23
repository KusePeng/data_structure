package practice.linked.ex02;

/**
 * @Description 链表实现简单LRU缓存
 * @Created by XP
 * @Date 2019/6/23
 */
public class LinkedLRU {

    //头结点优于存放链表长度
    private Node head = new Node(0);
    private Node tail = null;
    private int size;//链表节点个数(模拟缓存大小)

    public LinkedLRU(int size) {
        this.size = size;
    }

    /**
     * 添加节点到链表头部
     *
     * @param data
     */
    public void addNode(int data) {
        if (head.data == size) {
            System.out.println("链表节点已满,节点" + data + "添加失败");
        } else {
            Node node = new Node(data);
            if (tail == null) {
                tail = node;
            }
            if (head.nextNode == null) {
                head.nextNode = node;
            } else {
                node.nextNode = head.nextNode;
                head.nextNode = node;
            }
            head.data++;
        }
    }

    /**
     * 访问节点数据
     *
     * @param data
     * @return
     */
    public Node getData(int data) {
        Node p = head.nextNode;
        Node q = head;
        while (p != null) {
            if (p.data == data) {
                if (q != head) {
                    if (p == tail) {
                        tail = q;
                    }
                    q.nextNode = p.nextNode;
                    p.nextNode = head.nextNode;
                    head.nextNode = p;
                }
                return p;
            }
            p = p.nextNode;
            q = q.nextNode;
        }
        //未查找到对应的数据时，添加数据到链表头部
        if (head.data < size) {
            addNode(data);
        } else {
            //链表节点满时，删除最后一个节点
            Node k = head.nextNode;
            while (k != null && k.nextNode != tail) {
                k = k.nextNode;
            }
            tail = k;
            tail.nextNode = null;
            --head.data;
            addNode(data);
        }
        return null;
    }

    /**
     * 打印链表数据
     */
    public void display() {
        Node p = head;
        while (p.nextNode != null) {
            p = p.nextNode;
            System.out.print(p.data + "  ");
        }
        System.out.println();

    }

    /**
     * 链表节点数据
     */
    private class Node {
        public int data;
        public Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }
}
