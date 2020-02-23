class Node{
	int val;
	int node;
	
	public Node(int val){
		this.val = val;
	}
}

public class practice0817_1 {
	// 用 x 分割链表，小于 x 的在前面、大于 x 的在后面 
	public Node divisionList(Node head,int x){
		Node small = null;
		Node smallLast = null;
		Node big = null;
		Node bigLast = null;
		
		for(Node cur = head; cur != null; cur = cur.next){
			if(cur.val < x）{
				if(small == null){
					small = cur;
				}else{
					cur.next = smallLast.next = cur;
				}
				smallLast = cur;
			}
		}
		
	}
}