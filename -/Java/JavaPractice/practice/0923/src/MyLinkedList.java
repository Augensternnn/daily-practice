/*
​实现一个链表类
头插 + 尾插 + 头删 + 尾删        时间复杂度O(1):双向链表
 */
public class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node prev;
        Node(int val){
            this.val = val;
        }
    }

    Node first = null;     // 指向链表的第一个结点，如果链表中没结点，则 == null
    Node last = null;      // 指向链表的最后一个结点，如果链表中没结点，则 == null

    // 头插
    void addFirst(int val){
        Node node = new Node(val);
        node.next = first;
        if(first != null) {
            first.prev = node;
        }else {
            last = node;
        }
        first = node;
    }

    // 尾插
    void addLast(int val){
        Node node = new Node(val);
        node.prev = last;
        if(last != null){
            last.next = node;
        }else {
            first = node;
        }
        last = node;
    }

    // 头删
    int pollFirst() throws Exception{
        if(first == null){
            throw new Exception("空的链表");
        }
        Node oldFirst = first;
        first = first.next;
        if(first == null) {
            last = null;
        }else{
            first.prev = null;
        }
        return oldFirst.val;
    }

    // 尾删
    int pollLast() throws Exception{
        if(last == null){
            throw new Exception("空的链表");
        }
        Node oldLast = last;
        last = last.prev;
        if(last == null){
            first = null;
        }else {
            last.next = null;
        }
        return oldLast.val;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addFirst(1);   // 空的头插
        list.addFirst(2);   // 非空头插
        list.addLast(3);    // 非空尾插
        list.pollFirst();
    }
}
