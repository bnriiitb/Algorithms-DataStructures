package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import BinarySearchTrees.Node;

public class LevelOrderInReverse {
	static Node root;

	public static void main(String[] args) {
		Node.root = new Node(6);
		root = Node.root;
		root.insert(4);
		root.insert(9);
		root.insert(5);
		root.insert(3);
		root.insert(11);
		root.insert(7);
		root.levelOrder(root);
		System.out.println();
		levelOrderTraversalInReverse(root);
	}

	public static void levelOrderTraversalInReverse(Node n) {
		if (n == null)
			return;
		Queue<Node> q = new LinkedList<>();
		Stack<Node> s = new Stack<>();
		q.offer(n);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.getLeft() != null)
				q.offer(temp.getLeft());
			if (temp.getRight() != null)
				q.offer(temp.getRight());
			s.push(temp);
		}
		while (!s.isEmpty()) {
			System.out.print(s.pop().getData()+" ");
		}

	}

}
