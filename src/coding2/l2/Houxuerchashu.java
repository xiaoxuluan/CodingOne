package coding2.l2;

import coding2.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: alenlyx
 * @Date: 2020/3/24 0:28
 * @Version 1.0
 */
public class Houxuerchashu {

    //时间复杂度 空间复杂度 O(N)
    public List<Integer> postOrderTree(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if(root == null){
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            output.addFirst(node.getData());

            if(node.getLeftChild() != null){
                stack.add(node.getLeftChild());
            }

            if (node.getRightChild() != null){
                stack.add(node.getRightChild());
            }
        }

        return output;
    }
}
