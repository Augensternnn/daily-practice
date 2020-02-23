class Node{
    public int value;       // 保存结点中的数据
    public Node next;        // 指向下一个结点的引用，特殊值null
    public Node(int value){
        this.value = value;
        this.next = null;
    }
}

public class LinkedList {
    public static void display(Node head){
        for (Node cur = head; cur != null; cur = cur.next){
            System.out.printf("%d --> ",cur.value);
        }
        System.out.println("null");
    }
    public static Node createLinkedList() {
        Node n1 = new Node(1);	// 首结点（头结点）
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

    public static Node pushFront(Node head, int val){
        Node newNode = new Node(val);
        newNode.next = head;
        // 更新head
//        head = newNode;     // 做了没问题，但实际没有产生任何影响，通常不做
        return  newNode;
    }
    public static Node pushBack(Node head, int val){
        if(head == null){
            // 对空链表尾插
            return pushFront(head, val);
        }else {
            // 对非空链表尾插
            Node newNode = new Node(val);
            Node last = getLast(head);
            last.next = newNode;
            return head;
        }

        /*
        Node node = new Node(value);
        if(head == null){
            node.next = head;
            return node;
        }else {
            Node last = getLast(head);
            last.next = node;
            return head;
        }
         */
    }
    private static Node getLast(Node head){
        Node last = head;
        while (last.next != null){
            last = last.next;
        }
        return last;
    }
    public static Node popFront(Node head){
        if(head == null){
            System.out.println("参数不合法，无法删除空链表的结点");
            return null;
        }
        return head.next;
    }
    public static Node popBack(Node head){
        if(head == null){
            System.out.println("参数不合法，无法删除空链表结点");
            return null;
        }
        if(head.next == null){
            // 链表中只有一个结点，视为头删解决
            // 释放原最后一个结点（GC会负责）
            return null;
        }else {
            Node lastLast = getLastLast(head);
            lastLast.next = null;
            // 释放原最后一个结点（GC会负责）
            return head;
        }
    }
    public static Node popBack1(Node head){
        if(head == null || head.next == null)
            return null;
        Node cur = head;
        while (cur.next.next != null){
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
    public static Node getLastLast(Node head){
        Node cur = head;
        while (cur.next.next != null){
            cur = cur.next;
        }
        return cur;
    }

    public static void main(String[] args) {
        Node head = createLinkedList();
        display(head);
        head = pushFront(head, 100);
        display(head);
        pushBack(head, 666);
        display(head);



        head = null;
        display(head);
        head = pushBack(head, 1);
        head = pushBack(head, 2);
        head = pushBack(head, 3);
        head = pushBack(head, 4);
        head = pushBack(head, 5);
        display(head);

        head = popFront(head);
        head = popFront(head);
        head = popFront(head);
        display(head);	// 4 --> 5 --> null
        head = popBack(head);
        display(head);	// 4 --> null
        head = popBack(head);
        display(head);	// null
    }
}
