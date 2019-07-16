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

    //������������
    public int height(Node node){
        if(node==null){
            return 0;
        }else{
            int m = height(node.getLeftNode());
            int n = height(node.getRightNode());
            //System.out.println(Math.max(m,n)+1);
            return Math.max(m,n)+1;
        }
    }

    //�����нڵ���
    public  int totalNode(Node node){
        if(node  == null){
            return 0;
        }

        int m = totalNode(node.getLeftNode());
        int n = totalNode(node.getRightNode());
        return  m+n+1;
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

        System.out.println(tree.height(root));

        System.out.println(tree.totalNode(root));
    }  
}
