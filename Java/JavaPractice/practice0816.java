class Node{
	int val;
	Node next;
	
	Node(int val){
		this.val = val;
	}
}
class practice0816 {
	//合并两个有序链表
	public Node mergeTwoList(Node L1, Node L2){
		if(L1 == null){return L2;}
		if(L2 == null){return L1;}
		
		Node cur1 = L1;
		Node cur2 = L2;
		Node result = null;
		Node last = null;
		
		while(cur1 != null && cur2 != null){
			if(cur1.val <= cur2.val){
				Node next = cur1.next;
				if(result == null){
					cur1.next = result;
					result = cur1;
				}else{
					cur1.next = null;
					last.next = cur1;
				}
				last = cur1;
				cur1 = next;
			}else{
				Node next = cur2.next;
				if(result == null){
					cur2.next = result;
					result = cur2;
				}else{
					cur2.next = null;
					last.next = cur2;
				}
				last = cur2;
				cur2 = next;
			}		
		}
		if(cur1 != null){
			last.next = cur1;
		}else{
			last.next = cur2;
		}
		return result;
	}
}