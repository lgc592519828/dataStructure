/**
 * FileName: SingleLinkedList
 * Author:   GuoCheng
 * Date:     2020/7/1 16:44
 * Description: 单链表实现线性表 模拟 LinkedList
 */
package cn.gcheng.linear.line;


public class SingleLinkedList implements List{

    /**
     * 头节点，不存数据
     */
    private Node head = new Node();
    /**
     * 节点数
     */
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        //和顺序表不一样,不能通过索引直接计算定位，而需要从头结点开始进行查找
        Node p = head;
        for (int j = 0; j <= i; j++) {
            p = p.next;
        }
        return p.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        return false;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public void add(int i, Object e) {
        if(i <0  || i> size){
            throw new IndexOutOfBoundsException("数组指针越界异常：" + i);
        }
        // 找到前一个结点，从head结点开始
        Node p = head;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        // 创建一个结点
        Node newNode = new Node(e);
        // 指明新结点的直接后继结点
        newNode.next= p.next;
        // 指明新结点的直接前驱结点
        p.next = newNode;
        // size + 1
        size++;
    }

    /**
     * 末位添加的一种方式
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
        if(i <0  || i> size){
            throw new IndexOutOfBoundsException("数组指针越界异常：" + i);
        }
        // 找到i的前驱节点
        Node p = head;
        Node item = null;
        for (int j = 0; j <= i; j++) {
            if (j == i) {
                item = p.next;
            } else {
                p = p.next;
            }
        }
        // 前驱节点的next指针替换成当前节点的next指针
        if (item != null) {
            p.next = item.next;
            item = null;
        } else {
            // item 是最后一个节点
            p.next = null;
            item = null;
        }
        // size -1
        size--;
        return null;
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