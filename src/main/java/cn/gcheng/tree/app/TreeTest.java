/**
 * FileName: TreeTest
 * Author:   GuoCheng
 * Date:     2020/7/8 15:56
 * Description: 二叉树测试类
 */
package cn.gcheng.tree.app;

import cn.gcheng.tree.util.BinaryTree;
import cn.gcheng.tree.util.LinkedBinaryTree;
import cn.gcheng.tree.util.Node;

public class TreeTest {
    public static void main(String[] args) {
        //创建一个二叉树
        Node nodeJ = new Node('J', null, null);
        Node nodeI = new Node('I', null, null);
        Node nodeH = new Node('H', null, null);
        Node nodeG = new Node('G', null, null);
        Node nodeF = new Node('F', null, null);
        Node nodeE = new Node('E', nodeJ, null);
        Node nodeD = new Node('D', nodeH, nodeI);
        Node nodeC = new Node('C', nodeF, nodeG);
        Node nodeB = new Node('B', nodeD, nodeE);
        Node nodeA = new Node('A', nodeB, nodeC);


        BinaryTree btree = new LinkedBinaryTree(nodeA);

        //判断二叉树是否为空
        System.out.println(btree.isEmpty());

        //先序遍历递归 A、B、D、H、I、E、J、C、F、G
        System.out.println("先序遍历");
        btree.preOrderTraverse();
        System.out.println();

        //中序遍历递归  H、D、I、B、J、E、A、F、C、G
        System.out.println("中序遍历");
        btree.inOrderTraverse();
        System.out.println();

        //后序遍历递归  H、I、D、J、E、B、F、G、C、A
        System.out.println("后序遍历");
        btree.postOrderTraverse();
        System.out.println();


        //中序遍历非递归（借助栈） H、D、I、B、J、E、A、F、C、G
        System.out.println("中序遍历非递归（借助栈）");
        btree.inOrderByStack();
        System.out.println();

        //按照层次遍历（借助队列）
        System.out.println("按照层次遍历（借助队列）");
        btree.levelOrderByStack();
        System.out.println();

        //在二叉树中查找某个值
        System.out.println(btree.findKey('D'));

        //二叉树的高度
        System.out.println(btree.getHeight());

        //二叉树的结点数量
        System.out.println(btree.size());

    }
}