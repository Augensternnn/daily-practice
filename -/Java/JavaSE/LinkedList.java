class Node{
	public int val;		//保存结点中的数据
	public Node next;		//指向下一个结点的引用【特殊值：null】
	
	public Node(int val){
		this.val = val;
		this.next = null;
	}
}

public class LinkedList {
	// 打印
	public static void displayLinkedList(Node head){
		//遍历一个列表
		for(Node cur = head; cur != null; cur = cur.next){
			System.out.printf("%d --> ",cur.val);
		}
		System.out.println("null");
	}
	
	public static Node createLinkedList(){
		Node n1 = new Node(1);		//首节点（头结点）
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		return n1;
	}
	
	// 头插
	public static Node pushFront(Node head,int val){
		// 1.申请新结点
		Node newNode = new Node(val);
		// 2.更新 newNode 的 next
		newNode.next = head;
		// 3.更新 head
		// head = newNode;     //做了没问题，但实际没有产生任何影响，通常不做
		
		return newNode;
	}
	
	// 尾插
	public static Node pushBack(Node head, int val){
		if(head == null){
			return pushFront(head,val);
		}else{
			// 1.申请新结点，并且让 next = null
			Node newNode = new Node(val);
			// 2.找到当前的最后一个结点
			Node last = getLast(head);
			// 3.让当前的最后一个结点的 next = newNode
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
	
	// 头删
	public static Node popFront(Node head){
		if(head == null){
			System.out.println("参数不合法，无法删除空链表的结点");
			return null;
		}
		return head.next;
	}
	
	// 尾删
	public static Node popBack(Node head){
		if(head == null){
			System.out.println("参数不合法，无法删除空链表的结点");
			return null;
		}
		
		if(head.next == null){
			// 链表中只有一个结点
			// 视为头删解决
			// 3. 释放原最后一个结点（GC 负责）
			return null;
		}else{
			// 1. 找倒数第二个结点
			Node lastLast = getLastLast(head);
			// 2. 让倒数第二个结点的 next = null
			lastLast.next = null;
			// 3. 释放原最后一个结点（GC 负责）
			return head;
		}
	}
	
	private static Node getLastLast(Node head) {
		Node node = head;
		while (node.next.next != null) {
			node = node.next;
		}
		return node;
	}
	
	public static void main(String[] args){
		Node head = createLinkedList();
		displayLinkedList(head);
		head = pushFront(head, 100);
		displayLinkedList(head);
		pushBack(head, 666);
		displayLinkedList(head);
		
		head = null;
		displayLinkedList(head);
		head = pushBack(head, 1);
		head = pushBack(head, 2);
		head = pushBack(head, 3);
		head = pushBack(head, 4);
		head = pushBack(head, 5);
		displayLinkedList(head);
		
		head = popFront(head);
		head = popFront(head);
		head = popFront(head);
		displayLinkedList(head);	// 4 --> 5 --> null
		head = popBack(head);
		displayLinkedList(head);	// 4 --> null
		head = popBack(head);
		displayLinkedList(head);	// null
	}
}