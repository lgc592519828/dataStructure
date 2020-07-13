/**
 * FileName: BubbleSort
 * Author:   GuoCheng
 * Date:     2020/7/13 16:01
 * Description: 冒泡排序
 */
package cn.gcheng.sort;

public class BubbleSort {

    private static int[] bubbleSort(int[] array) {
        if (array.length < 1) {
            return array;
        }
        // 遍历整个数组
        for (int i = 0, length = array.length; i < length; i++) {
            // 遍历比较元素（除了i之前的，因为已经排序好了，不包括自己）
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    // 比较后一个元素比前面的小，交换
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,15,24,53,23,54,76,98,34,65};
        int[] result  = bubbleSort(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}