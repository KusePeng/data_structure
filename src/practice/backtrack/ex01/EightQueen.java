package practice.backtrack.ex01;

/**
 * @author xp
 * @Describe 回溯算法实现八皇后问题
 * @create 2019-07-18
 */
public class EightQueen {

    //结果保存数组,下标表示行，存放的值表示列
    private static int[] result = new int[8];
    //摆放方式计数
    private static int total = 0;

    /**
     * 八皇后求解
     *
     * @param row 行
     */
    public static void eightQueen(int row) {
        if (row == 8) {
            total++;
            displayQueen();
            return;
        } else {
            for (int column = 0; column < result.length; column++) {
                boolean ok = isOk(row, column);
                if (ok) {
                    result[row] = column;
                    eightQueen(row + 1);
                }
            }
        }
    }

    /**
     * 判断行列位置是否合适
     *
     * @param row    行
     * @param column 列
     * @return
     */
    private static boolean isOk(int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {
                return false;//上一行的相同列已经存在一个Q
            }
            if (leftUp >= 0 && result[i] == leftUp) {
                return false;//左上角的相同列已经存在一个Q
            }
            if (leftUp < 8 && result[i] == rightUp) {
                return false;//右上角的相同列已经存在一个Q
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    /**
     * 打印结果数组
     */
    private static void displayQueen() {
        for (int row = 0; row < result.length; row++) {
            for (int column = 0; column < result.length; column++) {
                if (result[row] == column) {
                    System.out.print("Q" + " ");
                } else {
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        eightQueen(0);
        System.out.println("共计：" + total + " 种");
    }
}
