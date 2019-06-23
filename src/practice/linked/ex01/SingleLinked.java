package practice.linked.ex01;

/**
 * @Description 单链表(带哨兵节点)
 * @Created by XP
 * @Date 2019/6/23
 */
public class SingleLinked {

    //链表头节点
    private LinkedNode head;


    public SingleLinked() {
        this.head = new LinkedNode();
        this.head.setData(0);
        this.head.setNextNode(null);
    }

    /**
     * 添加节点
     *
     * @param data
     * @return
     */
    public boolean addNode(int data) {
        LinkedNode node = new LinkedNode(data);
        node.setNextNode(this.head.getNextNode());
        int countOfNode = this.head.getData();
        this.head.setData(++countOfNode);
        this.head.setNextNode(node);
        return true;
    }

    /**
     * 删除节点
     *
     * @param data
     * @return
     */
    public boolean removeNode(int data) {
        LinkedNode p = this.head.getNextNode();
        LinkedNode pre = this.head;
        while (p != null) {
            int value = p.getData();
            if (data == value) {
                pre.setNextNode(p.getNextNode());
                p.setNextNode(null);
                int countOfNode = this.head.getData();
                this.head.setData(--countOfNode);
            }
            p = p.getNextNode();
            pre = pre.getNextNode();
        }

        return true;
    }

    /**
     * 链表反转
     */
    public void inversion() {
        LinkedNode p = this.head.getNextNode();
        while (p != null && p.getNextNode() != null) {
            LinkedNode q = this.head.getNextNode();
            LinkedNode t = p.getNextNode();
            this.head.setNextNode(p.getNextNode());
            p.setNextNode(p.getNextNode().getNextNode());
            t.setNextNode(q);
        }
    }


    /**
     * 查找链表中点
     *
     * @return
     */
    public LinkedNode findMid() {
        LinkedNode fast = this.head.getNextNode();
        LinkedNode slow = this.head.getNextNode();
        while (fast != null && fast.getNextNode() != null) {
            fast = fast.getNextNode().getNextNode();
            slow = slow.getNextNode();
        }
        return slow;
    }

    /**
     * 回文判断
     *
     * @return
     */
    public boolean isMoslems() {
        LinkedNode fast = this.head.getNextNode();
        LinkedNode slow = this.head.getNextNode();
        while (fast != null && fast.getNextNode() != null) {
            fast = fast.getNextNode().getNextNode();
            slow = slow.getNextNode();
        }
        LinkedNode[] node = new LinkedNode[this.head.getData() / 2];
        LinkedNode p = this.head.getNextNode();
        int i=0;
        while(i<node.length){
            node[i++]=p;
            p=p.getNextNode();
        }

        if (this.head.getData() % 2 == 0) {
           for(int j= node.length-1;j>=0;j--){
               if(node[j].getData()==slow.getData()){
                   slow=slow.getNextNode();
               }else{
                   return false;
               }
           }
        } else {
            slow=slow.getNextNode();
            for(int j= node.length-1;j>=0;j--){
                if(node[j].getData()==slow.getData()){
                    slow=slow.getNextNode();
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 打印链表信息
     */
    public void display() {
        LinkedNode p = this.head.getNextNode();
        System.out.print("head[" + this.head.getData() + "]" + "--->");
        while (p != null) {
            if (p.getNextNode() != null) {
                System.out.print("[" + p.getData() + "]--->");
            } else {
                System.out.print("[" + p.getData() + "]");
            }
            p = p.getNextNode();
        }
        System.out.println();
    }
}
