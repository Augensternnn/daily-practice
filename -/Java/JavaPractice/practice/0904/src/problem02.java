public class problem02 {
     // 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。要求：返回这个链表的深拷贝
    /*
    思路：
    1.普通复制不可以，因为没法处理 random 指向自己的结点
    2.无法在复制结点的同时处理 random，需要先复制结点，再处理 random
    3.......
     */
    public static class Node{
        int val;
        Node next;
        Node random;
     }
     static Node copy(Node head){
        Node p = head;
        while (p != null){
            Node q = new Node();
            q.val = p.val;

            q.next = p.next;
            p.next = q;

            p = q.next;
        }
        p = head;
        while (p != null){
            Node q = p.next;
            if(p.random != null){
                q.random = p.random.next;
            }
        }
     }
}
