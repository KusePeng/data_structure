package practice.linked.ex01;

/**
 * @Description 链表功能测试
 * @Created by XP
 * @Date 2019/6/23
 */
public class Main {

    public static void main(String[] args) {


        SingleLinked sl = new SingleLinked();
        //添加数据
        sl.addNode(10);
        sl.addNode(20);
        sl.addNode(30);
        sl.addNode(40);
        sl.addNode(50);
        sl.addNode(60);
        sl.display();

        //删除数据
        sl.removeNode(60);
        sl.display();

        //链表反转测试
        sl.inversion();
        sl.display();

        //链表查找中间节点
        LinkedNode mid = sl.findMid();
        if(mid!=null){
            System.out.println("中间节点："+mid.getData());
        }

        //回文判断
        boolean result = sl.isMoslems();
        System.out.println("是否为回文:"+result);


    }
}
