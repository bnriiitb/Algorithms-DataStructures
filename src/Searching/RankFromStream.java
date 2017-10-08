package Searching;

import java.util.Scanner;

/**
 * @author Nagaraju Budigam
 *
 */
public class RankFromStream {
	/*
	 * Imagine you are reading in a stream of integers. Periodically you wish to
	 * be able to look up the rank of a number x(the number of values less than
	 * or equal to x). Implement the data structure and algorithm to support
	 * these operations. That is implement the method track(int x), which is
	 * called when each number is generated and the method getRankOfNumber(int
	 * x), which returns the number of values less than or equal to x(not
	 * including x itself).
	 * 
	 * Example: Stream (in order of appearance): 5,1,4,4,5,9,7,13,3
	 * getRankOfNumber(1)=0 getRankOfNumber(3)=1 getRankOfNumber(4)=3
	 */
	static int size = 8;

	public static void main(String[] args) {
		// getRankOfNumber_SimpleImpl_Driver();
		getRankOf_Driver();

	}

	/* Driver method for Simple Implementation of getRankOf */
	public static void getRankOfNumber_SimpleImpl_Driver() {
		Scanner in = new Scanner(System.in);
		int[] a = new int[20];
		for (int i = 0; i < 8; i++)
			if (i == 5)
				a[i] = i + 1;
			else if (i == 4)
				a[i] = i;
			else
				a[i] = i + 1;
		for (int x : a)
			System.out.print(x + " ");
		System.out.println();
		System.out.println(getIndexToInsert(a, 5));
		insert(a, 5);
		for (int x : a)
			System.out.print(x + " ");
		System.out.println();
		System.out.print("getRankOf: ");
		int n = in.nextInt();
		getRankOfNumber_SimpleImpl(a, n);
	}

	/* Driver method for getRankOf optimal Solution */
	public static void getRankOf_Driver() {
		Scanner in = new Scanner(System.in);
		int n;
		RankNode.root = new RankNode(6);
		RankNode root = RankNode.root;
		root.insert(4);
		root.insert(9);
		root.insert(5);
		root.insert(3);
		root.insert(11);
		root.insert(7);
		/*
		 * System.out.print("PreOrder: \n"); root.preOrder(root);
		 */
		System.out.print("\nInOrder: \n");
		root.inorder();
		/*
		 * System.out.print("\nPostOrder: \n"); root.postOrder(root);
		 */
		System.out.print("Enter the element to Search: ");
		n = in.nextInt();
		System.out.println("Searching for " + n + " found ? : " + root.getRankOf(n));

	}

	/*
	 * Simple solution is a customization of insertion sort and binary search,
	 * which runs in O(n) because we may have to perform n shift operations in
	 * the worst case when tried to insert a value x from stream and
	 * getRankOperations runs in O(log n) i.e we can perform Binary Search to
	 * get the rank of x.
	 */
	public static void getRankOfNumber_SimpleImpl(int[] a, int n) {
		System.out.println("The rank of " + n + " is: " + binarySearch(a, n));
	}

	/*
	 * This is method performs insertion of x which is coming stream and runs in
	 * O(n) as it requires n shifts in the worst case.
	 */
	public static void insert(int[] a, int n) {
		int i = getIndexToInsert(a, n);
		if (a[i] != 0) {
			for (int k = size; k > i; k--) {
				a[k] = a[k - 1];
			}
			a[i] = n;
			size++;
		}
	}
	/*
	 * This is the optimal solutions which runs in O(log n) time, that is
	 * getRank and insert methods works in O(log n)
	 */

	/*
	 * This is the customization of Binary Search to aids in getting the correct
	 * index to perform insertion of a number which comes from stream, runs in
	 * O(log n).
	 */
	public static int getIndexToInsert(int[] a, int n) {
		int left = 0, right = size - 1, mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (a[mid] > n)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;// the perfect index to insert the n
	}

	/* This is the standard binary Search Algorithm */
	public static int binarySearch(int[] a, int n) {
		int left = 0, right = size - 1, mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (a[mid] == n)
				return mid;
			else if (a[mid] > n)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}

}

/*
 * RankNode is a Binary Search Tree which support insertion and search in O(log
 * n)
 */
class RankNode {
	int leftSize;
	int data;
	RankNode left, right;

	public RankNode(int data) {
		this.data = data;
	}

	static RankNode root = null;

	public void insert(int data) {
		if (root == null) {
			root = new RankNode(data);
		} else if (this.data > data) {
			if (this.left == null) {
				this.left = new RankNode(data);
				this.leftSize++;
			} else {
				this.leftSize++;
				this.left.insert(data);
			}
		} else {
			if (this.right == null) {
				this.right = new RankNode(data);
			} else {
				this.right.insert(data);
			}
		}
	}

	public static void preOrder(RankNode n) {
		if (null != n) {
			System.out.print(n.data + " " + "leftSize: " + n.leftSize + "\n");
			preOrder(n.left);
			preOrder(n.right);
		}
	}

	public void inorder() {
		if (null != this) {
			if (null != this.left)
				this.left.inorder();
			System.out.print(this.data + " " + "leftSize: " + this.leftSize + "\n");
			if (null != this.right)
				this.right.inorder();
		}
	}

	public static void postOrder(RankNode n) {
		if (null != n) {
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(n.data + " " + "leftSize: " + n.leftSize + "\n");
		}
	}

	public int search(int x) {
		if (this == null)
			return -1;
		if (this.data == x)
			return 1;
		else if (this.data > x) {
			return null != this.left ? this.left.search(x) : -1;
		} else {
			return null != this.right ? this.right.search(x) : -1;
		}
	}

	public int getRankOf(int x) {
		if (this == null)
			return -1;
		if (this.data == x)
			return this.leftSize;
		else if (this.data > x) {
			return null != this.left ? this.left.getRankOf(x) : -1;
		} else {
			int right_rank=-1; 
			if(null!=this.right){
				right_rank=this.right.getRankOf(x);
			}
			return right_rank!=-1?this.leftSize+right_rank+1 : -1;
		}
	}

}
