package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

import BinarySearchTrees.Node;

public class FIndMaxElement {
	static Node root;

	/*
	 * Find the maximum element present in the Binary Search Tree this solution
	 * runs in O(n) and takes O(n) space.
	 */
	public static void main(String[] args) {
		Node.root = new Node(6);
		root = Node.root;
		root.insert(4);
		root.insert(9);
		root.insert(5);
		root.insert(3);
		root.insert(11);
		root.insert(7);
		System.out.print("InOrder: \n");
		root.inorder();
		System.out.println("\n" + search(root, 5));

	}

	/* Breadth First Search */
	public static int getMaxElement(Node n) {
		int maxVal = Integer.MIN_VALUE;
		if (n == null)
			return -1;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(n);
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			if (tmp.getLeft() != null) {
				q.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				q.offer(tmp.getRight());
			}
			if (maxVal < tmp.getData())
				maxVal = tmp.getData();
		}
		return maxVal;
	}
	/* Breadth First Search */
	public static boolean search(Node n, int k) {
		if (n == null)
			return false;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(n);
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			if (tmp.getLeft() != null) {
				q.offer(tmp.getLeft());
			}
			if (tmp.getRight() != null) {
				q.offer(tmp.getRight());
			}
			if (k == tmp.getData())
				return true;
		}
		return false;
	}
}
