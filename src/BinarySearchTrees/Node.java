package BinarySearchTrees;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Node {
	int leftSize;
	private int data;
	private Node left;
	private Node right;

	public Node(int data) {
		this.setData(data);
	}

	public static Node root = null;

	public void insert(int data) {
		if (root == null) {
			root = new Node(data);
		} else if (this.getData() > data) {
			if (this.getLeft() == null) {
				this.setLeft(new Node(data));
			} else {
				this.getLeft().insert(data);
			}
		} else {
			if (this.getRight() == null) {
				this.setRight(new Node(data));
			} else {
				this.getRight().insert(data);
			}
		}
	}

	public static void preOrder(Node n) {
		if (null != n) {
			System.out.print(n.getData() + " ");
			preOrder(n.getLeft());
			preOrder(n.getRight());
		}
	}

	public void inorder() {
		if (null != this) {
			if (null != this.getLeft())
				this.getLeft().inorder();
			System.out.print(this.getData() + " ");
			if (null != this.getRight())
				this.getRight().inorder();
		}
	}

	public static void postOrder(Node n) {
		if (null != n) {
			postOrder(n.getLeft());
			postOrder(n.getRight());
			System.out.print(n.getData() + " ");
		}
	}
	public static void levelOrder(Node n) {
		if(null==n) return;
		Queue<Node> q=new LinkedBlockingDeque<>();
		q.add(n);
		while(!q.isEmpty()){
			if(null!=q.peek().getLeft())
				q.add(q.peek().getLeft());
			if(null!=q.peek().getRight())
				q.add(q.peek().getRight());
			System.out.print(q.poll().getData()+" ");
		}
	}
	
	public int search(int x) {
		if (this == null)
			return -1;
		if (this.getData() == x)
			return 1;
		else if (this.getData() > x) {
			return null != this.getLeft() ? this.getLeft().search(x) : -1;
		} else {
			return null != this.getRight() ? this.getRight().search(x) : -1;
		}
	}

	public int getRankOf(int x) {
		if (this == null)
			return -1;
		if (this.getData() == x)
			return this.leftSize;
		else if (this.getData() > x) {
			return null != this.getLeft() ? this.getLeft().getRankOf(x) : -1;
		} else {
			int right_rank = -1;
			if (null != this.getRight()) {
				right_rank = this.getRight().getRankOf(x);
			}
			return right_rank != -1 ? this.leftSize + right_rank + 1 : -1;
		}
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
