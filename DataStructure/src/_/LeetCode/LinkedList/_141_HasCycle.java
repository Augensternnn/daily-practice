package _.LeetCode.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 141.环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class _141_HasCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null){
            if(nodes.contains(head))
                return true;
            else
                nodes.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if(fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
