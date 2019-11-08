package leetcode;

import java.util.Arrays;

/**
 * @author xp
 * @Describe https://leetcode-cn.com/problems/rotate-array/comments/
 * @create 2019-11-08
 */
public class Ex189 {


    /**
     * 时间复杂度：O(k*n)
     * 空间复杂度：O(1)
     */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        for (int i = 1; i <= k; i++) {
            int item = nums[len - 1];
            for (int j = len - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = item;
        }
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static void rotate_2(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, -100, 3, 99};
        rotate_2(a, 2);
        Arrays.stream(a).forEach(one -> System.out.print(" " + one));

    }
}
