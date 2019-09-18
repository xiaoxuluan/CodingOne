package coding2.leetcode;

import coding2.BinaryTree.TreeNode;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/18 14:45
 * @Version 1.0
 */
public class Leetcode98 {

    public boolean helper(TreeNode node,Integer lower,Integer upper ){
        if(node == null){
            return true;
        }
        int val = node.getData();
        if(lower != null && val <= lower){
            return false;
        }
        if(upper != null && val >= upper){
            return false;
        }
        if(!helper(node.getRightChild(),val,upper)){
            return false;
        }
        if(!helper(node.getLeftChild(),lower,val)){
            return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root){
        return helper(root,null,null);
    }


}
