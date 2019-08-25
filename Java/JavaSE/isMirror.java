class Node{
	public int val;
	public Node left = null;
	public Node right = null;
	
	Node(char val){
		this.val = val;
	}
}
public class isMirror{
	//  判断两个树是否镜像
	public static boolean isMirror1(Node p,Node q){
		if(p == null && q = null){
			return true;
		}
		if(p == null || q = null){
			return false;
		}
		return p.val == q.val 
			&& isMirror1(p.left,q.right)
			&& isMirror1(p.right,q.left);
	}
}