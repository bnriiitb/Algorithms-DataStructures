package LinkedList;

public class LinkedList {
	static Node root=new Node(0);

	public static void main(String[] args) {
		Node n=root;
		for(int i=1; i<10; i++){
			insertAtHead(new Node(i));//inserting at head linked list
			//insertAtTail(new Node(i));//inserting at tail of linked list
			
		}
		printList(root);
		reverse(root);
		/*for(int i=0; i<10; i++){
			if(i%3==0)
			deleteAt(0);
			else if(i%4==0)
				deleteAt(-1);
			else
				deleteAt(i%2);
			printList(root);
		}*/
		/*for(int i=1; i*2<10; i++){
			System.out.println("Inserting at "+(2*i));
			insertAt(i*2, new Node(i*-2));
			printList(root);
		}*/
	}
	public static void insertAtHead(Node n){
		n.next=root;
		root=n;
	}
	public static void insertAtTail(Node n){
		Node temp=root; Node t=root;
		while(null!=temp && null!=temp.next){
			temp=temp.next;
		}
		temp.next=n;
	}
	public static void deleteAt(int i){
		if(i==0){// delete the head node
			System.out.println("Deleting at head");
			root=root.next;
		}
		else if(i==-1){// delete the last Node
			System.out.println("Deleting at tail");
			Node temp=root;
			while(null!=temp && null!=temp.next && null!=temp.next.next){
				temp=temp.next;
			}
			temp.next=null;
		}
		else{
			System.out.println("Deleting at "+i);
			Node temp=root,prev=root;
			while(null!=temp && i>0){
				prev=temp;
				temp=temp.next;
				i--;
			}
			prev.next=temp.next;
		}
	}
	public static void insertAt(int i, Node node){
		Node temp=root;
		while(null!=temp && i>0){
			temp=temp.next;
			i--;
		}
		Node n=temp.next;
		temp.next=node;
		node.next=n;
	}
	public static void printList(Node n){
		while(null!=n){
			System.out.print("["+n.data+"] --> ");
			n=n.next;
		}
		System.out.print("NULL\n");
	}
	public static void reverse(Node n){
		if(null==n)
			return;
		else
			reverse(n.next);
		System.out.print(n.data+"--> ");
		
	}

}
