package practice.backtrack.ex01;

/**
 * @author xp
 * @Describe 回溯算法实验 0-1背包问题
 * 背包总的承载重量为Wkg,有n个物品，每个物品的重量不等，且不可分割，如何在不超过承载重量的情况下使得背包中总重量最大
 * @create 2019-07-19
 */
public class Backpack {

    //背包中已放物品的最大重量
    private static int maxW = Integer.MIN_VALUE;

    /**
     * @param i     放入第几个物品
     * @param cw    已存放物品总量
     * @param items 物品重量数组
     * @param n     总的物品个数
     * @param w     背包最大承重
     */
    public static void backpack(int i, int cw, int[] items, int n, int w) {
        if (i == n || cw == w) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        backpack(i + 1, cw, items, n, w); //不放入第i个物品
        if (cw + items[i] <= w) {
            backpack(i + 1, cw + items[i], items, n, w); //放入第i个物品
        }
    }


    public static void main(String[] args) {
        int[] items = {10, 5, 30, 2, 7, 15, 40, 50, 20, 10};
        backpack(0, 0, items, 10, 108);
        System.out.println(maxW);
    }

}
