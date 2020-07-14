/**
 * FileName: HeapSort
 * Author:   GuoCheng
 * Date:     2020/7/14 18:11
 * Description: 堆排序
 */
package cn.gcheng.sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,15,24,53,23,54,76,98,34,65};
        int[] result  = heapSort(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /**
     * https://blog.csdn.net/u010452388/article/details/81283998  原理过程很详细
     * 堆排序是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
     *      1。构建成大顶堆
     *      2.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]
     *      3.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成
     * @param array array
     * @return array
     */
    private static int[] heapSort(int[] array) {
        int len = array.length;
        return heapSort(array, len);
    }

    private static int[] heapSort(int[] array, int len) {
        // 初始化堆
        // arr[len] 是最后一个叶子节点， 父节点是 (len-1)/2
        // i--: 第一次循环 i是最后一叶子节点的父节点，也就是说明在数组中i节点直接的都是父节点。
        for (int i = (len - 1) / 2; i >= 0; i--) {
            BuildMaxHeap(array, i, len);
        }

        // 交换堆顶元素和最后一个元素(完全二叉树的最后一个元素，一定在数组的尾部)
        for (int i = len - 1; i >= 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // 1. 根节点元素与最后一个元素交换后，判断新根节点与子节点的大小，建立大顶堆，元素个数-1(除去已经在最后一个节点的最大数)
            BuildMaxHeap(array, 0, i);
        }
        return array;
    }

    /**
     * 构建大顶堆
     * @param array array
     * @param i 待调整的结点的下标
     * @param len len
     * @return
     */
    private static int[] BuildMaxHeap(int[] array, int i, int len) {
        // 调整i位置的结点
        // 假定i所在的值是最大的，保存当前结点的下标
        int max = i;
        // 根据完全二叉树特性来计算左右孩子索引
        // 当前结点左右孩子结点的下标
        int lChild = 2 * i + 1;
        int rChild = 2 * i + 2;

        // 判断左孩子值大于父节点的值，记录最大值索引。 为了保持父节点值最大
        if (lChild < len && array[lChild] > array[max]) {
            max = lChild;
        }
        // 判断右孩子值大于父节点的值，交换。 保持父节点值最大
        if (rChild < len && array[rChild] > array[max]) {
            max = rChild;
        }

        // max是最大值的索引，若i != max ,说明子节点值大于i父节点的值, 进行交换。 保证父节点值最大
        if (max != i) {
            // 交换值
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
            // 递归, 建立父节点最大的树, 即大顶堆
            BuildMaxHeap(array, max, len);
        }
        return array;
    }
}