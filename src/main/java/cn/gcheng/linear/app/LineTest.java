package cn.gcheng.linear.app;

import cn.gcheng.linear.line.ArrayList;
import cn.gcheng.linear.line.List;
import cn.gcheng.linear.line.SingleLinkedList;

/**
 *  线性表测试类
 * */
public class LineTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(123);
        list.add(321);
        list.add(456);
        list.add(678);
        list.add(789);
        list.add(111);
        list.add(222);

        list.remove(3);

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(3));

        List linkedList = new SingleLinkedList();
        linkedList.add(123);
        linkedList.add(321);
        linkedList.add(456);
        linkedList.add(678);
        linkedList.add(789);
        linkedList.add(111);
        linkedList.add(222);

        linkedList.remove(6);

        System.out.println(linkedList.size());
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.get(5));

    }

}