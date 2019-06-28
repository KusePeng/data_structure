package practice.sort.ex01;

/**
 * @author xp
 * @Describe 常用排序算法
 * @create 2019-06-24
 */
public class SortUtil {

    /**
     * 冒泡排序
     * 时间复杂度 n^2
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     * 时间复杂度 n^2
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
                j--;
            }
            arr[j + 1] = value;
        }
    }

    /**
     * 选择排序
     * 时间复杂度 n^2
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }

    }

    /**
     * 归并排序
     * 时间复杂度 logN
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void mergerSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (end + start) / 2;
            mergerSort(arr, start, mid);
            mergerSort(arr, mid + 1, end);
            merger(arr, start, mid, end);
        }
    }

    private static void merger(int[] arr, int start, int mid, int end) {
        int temp[] = new int[arr.length];
        int p = start;
        int q = mid + 1;
        int k = start;
        while (p <= mid && q <= end) {
            if (arr[p] <= arr[q]) {
                temp[k++] = arr[p++];
            } else {
                temp[k++] = arr[q++];
            }
        }
        while (p <= mid) {
            temp[k++] = arr[p++];
        }
        while (q <= end) {
            temp[k++] = arr[q++];
        }
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }

    /**
     * 快速排序
     * 时间复杂度 logN
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int arr[], int start, int end) {
        if (start < end) {
            int i = partition(arr, start, end);
            quickSort(arr, start, i - 1);
            quickSort(arr, i + 1, end);
        }

    }

    public static int partition(int arr[], int start, int end) {
        int p = arr[end];
        int i = start;
        for (int j = start; j <= end; j++) {
            if (arr[j] < p) {
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
}
