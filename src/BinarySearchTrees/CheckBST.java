package BinarySearchTrees;

public class CheckBST {

	/* Check whether the given tree is a BST or not */

	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();
		b.insert_driver();
		inOrder(b.root);
		System.out.println(isBST(b.root, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}

	/* The runtime complexity of this solution is O(n) */
	public static boolean isBST(Node n, int MIN_VAL, int MAX_VAL) {
		if (n == null)
			return true;
		/*
		 * Data of left subtree must be less than the data of root and Data of
		 * right subtree must be greater than the date of root
		 */
		if (n.getData() > MIN_VAL && n.getData() < MAX_VAL)
			return false;
		return (isBST(n.getLeft(), MIN_VAL, n.getData()) 
				&& isBST(n.getRight(), n.getData(), MAX_VAL));

	}

	public static void inOrder(Node n) {
		if (n == null)
			return;
		inOrder(n.getLeft());
		System.out.print(n.getData() + " ");
		inOrder(n.getRight());
	}

}
