class Node{
	public int value;
	public Node left = null;
	public Node right = null;
	
	Node(int value){
		this.value = value;
	}
}
public class calcTreesHeight{
	public static int calcHeight(Node root){
		if(root == null){
			return 0;
		}
		int left = calcHeight(root.left);
		int right = calcHeight(root.right);
		int height = Math.max(right,left) + 1;
		return height;
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
        System.out.println(calcHeight(root));
    }
}