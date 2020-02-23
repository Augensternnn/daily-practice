package test1130;

class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Plus {
   public ListNode plusAB(ListNode a, ListNode b) {
       ListNode newList = new ListNode(0);
       ListNode cur = newList;
       int tmp = 0;
       while (a != null || b != null){
           int x = (a != null) ? a.val : 0;
           int y = (b != null) ? b.val : 0;
           int sum = x + y + tmp;
           tmp = sum / 10;
           cur.next = new ListNode(sum % 10);
           cur = cur.next;
           if(a != null)
               a = a.next;
           else
               a = null;
           if(b != null)
               b = b.next;
           else
               b = null;
       }
       if (tmp > 0)
           cur.next = new ListNode(tmp);
       return newList.next;
   }
}
