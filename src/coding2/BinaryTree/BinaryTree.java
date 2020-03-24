package coding2.BinaryTree;

/**
 * @Author: alenlyx
 * @Date: 2019/7/19 16:58
 * @Version 1.0
 */
public class BinaryTree implements BinaryTreeMethod {

    private TreeNode root;

    @Override
    public TreeNode find(int key) {
        return null;
    }

    @Override
    public boolean insert(int data) {
        TreeNode treeNode = new TreeNode(data);
        if(root == null){
            root = treeNode;
            return  true;
        }

        TreeNode current = root;
        TreeNode parentNode = null;
        while (current != null){
            parentNode = current;
            if(current.data>data){
                current = current.leftChild;
                if(current == null){
                    parentNode.leftChild = treeNode;
                    return true;
                }
            }else{
                current = current.rightChild;
                if(current == null){
                    parentNode.rightChild = treeNode;
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void infixOrder(TreeNode current) {

        if(current != null){
            infixOrder(current.leftChild);
            System.out.print(current.data+" ");
            infixOrder(current.rightChild);
        }


    }

    @Override
    public void preOrder(TreeNode current) {

        if(current!=null){
            System.out.print(current.data+" ");
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }

    }

    @Override
    public void postOrder(TreeNode current) {
        if(current!=null){
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.print(current.getData()+" ");
        }

    }

    @Override
    public TreeNode findMax(TreeNode current) {
        return null;
    }

    @Override
    public TreeNode findMin(TreeNode current) {
        return null;
    }

    @Override
    public int getHeight(TreeNode current) {
        return 0;
    }

    @Override
    public int totalLeafs(TreeNode current) {
        return 0;
    }

    @Override
    public boolean delete(TreeNode current) {
        return false;
    }

    @Override
    public void printTreeNode(TreeNode current) {

    }

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(50);
        binaryTree.insert(20);
        binaryTree.insert(30);
        binaryTree.insert(90);
        binaryTree.insert(61);
        binaryTree.insert(100);
        binaryTree.insert(11);

        System.out.print("中序遍历结果 ");
        binaryTree.infixOrder(binaryTree.root);
        System.out.println("");
        System.out.print("前序遍历结果 ");
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        System.out.print("后序遍历结果 ");
        binaryTree.postOrder(binaryTree.root);
    }
}
