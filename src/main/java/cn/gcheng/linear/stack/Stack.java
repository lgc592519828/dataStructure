/**
 * FileName: Stack
 * Author:   GuoCheng
 * Date:     2020/7/3 12:10
 * Description: Stack 栈的实现 利用数组实现 , 后入先出表
 */
package cn.gcheng.linear.stack;

import java.util.Arrays;

public class Stack {

    /**
     * 底层数组来存储多个元素
     */
    Object [] elementData;
    /**
     * 存储的元素的个数，线性表的长度，注意，不是数组的长度
     */
    int size;

    public Stack() {
        this(2);
    }

    public Stack(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new RuntimeException("初始化长度<0");
        }
        // 为数组初始化分配空间
        elementData = new Object[initialCapacity];
    }

    public void push(Object o) {
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
        int newLength = elementData.length << 1;
        elementData = Arrays.copyOf(elementData, newLength);
    }

    /**
     * 返回元素， 与peek区别是删除元素，size -1
     * @return
     */
    public Object pop() {
        Object o = peek();
        // 取栈顶元素
        if (size > 0) {
            elementData[size - 1] = null;
            size--;
        }
        return o;
    }

    /**
     * 返回栈顶元素
     * @return Obj
     */
    public Object peek() {
        Object o = null;
        // 取栈顶元素
        if (size > 0) {
            o = elementData[size - 1];
        }
        return o;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size() == 0;
    }

}