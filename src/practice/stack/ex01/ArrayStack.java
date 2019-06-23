package practice.stack.ex01;

/**
 * @Description 基于数组实现的简单栈
 * @Created by XP
 * @Date 2019/6/23
 */
public class ArrayStack {
    private String[] dataArray;
    //栈中元素个数
    private int count;
    //栈大小
    private int size;

    public ArrayStack(int size) {
        this.size = size;
        this.dataArray = new String[size];
        this.count = 0;
    }

    /**
     * 入栈
     *
     * @param data
     * @return
     */
    public boolean push(String data) {
        if (count == size) {
            return false;
        }
        this.dataArray[count] = data;
        ++count;
        return true;
    }

    /**
     * 出栈
     *
     * @return
     */
    public String pop() {
        if (count == 0) {
            return null;
        }
        String result = this.dataArray[count - 1];
        --count;
        return result;
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    public String peek() {
        if (count == 0) {
            return null;
        } else {
            String result = this.dataArray[count - 1];
            return result;
        }
    }

    public void diplay() {
        for (int i = 0; i < count; i++) {
            System.out.print(dataArray[i] + " ");
        }
        System.out.println();
    }
}
