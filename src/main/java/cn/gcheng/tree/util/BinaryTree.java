/**
 * FileName: BinaryTree
 * Author:   GuoCheng
 * Date:     2020/7/8 15:51
 * Description: 二叉树接口，可以哟不同存储结构实现类
 */
package cn.gcheng.tree.util;

public interface BinaryTree {

    /**
     * 是否空树
     * @return
     */
    boolean isEmpty();
    /**
     * 树结点数量
     * @return
     */
    int size();

    /**
     * 获取二叉树的高度
     * @return
     */
    int getHeight();
    /**
     * 查询指定值的结点
     * @param value
     * @return
     */
    Node findKey(Object value); // 查找
    /**
     * 前序递归遍历
     */
    void preOrderTraverse();
    /**
     * 中序遍历递归操作
     */
    void inOrderTraverse();
    /**
     * 后序遍历递归操作
     */
    void postOrderTraverse();

    /**
     * 中序遍历非递归操作
     * 1）对于任意节点current，若该节点不为空则将该节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     * 2）若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current
     * 3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    void inOrderByStack();
    /**
     *   前序遍历非递归操作
     *   1）对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     *   2）若左子树为空，栈顶节点出栈，将该节点的右子树置为current
     *   3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    void preOrderByStack();
    /**
     * 后序遍历非递归操作
     * 1）对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     * 2）若左子树为空，取栈顶节点的右子树，如果右子树为空或右子树刚访问过，则访问该节点，并将preNode置为该节点
     * 3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    void postOrderByStack();

    /**
     * 按照层次遍历二叉树
     */
    void levelOrderByStack();
}
