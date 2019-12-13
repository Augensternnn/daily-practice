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
    public ListNode removeElements2(ListNode head, int val) {
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

    public static void main(String[] args) {
        testReverseList();
        testRemoveElements();
    }
}
