package LinkedList;

import java.util.Scanner;

public class NthNodeFromEnd {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		Node root=new Node(1);
		Node temp=root;
		for(int i=2; i<=10; i++){
			Node n = new Node(i);// create a new Node
			temp.next=n;			// add to the end of list
			temp=temp.next;		//increment temp pointer
		}
		temp=root;
		while(null!=temp){
			System.out.print(temp.data+"\t");
			temp=temp.next;
		}
		System.out.println();
		int n=in.nextInt();
		Node a=getNthNodeFromLast(root);//getNthNodeFromEnd(root, n);
		System.out.println(n+" th Node from end is : "+a.data);
			
			

	}
	public static Node getNthNodeFromEnd(Node root, int n){
		// create a gap of n Nodes between tempNode and nthNode
		Node tempNode=root,nthNode=root;
		for(int i=0; i<n; i++){
			if(tempNode!=null)
				tempNode=tempNode.next;
		}
		//now tempNode is n nodes away from nthNode
		while(tempNode!=null){
			tempNode=tempNode.next;//by the time tempNode reaches end
			if(null!=nthNode)		//nth Node will be n nodes away from end
				nthNode=nthNode.next;
		}
		return nthNode;
	}
	//recursive version of getting nthNode from end of Linked List
	public static Node getNthNodeFromLast(Node n){
		Node t=new Node(-1);
		while(null!=n){
			if(null==n.next)
				return n;
			else 
				return getNthNodeFromLast(n.next);
		}
		return t;
	}

}
