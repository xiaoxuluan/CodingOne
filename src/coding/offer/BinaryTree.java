package coding.offer;

public class BinaryTree {  
    /** 
     * @author yaobo
     * ����������������������� 
     */  
    public Node init() {//ע��������������Ƚ����ӽڵ㣬���������Ͻ�������Ϊ��Ҷ�ӽ���ʹ�õ�����Ľڵ㣬����ʼ���ǰ�˳���ʼ���ģ����������ᱨ��  
        Node J = new Node(8, null, null);  
        Node H = new Node(4, null, null);  
        Node G = new Node(2, null, null);  
        Node F = new Node(7, null, J);  
        Node E = new Node(5, H, null);  
        Node D = new Node(1, null, G);  
        Node C = new Node(9, F, null);  
        Node B = new Node(3, D, E);  
        Node A = new Node(6, B, C);
        return A;   //���ظ��ڵ�  
    }
    
    public void printNode(Node node){  
        System.out.print(node.getData());  
    }  
    public void theFirstTraversal(Node root) {  //�������  
        printNode(root);  
        if (root.getLeftNode() != null) {  //ʹ�õݹ���б�������  
            theFirstTraversal(root.getLeftNode());  
        }  
        if (root.getRightNode() != null) {  //�ݹ�����Һ���  
            theFirstTraversal(root.getRightNode());  
        }  
    }  
    public void theInOrderTraversal(Node root) {  //�������  
        if (root.getLeftNode() != null) {  
            theInOrderTraversal(root.getLeftNode());  
        }  
        printNode(root);  
        if (root.getRightNode() != null) {  
            theInOrderTraversal(root.getRightNode());  
        }  
    }
    
    
    public void thePostOrderTraversal(Node root) {  //�������  
        if (root.getLeftNode() != null) {  
            thePostOrderTraversal(root.getLeftNode());  
        }  
        if(root.getRightNode() != null) {  
            thePostOrderTraversal(root.getRightNode());  
        }  
        printNode(root);  
    }  
      
   
    	
    	
    
    public static void main(String[] args) {  
        BinaryTree tree = new BinaryTree();  
       
        Node root = tree.init();  
        System.out.println("�������");  
        tree.theFirstTraversal(root);  
        System.out.println("");  
        System.out.println("�������");  
        tree.theInOrderTraversal(root);  
        System.out.println("");  
        System.out.println("�������");  
        tree.thePostOrderTraversal(root);  
        System.out.println("");
    }  
}
