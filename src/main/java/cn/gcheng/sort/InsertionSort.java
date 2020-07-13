/**
 * FileName: InsertionSort
 * Author:   GuoCheng
 * Date:     2020/7/13 17:16
 * Description: 插入排序 ： 直接插入排序 ， 升级版的希尔排序
 */
package cn.gcheng.sort;

public class InsertionSort {

    /**
     * 直接插入排序，平均时间复杂度 O(n2)
     * @param array
     * @return
     */
    private static int[] insertionSort(int[] array) {
        if (array.length < 1) {
            return array;
        }
        for (int i = 0, length = array.length - 1; i < length; i++) {
            int currentArr = array[i + 1], preIndex = i;
            // 遍历已有顺序的数组，比较，当前元素比已有顺序的最后一个元素小，向后移动一位
            while (preIndex >= 0 && currentArr < array[preIndex]) {
                // 向后移动一位
                array[preIndex + 1] = array[preIndex];
                // preIndex-1
                preIndex--;
            }
            array[preIndex + 1] = currentArr;
        }
        return array;
    }

    /**
     * 希尔排序 又叫缩小增量排序，插入排序的升级版，添加增量概念， 不断缩小增量，减少循环次数。
     * 希尔排序是将待排序的数组元素 按下标的一定增量分组 ，分成多个子序列，然后对各个子序列进行直接插入排序算法排序；然后依次缩减增量再进行排序，直到增量为1时，进行最后一次直接插入排序，排序结束。
     * @param array
     * @return int[]
     */
    private static int[] ShellSort(int[] array) {
        if (array.length < 1) {
            return array;
        }
        int len = array.length;
        int temp;
        // 首次增量
        int h = len / 2;
        // 增量最后一位必须为1，做最后的调整。
        while (h > 0) {
            for (int i = h; i < len; i++) {
                //i:代表即将插入的元素角标，作为每一组比较数据的最后一个元素角标
                //j:代表与i同一组的数组元素角标
                for (int j = i - h; j >= 0; j -= h) {
                    // j + h 代表即将插入的元素所在的角标
                    if (array[j] > array[j + h]) {
                        // 插入元素（交换位置）
                        temp = array[j];
                        array[j] = array[j + h];
                        array[j + h] = temp;
                    }
                }
            }
            // 缩小增量，到最后为1
            h /= 2;
        }
        return array;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,15,24,53,23,54,76,98,34,65};
//        int[] result  = insertionSort(arr);
        int[] result  = ShellSort(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }




}