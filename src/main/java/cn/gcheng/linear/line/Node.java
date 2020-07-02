/**
 * FileName: Node
 * Author:   GuoCheng
 * Date:     2020/7/1 16:46
 * Description: 链表节点类
 */
package cn.gcheng.linear.line;

public class Node {
    /**
     * 存储数据
     */
    Object data;

    /**
     * 存储下一节点位置
     */
    Node next;
    public Node() {

    }

    public Node(Object data) {
        super();
        this.data = data;
    }
    public Node(Object data, Node next) {
        super();
        this.data = data;
        this.next = next;
    }
}