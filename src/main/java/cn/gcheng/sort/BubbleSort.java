/**
 * FileName: BubbleSort
 * Author:   GuoCheng
 * Date:     2020/7/13 16:01
 * Description:  交换排序： 冒泡排序 ， 快速排序
 */
package cn.gcheng.sort;

public class BubbleSort {

    /**
     * 冒泡排序
     * @param array
     * @return
     */
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

    /**
     * 快速排序。   分治+递归
     *      步骤1：从数列中挑出一个元素，称为 “基准”（pivot ）；
     *      步骤2：重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     *      步骤3：递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param array
     * @return
     */
    private static int[] QuickSort(int[] array) {
        int low = 0;
        int high = array.length - 1;
        return QuickSort(array, low, high);
    }

    private static int[] QuickSort(int[] array, int low, int high) {
        if (low < high) {
            // 分区操作，将一个数组分成两个区，返回分区界限索引
            int index = partition(array, low, high);
            // 递归 左右分区
            QuickSort(array, low, index - 1);
            QuickSort(array, index + 1, high);
        }
        return array;
    }

    private static int partition(int[] array, int low, int high) {
        // 将第一个作为基准值
        int baseVal = array[low];

        int i = low, j = high;
        while (i < j) {
            // 1.从右向左移动j，找到第一个小于基准值的值 arr[j]
            while (i < j && array[j] >= baseVal) {
                j--;
            }
            // 2.将右侧找到小于基准数的值加入到左边的i的位置， 左指针想中间移动一个位置i++
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            // 3.从左向右移动i，找到第一个大于等于基准值的值 arr[i]
            while (i < j && array[i] < baseVal) {
                i++;
            }
            // 4.将左侧找到的等于基准值的值加入到右边的j的位置，右指针向中间移动一个位置 j--
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        // 基准值放在最终位置, 此时指针i,j相同
        array[i] = baseVal;
        // 返回基准值的索引
        return i;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,15,24,53,23,54,76,98,34,65};
//        int[] result  = bubbleSort(arr);
        int[] result  = QuickSort(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}