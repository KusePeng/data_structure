package practice.search.ex01;

import practice.sort.ex01.SortUtil;

import java.util.Arrays;

/**
 * @Description 二分查找,数据不重复的有序数组
 * @Created by XP
 * @Date 2019/6/30
 */
public class BinarySearch {


    public static int binarySearch(int arr[],int value){
        int start=0;
        int end=arr.length;
        while(start<=end){
            int mid = start+((end-start)>>1);
            if(value==arr[mid]){
                return mid;
            }else if(value>arr[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr ={1,4,26,33,19,6,12,14,45};
        System.out.println("---------待查找数组----------");
        SortUtil.quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach((x)-> System.out.print(x+" "));
        System.out.println();

        int index = binarySearch(arr, 4);
        System.out.println(index);
    }

}
