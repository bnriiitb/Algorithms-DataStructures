package BinaryTrees;
import BinarySearchTrees.Node;
import java.util.LinkedList;
import java.util.Queue;

import BinarySearchTrees.Node;

public class SearchInTree {
	static Node root;
	public static void main(String[] args) {
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
		System.out.println("\n"+searchBFS(root, 4));
		System.out.println(searchDFS(root, -9));
	}

	/* BFS */
	public static boolean searchBFS(Node n, int data) {
		if (null == n)
			return false;
		if (data == n.getData())
			return true;
		return searchBFS(n.getLeft(), data) || searchBFS(n.getRight(), data);
	}

	/* BFS */
	public static boolean searchDFS(Node n, int data) {
		Queue<Node> q = new LinkedList<>();
		q.offer(n);
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			if (tmp.getLeft() != null)
				q.offer(tmp.getLeft());
			if (tmp.getRight() != null)
				q.offer(tmp.getRight());
			if (tmp.getData() == data)
				return true;
		}
		return false;
	}

}
