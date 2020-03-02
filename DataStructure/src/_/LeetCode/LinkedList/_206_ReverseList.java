package _.LeetCode.LinkedList;

/**
 * 206.反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _206_ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null){
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    public static ListNode reverseList2(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
