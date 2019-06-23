package practice.linked.ex02;

/**
 * @Description 测试
 * @Created by XP
 * @Date 2019/6/23
 */
public class Main {

    public static void main(String[] args) {
        LinkedLRU lru = new LinkedLRU(6);
        lru.addNode(10);
        lru.addNode(20);
        lru.addNode(30);
        lru.addNode(40);
        lru.addNode(50);
        lru.addNode(60);

        //超过缓存大小，继续添加
        lru.addNode(70);
        lru.display();

        //访问数据
        lru.getData(70);
        lru.display();

    }
}
