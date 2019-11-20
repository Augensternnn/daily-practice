/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
        next = null;
    }
}
public class AddTwoNumbers {
//    public Node addTwoNumbers(Node l1, Node l2){
//        Node newList = new Node(0);
//        Node p = l1, q =l2, cur = newList;
//        int tmp = 0;
//        while (p != null || q != null){
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = x + y + tmp;
//            tmp = sum / 10;
//            cur.next = new Node(sum % 10);
//            cur = cur.next;
//            if(p != null) p = p.next;
//            if(q != null) q = q.next;
//        }
//        if(tmp > 0)
//            cur.next = new Node(tmp);
//        return newList.next;
//    }

    public Node addTwoNumbers(Node l1, Node l2){
        Node newList = new Node(0);
        Node cur = newList;
        int tmp = 0;
        while (l1 != null || l2 != null){
            int x =(l1 != null) ? l1.val : 0;
            int y =(l2 != null) ? l2.val : 0;
            int sum = x + y + tmp;
            tmp = sum / 10;
            cur.next = new Node(sum % 10);
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
            cur.next = new Node(tmp);
        return newList.next;
    }
}
