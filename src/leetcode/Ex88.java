package leetcode;

import java.util.Arrays;

/**
 * @author xp
 * @Describe https://leetcode-cn.com/problems/merge-sorted-array/comments/
 * @create 2019-11-08
 */
public class Ex88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int countLen = m + n;
        m--;
        n--;
        for (int i = countLen - 1; i >= 0; i--) {
            if (m >= 0 && n >= 0) {
                if (nums1[m] >= nums2[n]) {
                    nums1[i] = nums1[m];
                    m--;
                } else {
                    nums1[i] = nums2[n];
                    n--;
                }
            }else if (m >= 0) {
                nums1[i] = nums1[m];
                m--;
            }else if (n >= 0) {
                nums1[i] = nums2[n];
                n--;
            }
        }
    }

    public static void main(String[] args) {

        int[] a = new int[]{1,2,3,0,0,0};
        int[] b = new int[]{2,5,6};
        merge(a,3,b,3);
        Arrays.stream(a).forEach(one -> System.out.print(" " + one));

    }
}
