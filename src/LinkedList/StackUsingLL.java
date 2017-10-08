package LinkedList;

public class StackUsingLL {
	//add a node at the head of the list then it becomes stack
	public static void main(String[] args) {
		LinkedList ll =new LinkedList();
		for(int i=7; i<12; i++)
			ll.insertAtHead(new Node(i));
		ll.printList(ll.root);
	}

}
