package cn.gcheng.linear.util;

import java.util.Arrays;

/**
 * FileName: ArrayList 顺序表
 * Author:   GuoCheng
 * Date:     2020/7/1 15:32
 * Description: 模拟ArrayList接口
 */
public class ArrayList implements List {
    /**
     * 底层数组来存储多个元素
     */
    Object [] elementData;
    /**
     * 存储的元素的个数，线性表的长度，注意，不是数组的长度
     */
    int size;

    public ArrayList() {
        this(2);
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new RuntimeException("初始化长度<0");
        }
        // 为数组初始化分配空间
        elementData = new Object[initialCapacity];
        // 指定线性表初始元素个数,可以省略，int成员变量默认值0
        // size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if (i > size) {
            throw new IndexOutOfBoundsException("传入参数大于数组长度");
        }
        return elementData[i];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }

    /**
     * 返回e元素的位置
     * @param e e
     * @return int
     */
    @Override
    public int indexOf(Object e) {
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void add(int i, Object e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("添加位置有误");
        }
        // 数组满了，动态扩容
        if (size == elementData.length) {
            grow();
        }
        // 后移i及其后面的元素， 从最后一个开始
        for (int j = size; j > i; j--) {
            elementData[j] = elementData[j - 1];
        }
        // 给数组第i个位置赋值
        elementData[i] = e;
        // 元素个数+1
        size ++;
    }

    /**
     * 动态扩容
     */
    private void grow() {
        // 扩容到原来的2倍
        int newCapacity = elementData.length << 1;
        elementData =  Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 末位添加元素， 属于添加的一种特殊形式
     * @param e e
     */
    @Override
    public void add(Object e) {
        add(size, e);
    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        return false;
    }

    @Override
    public Object remove(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("删除的位置不正确");
        }
        // 记录这个元素返回用
        Object obj = elementData[i];
        // i元素清空
        elementData[i] = null;
        // i后面的元素一次向前移动
        for (int j = i; j < size - i; j++) {
            elementData[j] = elementData[j + 1];
        }
        // 元素size减1
        size --;
        return obj;
    }

    @Override
    public boolean remove(Object e) {
        return false;
    }

    @Override
    public Object replace(int i, Object e) {
        return null;
    }
}