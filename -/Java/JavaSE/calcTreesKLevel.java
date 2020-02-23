class Node{
	public char val;
	public Node left = null;
	public Node right = null;
	
	Node(char val){
		this.val = val;
	}
}
public class calcTreesKLevel{
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
	// 计算第 k 层结点个数
	public static int calcKLevel(Node root,int k){
		if(root == null){
			return 0;
		}
		if(k == 1){
			return 1;
		}
		int left = calcKLevel(root.left, k - 1);
		int right = calcKLevel(root.right, k - 1);
		int count = left + right;
		return count;
	}
	public static void main(String[] args) {
        Node root = buildTree();
		System.out.println(calcKLevel(root,4));
	}
}