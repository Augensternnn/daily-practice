class Node{
	public int val;
	public Node next;
	
	public Node(int val){
		this.val = val;
		this.next = null;
	}
}

public class LinkedList{
	// 打印
	public static void displayLinkedList(Node head){
		for(Node cur = head; cur != null; cur = cur.next){
			System.out.printf(" %d --> ",cur.val);
		}
		System.out.println("null");
	}
	
	// 头插
	public static Node pushFront(Node head,int val){
		Node newNode = new Node(val);
		newNode.next = head;
		return newNode;
	}
	
	// 尾插
	public static Node pushBack(Node head,int val){
		if(head == null){
			return pushFront(head,val);
		}else{
			Node newNode = new Node(val);
			Node last = getLast(head);
			last.next = newNode;
			return head;
		}
	}
	
	public static Node getLast(Node head){
		Node cur = head;
		while(cur.next != null){
			cur = cur.next;
		}
		return cur;
	}
	
	public static void main(String[] args){
		Node head = null;
		head = pushBack(head,1);
		head = pushBack(head,2);
		head = pushBack(head,3);
		displayLinkedList(head);
		
		//System.out.printf("%n");
		
		head = pushFront(head,10);
		head = pushFront(head,20);
		head = pushFront(head,30);
		displayLinkedList(head);
	}
}