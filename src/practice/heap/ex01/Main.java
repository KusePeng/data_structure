package practice.heap.ex01;

/**
 * @Description 堆操作测试
 * @Created by XP
 * @Date 2019/7/7
 */
public class Main {


    public static void main(String[] args) {
        Heap h = new Heap(12);
        h.insert(12);
        h.insert(13);
        h.insert(11);
        h.insert(15);
        h.insert(17);
        h.insert(9);
        h.insert(8);
        h.insert(40);
        h.insert(-1);
        h.insert(0);
        h.insert(-10);
        h.insert(1);
        h.display();
        //删除堆顶元素
        h.deleteTop();
        h.display();
        //排序
        h.heapSort();
        h.display();

    }

}
