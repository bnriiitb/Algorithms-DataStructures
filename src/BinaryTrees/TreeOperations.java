package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

import BinarySearchTrees.Node;

public class TreeOperations {
	static Node root;
	public static void insert(Node n, int data) {
		if(n==null) root=new Node(data);
		else insertHelper(n,data);
	}

	private static void insertHelper(Node n, int data) {
		if(n.getData()>data){
			if(root.getLeft()==null)
				root.setLeft(new Node(data));
			else
				insert(n.getLeft(), data);
		}
		else{
			if(root.getRight()==null)
				root.setRight(new Node(data));
			else
				insert(n.getRight(), data);
		}
	}

	public static void delete(Node n) {

	}

	/*DFS pre-order based implementation */
	public static boolean DFSBasedSearch(Node n, int k) {
		if(n==null) return false;
		if(n.getData()==k) return true;
		return (DFSBasedSearch(n.getLeft(), k) || DFSBasedSearch(n.getRight(), k));
	}
	/*BFS level-order based implementation */
	public static boolean BFSBasedSearch(Node n, int k) {
		if(n==null) return false;
		if(n.getData()==k) return true;
		Queue<Node> q=new LinkedList<Node>();
		q.offer(n);
		while(!q.isEmpty()){
			Node temp=q.poll();
			if(temp.getData()==k) return true;
			if(temp.getLeft()!=null)q.offer(temp.getLeft());
			if(temp.getRight()!=null)q.offer(temp.getRight());
		}
		return false;
	}

	public static void preorder(Node n) {
		if (n == null)
			return;
		System.out.println(n.getData());
		preorder(n.getLeft());
		preorder(n.getRight());
	}

	public static void inorder(Node n) {
		if (n == null)
			return;
		preorder(n.getLeft());
		System.out.println(n.getData());
		preorder(n.getRight());
	}

	public static void postorder(Node n) {
		if (n == null)
			return;
		preorder(n.getLeft());
		preorder(n.getRight());
		System.out.println(n.getData());
	}

	public static void levelorder(Node n) {
		if (n == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(n);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (null != temp.getLeft())
				q.offer(temp.getLeft());
			if (null != temp.getRight())
				q.offer(temp.getRight());
			System.out.println(temp.getData());
		}
	}
	/*recursive implementation*/
	public static int getSize(Node n){
		if(n==null) return 0;
		int leftSize=n.getLeft()==null?0:getSize(n.getLeft());
		int rightSize=n.getRight()==null?0:getSize(n.getRight());
		return leftSize+rightSize+1;//+1 for including root
	}
	/*Iterative implementation: BFS*/
	public static int getSize_Iter(Node n){
		if(n==null) return 0;
		int c=0;
		Queue<Node> q=new LinkedList<>();
		q.offer(n);
		while(!q.isEmpty()){
			Node temp=q.poll();
			if(temp.getLeft()!=null)q.offer(temp.getLeft());
			if(temp.getRight()!=null)q.offer(temp.getRight());
			c++;
		}
		return c;
	}

}
