package leetcode;

/**
 * @author xp
 * @Describe https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @create 2019-11-08
 */
public class Ex26 {

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int n = removeDuplicates(nums);
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
