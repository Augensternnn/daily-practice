class ListNode{
    int val;
    ListNode next;
    public ListNode(int x){
        val = x;
    }
}

class Solution{
    // 逆置/反转
    public ListNode reverseList(ListNode head) {
        ListNode newList = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            // 头插
            cur.next = newList;
            newList = cur;
            // 让 cur 往后遍历
            cur = next;
        }
        return newList;
    }
    public ListNode reverseList1(ListNode head) {
        ListNode n1 = null;
        ListNode n2 = head;
        while (n2 != null){
            ListNode n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        return n1;
    }
    public ListNode reverseList2(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode n1 = null;
        ListNode n2 = head;
        ListNode n3 = head.next;
        while (n2 != null){
            n2.next = n1;
            n1 = n2;
            n2 = n3;
            if(n3 != null)
                n3 = n3.next;
        }
        return n1;
    }

    // 删除指定val
    /*
    1. 对于链表，要删除 cur ，需要 cur 的前驱结点 prev
    2. 当第一个结点就需要删除：
        1）先不管第一个结点，把后边需要删除的删除完再处理第一个结点
        2）创建一个结点，让结点的 .next = 原来第一个结点
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode cur = head.next;
        ListNode prev = head;
        while (cur != null){
            if(cur.val == val)
                prev.next = cur.next;
            else
                prev = cur;
            cur = cur.next;
        }
        if(head.val == val)
            head = head.next;
        return head;
    }
    public ListNode removeElements1(ListNode head, int val) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode cur = head;
        while (cur != null){
            if(cur.val == val)
                prev.next = cur.next;
            else
                prev = cur;
            cur = cur.next;
        }
        return fakeHead.next;
    }

}
public class Topic {

}
