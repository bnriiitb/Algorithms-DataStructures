package BinarySearchTrees;

public class BinarySearchTree {
	static Node root;
	public static void main(String[] args){
		Node.root= new Node(6);
		root = Node.root;
		root.insert(4);
		root.insert(9);
		root.insert(5);
		root.insert(3);
		root.insert(11);
		root.insert(7);
		System.out.print("InOrder: \n");
		root.inorder();
		/*System.out.print("Level Order: \n");
		root.levelOrder(root);*/
		System.out.println("\nMin Element: "+FindMaxandMinElements.getMin(root));
		System.out.println("Max Element: "+FindMaxandMinElements.getMax(root));
	}
	public static void insert_driver(){
		Node.root= new Node(6);
		root = Node.root;
		root.insert(4);
		root.insert(9);
		root.insert(5);
		root.insert(3);
		root.insert(11);
		root.insert(7);
	}
	public static void inOrder(Node n) {
		if (n == null)
			return;
		inOrder(n.getLeft());
		System.out.print(n.getData() + " ");
		inOrder(n.getRight());
	}
}
