class Node{
	public int value;
	public Node left = null;
	public Node right = null;
	Node(int value){
		this.value = value;
	}
}

public class Trees{
	public static void preOrderTraversal(Node root){
		if(root == null){
			return;
		}
		System.out.println(root.value);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	public static void inOrderTraversal(Node root){
		if(root == null){
			return;
		}
		inOrderTraversal(root.left);
		System.out.println(root.value);
		inOrderTraversal(root.right);
	}
	
	public static void postOrderTraversal(Node root){
		if(root == null){
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root.value);
	}
	
	public static Node buildTrees(){
		Node a = new Node('A');
		Node b = new Node('B');
		Node c = new Node('C');
		a.left = b;
		a.right = c;
		return a;
	}
	
	public static void main(String[] args){
		Node root = buildTrees();
		preOrderTraversal(root);
		System.out.println("==================");
		inOrderTraversal(root);
		System.out.println("==================");
		postOrderTraversal(root);
	}
}
