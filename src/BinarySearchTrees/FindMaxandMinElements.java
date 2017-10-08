package BinarySearchTrees;

public class FindMaxandMinElements {
/*Find the maximum and minimum elements in a BST*/
	public static void main(String[] args) {

	}
	public static int getMin(Node n){
		if(n==null) return -1;
		while(n.getLeft()!=null){
			n=n.getLeft();
		}
		return n.getData();
	}
	public static int getMax(Node n){
		if(n==null) return -1;
		while(n.getRight()!=null){
			n=n.getRight();
		}
		return n.getData();
	}

}
