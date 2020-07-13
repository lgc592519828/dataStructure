/**
 * FileName: SelectionSort
 * Author:   GuoCheng
 * Date:     2020/7/13 16:26
 * Description: 选择排序
 */
package cn.gcheng.sort;

public class SelectionSort {

    /**
     * 选择排序。 实际上可以理解成升级冒泡排序，找到最小元素只交换一次
     * @param arr
     * @return
     */
    private static int[] selectionSort(int[] arr) {
        if (arr.length < 1) {
            return arr;
        }
        // 循环所有元素
        for (int i = 0, length = arr.length; i < length; i++) {
            // 第二遍循环并找到最小元素索引, 循环外交换一次
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (arr[minIndex] > arr[j]) {
                    // 记录索引
                    minIndex = j;
                }
            }
            // 交换元素
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,15,24,53,23,54,76,98,34,65};
        int[] result  = selectionSort(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}