package practice.search.ex02;

/**
 * @Description
 * @Created by XP
 * @Date 2019/6/30
 */
public class QuickSearch {
    /**
     * 利用快速排序思想实现查找第K大的数
     * 时间复杂度为O(n)
     *
     * @param arr
     * @param start
     * @param end
     * @param k
     * @return
     */
    public static int quickSearch(int arr[], int start, int end, int k) {
        if (start <= end) {
            int q = partition(arr, start, end);
            if (k == (q + 1)) {
                return arr[q];
            } else if (k < (q + 1)) {
                end = q - 1;
                return quickSearch(arr, start, end, k);
            } else {
                start = q + 1;
                return quickSearch(arr, start, end, k);
            }
        }
        return -1;
    }

    public static int partition(int arr[], int start, int end) {
        int p = arr[end];
        int i = start;
        for (int j = start; j <= end; j++) {
            if (arr[j] > p) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = p;
        arr[end] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 26, 33, 19, 6, 12, 14, 45, 26, 13, 49, 38, 65, 97, 76, 13, 27, -10, 0, 50};
        int k = 5;
        int result = quickSearch(arr, 0, arr.length - 1, k);
        System.out.println("第" + k + "大数据为:" + result);

    }
}
