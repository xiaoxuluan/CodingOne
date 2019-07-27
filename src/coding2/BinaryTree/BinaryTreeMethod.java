package coding2.BinaryTree;

/**
 * @Author: luanyanxu
 * @Date: 2019/7/19 16:53
 * @Version 1.0
 */
public interface BinaryTreeMethod {

     TreeNode find(int key);

     boolean insert(int data);

     void infixOrder(TreeNode current);

     void preOrder(TreeNode current);

     void postOrder(TreeNode current);

     TreeNode findMax(TreeNode current);

     TreeNode findMin(TreeNode current);

     int getHeight(TreeNode current);

     int totalLeafs(TreeNode current);

     boolean delete(TreeNode current);

     void printTreeNode(TreeNode current);


}
