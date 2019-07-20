package practice.dynamic.ex01;

/**
 * @Description 利用动态规划处理 0-1背包问题
 * @Created by XP
 * @Date 2019/7/20
 */
public class Backpack {

    /**
     * 背包总的承载重量为Wkg,有n个物品，每个物品的重量不等，且不可分割，如何在不超过承载重量的情况下使得背包中总重量最大
     *
     * @param weight 物品重量数组
     * @param n      物品个数
     * @param w      背包承重量
     * @return 最大重量
     */
    public static int backpackOfWeight(int[] weight, int n, int w) {
        boolean[][] status = new boolean[n][w + 1];//记录各个阶段处理状态

        //第0个物品特殊处理
        status[0][0] = true;//第0个物品不放进背包
        if (weight[0] <= w) {
            status[0][weight[0]] = true;//第0个物品放进背包
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (status[i - 1][j] == true) {
                    status[i][j] = status[i - 1][j];//不放入第i个物品
                }
            }
            for (int j = 0; j <= w - weight[i]; j++) {
                if (status[i - 1][j] == true) {
                    status[i][j + weight[i]] = true;//放入第i个物品
                }
            }
        }

        for (int i = w; i >= 0; i--) {
            if (status[n - 1][i] == true) {
                return i;
            }
        }
        return 0;
    }


    /**
     * 背包总的承载重量为Wkg,有n个物品，每个物品的重量不等，且不可分割，如何在不超过承载重量的情况下使得背包中总价值最大
     *
     * @param weight 物品重量数组
     * @param n      物品个数
     * @param w      背包承重量
     * @return 最大价值
     */
    public static int backpackOfValue(int[] weight, int[] values, int n, int w) {
        int[][] status = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                status[i][j] = -1;
            }
        }

        status[0][0] = 0;
        if (weight[0] <= w) {
            status[0][weight[0]] = values[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (status[i - 1][j] >= 0) {
                    status[i][j] = status[i - 1][j];
                }
            }

            for (int j = 0; j <= w - weight[i]; j++) {
                if (status[i - 1][j] >= 0) {
                    int v = status[i - 1][j] + values[i];
                    if (v > status[i][j + weight[i]]) {
                        status[i][j + weight[i]] = v;
                    }
                }
            }
        }
        int maxV = -1;
        for (int i = 0; i <= w; i++) {
            if (status[n - 1][i] > maxV) {
                maxV = status[n - 1][i];
            }
        }
        return maxV;
    }

    public static void main(String[] args) {
        int[] weight = {10, 5, 30, 2, 7, 15, 40, 50, 20, 10};
        int result = backpackOfWeight(weight, 10, 108);
        System.out.println("重量最大：" + result);

        int[] values = {3, 10, 4, 2, 7, 15, 4, 5, 2, 1};
        int maxV = backpackOfValue(weight, values, 10, 108);
        System.out.println("价值最大："+maxV);

    }

}
