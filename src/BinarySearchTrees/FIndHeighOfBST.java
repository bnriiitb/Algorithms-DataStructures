package BinarySearchTrees;
/*Height of a Node in a Tree: The lo*/
public class FIndHeighOfBST {
	static Node root;
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
	public static void main(String[] args){
		insert_driver();
		inOrder(root);
		//System.out.println("\n"+getHeight(root));
		System.out.println();
		topView(root);
	}
	public static void inOrder(Node n) {
		if (n == null)
			return;
		inOrder(n.getLeft());
		System.out.print(n.getData() + " ");
		inOrder(n.getRight());
	}
	public static void customizedInorder(Node n) {
		if (n == null)
			return;
		customizedInorder(n.getLeft());
		System.out.print(n.getData() + " ");
	}
	public static void customizedInorder2(Node n) {
		if (n == null)
			return;
		System.out.print(n.getData() + " ");
		customizedInorder2(n.getRight());
		
	}
	public static int getHeight(Node n){
		if(n==null) return -1;// height of empty tree is -1
		int leftHeight=getHeight(n.getLeft());
		int rightHeight=getHeight(n.getRight());
		return Math.max(leftHeight, rightHeight)+1;
		//there is an edge which connects with it's children that's why +1 
	}
	public static void topView(Node n){
		if(null==n) return;
		customizedInorder(n);
		customizedInorder2(n.getRight());
	}

}
