class Node{
	public int val;
	public Node left = null;
	public Node right = null;
	
	Node(char val){
		this.val = val;
	}
}
public class isSameTree{
	//  判断两个树是否相同
	public static boolean isSameTree1(Node p,Node q){
		if(p == null && q = null){
			return true;
		}
		if(p == null || q = null){
			return false;
		}
		return p.val == q.val 
			&& isMirror1(p.left,q.left)
			&& isMirror1(p.right,q.right);
	}
}