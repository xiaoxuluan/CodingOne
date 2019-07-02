package coding.offer;

/**
 * @author luanaynxu
 *
 *         2018Äê11ÔÂ13ÈÕ
 */
public class Qiujiedian {

	public static class BinaryTreeNode {
		private int val;
		private BinaryTreeNode left;
		private BinaryTreeNode right;

		public BinaryTreeNode() {
		}

		public BinaryTreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "BinaryTreeNode [val=" + val + "]";
		}

	}

	public static void main(String[] args) {
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);
		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		BinaryTreeNode n6 = new BinaryTreeNode(6);
		BinaryTreeNode n7 = new BinaryTreeNode(7);
		BinaryTreeNode n8 = new BinaryTreeNode(8);
		BinaryTreeNode n9 = new BinaryTreeNode(9);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n4.right = n9;

		// print(n1);

	}

}
