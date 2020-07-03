/**
 * FileName: QueueTest
 * Author:   GuoCheng
 * Date:     2020/7/2 17:14
 * Description: 队列测试类
 */
package cn.gcheng.linear.app;

import cn.gcheng.linear.queue.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);

        System.out.println(q.size());
        System.out.println(q.empty());
        System.out.println(q.peek());
        System.out.println(q.size());
    }
}


