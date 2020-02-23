class Node{
	public int value;
	public Node left = null;
	public Node right = null;
	
	Node(int value){
		this.value = value;
	}
}
//  计算二叉树的结点个数
public class calcTreesNode{
	//  利用遍历的思想解决
	public static int n = 0;
	public static void calaCount1(Node root){
		if(root == null){
			return;
		}
		n++;
		calaCount1(root.left);
		calaCount1(root.right);
	}
	//  利用汇总的思想解决
	public static int calaCount2(Node root){
		if(root == null){
			return 0;
		}
		int left = calaCount2(root.left);
		int right = calaCount2(root.right);
		int count = left + right + 1;
		return count;
	}
	
	   public static Node buildTree(){
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        e.right = h;
        return a;
    }
	public static void main(String[] args) {
        Node root = buildTree();
        calaCount1(root);
		System.out.println(n);
		System.out.println(calaCount2(root));
    }
}