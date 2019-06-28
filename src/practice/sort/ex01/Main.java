package practice.sort.ex01;

import java.util.Arrays;

/**
 * @author xp
 * @Describe 排序算法测试
 * @create 2019-06-24
 */
public class Main {

    public static void main(String[] args) {
        int[] arr ={1,4,26,33,19,6,12,14,45,26,13,49, 38, 65, 97, 76, 13, 27,-10,0, 50};
        System.out.println("----------冒泡排序----------");
        SortUtil.bubbleSort(arr);
        Arrays.stream(arr).forEach((x)-> System.out.print(x+" "));
        System.out.println("\n---------插入排序----------");
        SortUtil.insertSort(arr);
        Arrays.stream(arr).forEach((x)-> System.out.print(x+" "));
        System.out.println("\n---------选择排序----------");
        SortUtil.selectSort(arr);
        Arrays.stream(arr).forEach((x)-> System.out.print(x+" "));
        System.out.println("\n---------归并排序----------");
        SortUtil.mergerSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach((x)-> System.out.print(x+" "));
        System.out.println("\n---------快速排序----------");
        SortUtil.quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach((x)-> System.out.print(x+" "));
    }


}
