package _.LeetCode.LinkedList;

/**
 * 2.两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class _2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newlist = new ListNode(0);
        ListNode cur = newlist;
        int tmp = 0;
        while (l1 != null || l2 != null){
            int x = (l1==null) ? 0 : l1.val;
            int y = (l2==null) ? 0 : l2.val;
            int sum = x + y + tmp;
            tmp = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            else
                l1 = null;
            if(l2 != null)
                l2 = l2.next;
            else
                l2 = null;
        }
        if(tmp > 0)
            cur.next = new ListNode(tmp);
        return newlist;
    }
}
