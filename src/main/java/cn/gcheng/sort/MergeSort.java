/**
 * FileName: MergeSort
 * Author:   GuoCheng
 * Date:     2020/7/14 16:34
 * Description: 归并排序
 */
package cn.gcheng.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,15,24,53,23,54,76,98,34,65};
        int[] result  = mergeSort(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] mergeSort(int[] array) {
        int start = 0;
        int end = array.length - 1;
        return mergeSort(array, start, end);
    }

    private static int[] mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        //当排序的数组区间有两个数时，对这两个数进行比较
        if ((end - start == 1)) {
            return sortS2B(array, start, end);
        }

        // 分左右区，拿到中间索引
        int mid = (start + end) / 2;
        // 进行分区递归
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);

        // 创建一个数组用于存放排好序的数组，大小就是区间大小
        int[] temp = new int[end - start + 1];
        // 表示辅助空间有多少个元素
        int length = 0;
        // 区分两个区间的索引，并且两个区间是有序的
        int i_start = start;
        int i_end = mid;
        int j_start = mid + 1;
        int j_end = end;

        while (i_start <= i_end && j_start <= j_end) {
            // 将小的数存到temp数组
            if (array[i_start] < array[j_start]) {
                // i区间第一个元素，比j区间第一个元素小，放到temp数组中
                temp[length] = array[i_start];
                // i区间向后移动一位
                i_start++;
                // temp后移一位
                length++;
            } else {
                // j区间第一个元素比i区间的小
                temp[length] = array[j_start];
                j_start++;
                length++;
            }
        }
        // 判断i去是否还有剩余元素，放在temp尾部
        while (i_start <= i_end) {
            temp[length] = array[i_start];
            i_start++;
            length++;
        }
        // 判断j去是否还有剩余元素，放在temp尾部
        while (j_start <= j_end) {
            temp[length] = array[j_start];
            j_start++;
            length++;
        }
        // 将temp数组copy到原数组array
        System.arraycopy(temp, 0, array, start, temp.length);

        return array;
    }

    private static int[] sortS2B(int[] array, int start, int end) {
        //start>end,进行交换
        if (array[start] > array[end]) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        return array;
    }
}