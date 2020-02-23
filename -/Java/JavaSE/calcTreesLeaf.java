class Node{
	public int value;
	public Node left = null;
	public Node right = null;
	
	Node(int value){
		this.value = value;
	}
}
//  计算二叉树叶子结点个数
public class calcTreesLeaf{
	//  遍历思想
	public static int leafCount = 0;
	public static void calcLeafCount1(Node root){
		if(root == null){
			return;
		}
		calcLeafCount1(root.left);
		if(root.left == null && root.right == null){
			leafCount++;
		}
		calcLeafCount1(root.right);
	}
	//  汇总思想
	public static int calcLeafCount2(Node root){
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return 1;
		}
		int leafCount1 = calcLeafCount2(root.left);
		int rightCount = calcLeafCount2(root.right);
		int LeafCount = leafCount1 + rightCount;
		return LeafCount;
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
        calcLeafCount1(root);
		System.out.println(leafCount);
		System.out.println(calcLeafCount2(root));
    }
}