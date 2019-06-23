package practice.linked.ex01;

/**
 * @Description 单链表节点
 * @Created by XP
 * @Date 2019/6/23
 */
public class LinkedNode {

    private int data;
    private LinkedNode nextNode;


    public LinkedNode() {
    }

    public LinkedNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedNode nextNode) {
        this.nextNode = nextNode;
    }
}
