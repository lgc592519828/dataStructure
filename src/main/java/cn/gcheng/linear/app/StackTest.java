/**
 * FileName: StackTest
 * Author:   GuoCheng
 * Date:     2020/7/2 17:13
 * Description: 栈测试类
 */
package cn.gcheng.linear.app;

import cn.gcheng.linear.stack.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);

        System.out.println(s.size());
        System.out.println(s.empty());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.size());
    }

}