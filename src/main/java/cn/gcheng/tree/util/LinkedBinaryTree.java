/**
 * FileName: LinkedBinaryTree
 * Author:   GuoCheng
 * Date:     2020/7/8 15:53
 * Description: 链式结构实现二叉树
 */
package cn.gcheng.tree.util;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LinkedBinaryTree implements BinaryTree {

    /**
     * 根节点
     */
    private Node root;

    public LinkedBinaryTree() {
        super();
    }

    public LinkedBinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return this.size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        // 递归左子树
        int nl = this.size(root.leftChild);
        // 递归右子树
        int nr = this.size(root.rightChild);
        // 左右子树和+1
        return nl + nr + 1;
    }

    @Override
    public int getHeight() {
        return this.getHeight(root);
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        // 递归左子树
        int nl = this.getHeight(root.leftChild);
        // 递归右子树
        int nr = this.getHeight(root.rightChild);
        // 左右子树比较，较大的高度+1，作为返回结果
        return nl > nr ? nl + 1 : nr + 1;
    }

    @Override
    public Node findKey(Object value) {
        return this.findKey(root, value);
    }

    private Node findKey(Node root, Object value) {
        if (root == null) {
            return null;
        } else if (root.value == value) {
            return root;
        } else {
            Node nodeL = this.findKey(root.leftChild, value);
            Node nodeR = this.findKey(root.rightChild, value);
            if (nodeL != null && nodeL.value == value) {
                return nodeL;
            } else if (nodeR != null && nodeR.value == value) {
                return nodeR;
            } else {
                return null;
            }
        }
    }

    @Override
    public void preOrderTraverse() {
        if (root != null) {
            // 输出根值
            System.out.print(root.value + " ");
            // 左子树
            new LinkedBinaryTree(root.leftChild).preOrderTraverse();
            // 右子树
            new LinkedBinaryTree(root.rightChild).preOrderTraverse();
        }
    }

    @Override
    public void inOrderTraverse() {
        if (root != null) {
            // 左子树
            new LinkedBinaryTree(root.leftChild).inOrderTraverse();
            // 输出根值
            System.out.print(root.value + " ");
            // 右子树
            new LinkedBinaryTree(root.rightChild).inOrderTraverse();
        }
    }

    @Override
    public void postOrderTraverse() {
        if (root != null) {
            // 左子树
            new LinkedBinaryTree(root.leftChild).postOrderTraverse();
            // 右子树
            new LinkedBinaryTree(root.rightChild).postOrderTraverse();
            // 输出根值
            System.out.print(root.value + " ");
        }
    }

    /**
     * 中序非递归遍历
     */
    @Override
    public void inOrderByStack() {
        // 创建栈
        Deque<Node> stack = new LinkedList<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            // 入栈所有左节点并输出左节点
            while (current != null) {
                stack.push(current);
                current= current.leftChild;
            }

            if (!stack.isEmpty()) {
                // 弹出最下端左节点
                current = stack.pop();
                System.out.print(current.value + " ");
                // 指向当前的右节点
                current = current.rightChild;
            }
        }
    }

    @Override
    public void preOrderByStack() {
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 获取栈顶元素
            Node current = stack.pop();
            System.out.print(current.value + " ");

            // 右子节点不为空，入栈
            if (current.rightChild != null) {
                stack.push(current.rightChild);
            }

            // 左子节点不为空，入栈
            if (current.leftChild != null) {
                stack.push(current.leftChild);
            }
        }
    }

    @Override
    public void postOrderByStack() {
        if (root == null) {
            return;
        }
        Deque<Node> s1 = new LinkedList<>();
        Deque<Node> s2 = new LinkedList<>();

        s1.push(root);
        Node curNode;
        while(!s1.isEmpty()) {
            curNode = s1.pop();
            // 中、右、左顺序压入栈中
            s2.push(curNode);

            // 压入s1为先左后右，保证中、右、左顺序压入s2中
            if (curNode.leftChild != null) {
                s1.push(curNode.leftChild);
            }
            if (curNode.rightChild != null) {
                s1.push(curNode.rightChild);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().value + " ");
        }
    }

    @Override
    public void levelOrderByStack() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node current = queue.poll();
                System.out.print(current.value + " ");
                if (current.leftChild != null) {
                    queue.add(current.leftChild);
                }
                if (current.rightChild != null) {
                    queue.add(current.rightChild);
                }
            }
        }
    }
}