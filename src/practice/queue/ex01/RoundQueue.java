package practice.queue.ex01;

/**
 * @Description 循环队列
 * @Created by XP
 * @Date 2019/6/23
 */
public class RoundQueue {

    private String data[];//队列元素数组
    private int size;//队列大小
    private int head;//队头标识
    private int tail;//队尾标识

    public RoundQueue(int size) {
        this.size = size;
        this.data = new String[size];
        this.head = this.tail = 0;
    }

    /**
     * 入队
     *
     * @param data
     * @return
     */
    public boolean enqueue(String data) {
        if ((tail + 1) % size == head) return false;
        this.data[tail] = data;
        tail = (tail + 1) % size;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {
        if (head == tail) return null;
        String result = this.data[head];
        head = (head + 1) % size;
        return result;
    }

    public void display() {
        int i = head;
        while (i % size != this.tail) {
            System.out.print(this.data[i] + " ");
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        RoundQueue q = new RoundQueue(7);
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");
        q.enqueue("e");
        q.enqueue("f");
        q.display();
        //出队
        q.dequeue();
        //入队
        q.enqueue("g");
        q.display();
    }
}
