package practice.backtrack.ex01;

/**
 * @author xp
 * @Describe 回溯算法实验 0-1背包问题
 * @create 2019-07-19
 */
public class Backpack {

    //背包中已放物品的最大重量
    private static int maxW = Integer.MIN_VALUE;

    //背包中已放物品的最大价值
    private static int maxV = Integer.MIN_VALUE;

    /**
     * 背包总的承载重量为Wkg,有n个物品，每个物品的重量不等，且不可分割，如何在不超过承载重量的情况下使得背包中总重量最大
     *
     * @param i       放入第几个物品
     * @param cw      已存放物品总量
     * @param weights 物品重量数组
     * @param n       总的物品个数
     * @param w       背包最大承重
     */
    public static void backpackOfWeight(int[] weights, int i, int cw, int n, int w) {
        if (i == n || cw == w) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        backpackOfWeight(weights, i + 1, cw, n, w); //不放入第i个物品
        if (cw + weights[i] <= w) {
            backpackOfWeight(weights, i + 1, cw + weights[i], n, w); //放入第i个物品
        }
    }

    /**
     * 背包总的承载重量为Wkg,有n个物品，每个物品的重量不等，且不可分割，如何在不超过承载重量的情况下使得背包中总价值最大
     *
     * @param i       放入第几个物品
     * @param cw      已存放物品总量
     * @param weights 物品重量数组
     * @param n       总的物品个数
     * @param w       背包最大承重
     */
    public static void backpackOfValue(int[] weights, int[] values, int i, int cw,int cv, int n, int w) {
        if (i == n || cw == w) {
            if (cv > maxV) {
                maxV = cv;
            }
            return;
        }
        backpackOfValue(weights,values,i + 1, cw, cv, n, w); //不放入第i个物品
        if (cw + weights[i] <=w ) {
            backpackOfValue(weights,values,i + 1, cw + weights[i], cv+values[i], n, w); //放入第i个物品
        }
    }


    public static void main(String[] args) {


        int[] weights = {10, 5, 30, 2, 7, 15, 40, 50, 20, 10};
        backpackOfWeight(weights,0, 0, 10, 109);
        System.out.println("重量最大："+maxW);

        int[] values = {3, 10, 4, 2, 7, 15, 4, 5, 2, 1};
        backpackOfValue(weights,values,0, 0,0 ,10, 108);
        System.out.println("价值最大："+maxV);

    }

}
