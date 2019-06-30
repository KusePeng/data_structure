package practice.search.ex02;

import practice.sort.ex01.SortUtil;

import java.util.Arrays;

/**
 * @Description 二分的四种变形查找
 * @Created by XP
 * @Date 2019/6/30
 */
public class BinarySearch {

    /**
     * 查找第一个等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearchFindFirstOne(int arr[], int value) {
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (value < arr[mid]) {
                end = mid - 1;
            } else if (value > arr[mid]) {
                start = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != value) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearchFindLastOne(int arr[], int value) {
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (value < arr[mid]) {
                end = mid - 1;
            } else if (value > arr[mid]) {
                start = mid + 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != value) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearchFindFirstGEOne(int arr[], int value) {
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] >= value) {
                if (mid == 0 || arr[mid - 1] < value) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearchFindLastLEOne(int arr[], int value) {
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (value >= arr[mid]) {
                if (mid == arr.length - 1 || arr[mid + 1] > value) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 26, 26, 26, 33, 19, 6, 12, 14, 26, 45};
        System.out.println("---------待查找数组----------");
        SortUtil.quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach((x) -> System.out.print(x + " "));
        System.out.println();

        int value = 18;
        int firstIndex = binarySearchFindFirstOne(arr, value);
        System.out.println("第一个等于" + value + ":的元素下标" + firstIndex);

        int lastIndex = binarySearchFindLastOne(arr, value);
        System.out.println("最后一个等于" + value + ":的元素下标" + lastIndex);

        int firstGEIndex = binarySearchFindFirstGEOne(arr, value);
        System.out.println("第一个大于等于" + value + ":的元素下标" + firstGEIndex);

        int lastLEIndex = binarySearchFindLastLEOne(arr, value);
        System.out.println("最后一个小于等于" + value + ":的元素下标" + lastLEIndex);

    }

}
