import java.util.List;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int x){
        val = x;
    }

    public String toString(){
        return String.format("Node(%d)", val);
    }
}

class Solution{
    // 逆置 / 反转
    public ListNode reverseList(ListNode head){
        ListNode newList = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = newList;
            newList = cur;
            cur = next;
        }
        return newList;
    }
    public ListNode reverseList1(ListNode head){
        if(head == null)
            return null;
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
    public ListNode removeElements(ListNode head, int val){
        if(head == null)
            return null;
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
    public ListNode removeElements1(ListNode head, int val){
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
    public ListNode removeElements2(ListNode head, int val){
        ListNode newList = null;
        ListNode last = null;       //  记录 newList 最后一个结点
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            if(cur.val != val){
                // 把 cur 尾插到 newList
                if(newList == null){    // 第一次尾插时，newList 空链表
                    cur.next = newList;
                    newList = cur;
                }else {     // 以后尾插时，newList 不是空链表
                    last.next = next;
                }
                last = cur;     // 负责更新 last，保证 last 始终是最后一个结点
            }
            cur = next;
        }
        if(last != null){       // 处理 head == null 的情况
            last.next = null;   // 保证了最后一个结点的 next == null
        }
        return newList;
    }

    // 链表的中间结点
    public ListNode middleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null){
            fast = fast.next;
            if(fast == null)
                break;
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // 链表中倒数第 K 个结点
    public ListNode FindKthToTail(ListNode head,int k) {
        int len = 0;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            len++;
        }
        if(len < k)
            return null;
        int n = len - k;
        ListNode index = head;
        for(int i = 0; i < n; i++){
            index = index.next;
        }
        return index;
    }
    public ListNode FindKthToTail1(ListNode head,int k) {
        ListNode front = head;
        ListNode back = head;
        for(int i = 0; i < k; i++){
            if(front == null)
                return null;
            front = front.next;
        }
        while (front != null){
            front = front.next;
            back = back.next;
        }
        return back;
    }

    // 合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newList = null;
        ListNode last = null;
        while (cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                ListNode next = cur1.next;
                if(newList == null){
                    cur1.next = null;
                    newList = cur1;
                }else {
                    cur1.next = null;
                    last.next = cur1;
                }
                last = cur1;
                cur1 = next;
            }else {
                ListNode next = cur2.next;
                if(newList == null){
                    cur2.next = null;
                    newList = cur2;
                }else {
                    cur2.next = null;
                    last.next = cur2;
                }
                last = cur2;
                cur2 = next;
            }
        }
        if(cur1 != null){
            last.next = cur1;
        }else {
            last.next = cur2;
        }
        return newList;
    }
}

public class Topic {
    public static void display(ListNode head) {
        for (ListNode n = head; n != null; n = n.next) {
            System.out.print(n.val + " ");
        }
        System.out.println();
    }

    public static void testReverseList() {
        System.out.println("测试反转链表");
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;

        Solution s = new Solution();
        ListNode result = s.reverseList(n1);
        // 打印 result
        display(result);
    }

    public static void testRemoveElements() {
        System.out.println("测试删除元素");
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(6);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        Solution s = new Solution();
        ListNode result = s.removeElements(n1, 6);
        // 打印 result
        display(result);
    }

    public static void test1() {
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(6);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;

        Solution s = new Solution();
        ListNode result = s.removeElements(n1, 6);
    }

    public static void test2() {
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(6);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;

        Solution s = new Solution();
        ListNode result = s.removeElements(n1, 6);
    }

    public static void main(String[] args) {
        testReverseList();
        testRemoveElements();

        test1();
        test2();
    }
}
