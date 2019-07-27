package coding2.BinaryTree;

import coding.LinkedList.Node;

/**
 * @Author: luanyanxu
 * @Date: 2019/7/19 16:45
 * @Version 1.0
 */
public class TreeNode {

    int data;
    TreeNode leftChild;
    TreeNode rightChild;
    boolean isDelete;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode leftChild, TreeNode rightChild, boolean isDelete) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.isDelete = isDelete;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
