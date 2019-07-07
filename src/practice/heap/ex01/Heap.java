package practice.heap.ex01;

/**
 * @Description 堆相关操作
 * @Created by XP
 * @Date 2019/7/7
 */
public class Heap {
    private int[] data;
    private int size;//数组大小
    private int count;//元素个数


    public Heap(int size) {
        this.data = new int[size + 1];//方便计算父节点和子节点，数组第一个位置不存数据
        this.size = size;
        this.count = 0;

    }

    /**
     * 向堆中添加一个元素
     * (大顶堆）
     *
     * @param data
     */
    public void insert(int data) {
        if (count >= size) return;
        count++;
        this.data[count] = data;
        int i = count;
        while (i / 2 > 0 && this.data[i / 2] < this.data[i]) {
            int temp = this.data[i];
            this.data[i] = this.data[i / 2];
            this.data[i / 2] = temp;
            i = i / 2;
        }
    }

    /**
     * 删除堆顶一个元素
     */
    public void deleteTop() {
        if (count == 0) return;
        this.data[1] = this.data[count];
        count--;
        heapify(this.data, 1, count);
    }

    /**
     * 堆排序
     */
    public void heapSort() {
        if (count == 0) return;
        int i = count;
        while (i > 0) {
            int temp = this.data[1];
            this.data[1] = this.data[i];
            this.data[i] = temp;
            heapify(this.data, 1, --i);
        }
    }

    /**
     * 对堆进行堆化
     *
     * @param data
     * @param start
     * @param end
     */
    public void heapify(int[] data, int start, int end) {
        int max = start;
        while (true) {
            if (start * 2 <= end && data[start] < data[start * 2]) {
                max = start * 2;
            }
            if ((start * 2 + 1) <= end && data[max] < data[start * 2 + 1]) {
                max = start * 2 + 1;
            }
            if (start == max) {
                break;
            }
            int temp = data[start];
            data[start] = data[max];
            data[max] = temp;
            start = max;
        }

    }

    public void display() {
        for (int i = 1; i <= count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

}
