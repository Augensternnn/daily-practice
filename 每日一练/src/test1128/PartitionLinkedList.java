package test1128;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class PartitionLinkedList {
    public static ListNode partition(ListNode pHead, int x) {
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode max = null;
        ListNode maxHead = null;
        ListNode min = null;
        ListNode minHead = null;
        for(ListNode cur = pHead; cur.next != null; cur = cur.next){
            if(cur.val >= x) {
                max.next = cur;
                max = max.next;
            }else{
                min.next = cur;
                min = min.next;
            }
        }
        while (min.next != null){
            min = min.next;
        }
        min.next = max.next;
        return min.next;
    }
}
