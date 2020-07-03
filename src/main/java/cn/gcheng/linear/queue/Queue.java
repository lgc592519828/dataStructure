/**
 * FileName: Queue
 * Author:   GuoCheng
 * Date:     2020/7/3 12:31
 * Description: 数组实现队列，先进先出表
 */
package cn.gcheng.linear.queue;

import java.util.Arrays;

public class Queue {

    /**
     * 底层数组来存储多个元素
     */
    Object [] elementData;
    /**
     * 存储的元素的个数，线性表的长度，注意，不是数组的长度
     */
    int size;

    public Queue() {
        this(2);
    }

    public Queue(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new RuntimeException("初始化长度<0");
        }
        // 为数组初始化分配空间
        elementData = new Object[initialCapacity];
    }

    public void add(Object o) {
        // 判断容量，不够扩容
        if (size == elementData.length) {
            grow();
        }
        // 添加元素
        elementData[size] = o;
        // size + 1
        size++;
    }

    private void grow() {
        // 扩容原2倍
        int newLength = elementData.length << 1;
        elementData = Arrays.copyOf(elementData, newLength);
    }

    /**
     * 获取队列头元素
     * @return
     */
    public Object peek() {
        if (size == 0) {
            throw new RuntimeException("队列为空，请先添加元素！");
        }
        Object o = elementData[0];
        elementData[0] = null;
        // 移动后面元素，利用空间，效率略低
        move();
        // size -1
        size--;
        return o;
    }

    private void move() {
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i + 1] != null) {
                elementData[i] = elementData[i + 1];
            } else {
                elementData[i] = null;
                break;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

}