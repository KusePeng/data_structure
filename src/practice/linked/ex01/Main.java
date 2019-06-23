package practice.linked.ex01;

/**
 * @Description TODO
 * @Created by XP
 * @Date 2019/6/23
 */
public class Main {

    public static void main(String[] args) {


        SingleLinked sl = new SingleLinked();
        sl.addNode(10);
        sl.addNode(20);
        sl.addNode(30);
        sl.addNode(20);
        sl.addNode(10);
        sl.display();

        //链表反转测试
        sl.inversion();
        sl.display();

        //链表查找中间节点
        LinkedNode mid = sl.findMid();
        System.out.println(mid.getData());

        //回文判断
        boolean result = sl.isMoslems();
        System.out.println(result);


    }
}
