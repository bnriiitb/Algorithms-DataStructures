package BinarySearchTrees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
	/* Tree Traversals are broadly classified into 2 categories: 
	 * 1. Depth First Search
	 * 2. Breadth First Search
	 * 
	 * => PreOrder, InOrder and PostOrder Traversals are considered as Depth First Search Strategies
	 * => LevelOrder Traversal is considered as Breadth First Strategy
	 * */
	public static void preOrder(Node n) {
		if (n == null)
			return;
		System.out.println(n.getData());
		preOrder(n.getLeft());
		preOrder(n.getRight());
	}

	public static void inOrder(Node n) {
		if (n == null)
			return;
		preOrder(n.getLeft());
		System.out.println(n.getData());
		preOrder(n.getRight());
	}

	public static void postOrder(Node n) {
		if (n == null)
			return;
		preOrder(n.getLeft());
		preOrder(n.getRight());
		System.out.println(n.getData());
	}

	public static void levelOrder(Node n) {
		if (n == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			q.add(temp.getLeft());
			q.add(temp.getRight());
			System.out.println(temp.getData());
		}
	}

}
