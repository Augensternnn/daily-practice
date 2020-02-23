import java.util.ArrayList;
import java.util.List;
class Node{
	public char value;
	public Node left = null;
	public Node right = null;
	
	Node(char value){
		this.value = value;
	}
}

public class Trees {
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

    public List<Character> preOrder(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Character> list = new ArrayList<>();
        List<Character> leftPreOrder = preOrder(root.left);
        List<Character> rightPreOrder = preOrder(root.right);
        list.add(root.value);
        list.addAll(leftPreOrder);
        list.addAll(rightPreOrder);
        return list;
    }

    public static void main(String[] args) {
        Node root = buildTree();
        preOrderTraversal(root);
        System.out.println("=========================");
        inOrderTraversal(root);
        System.out.println("=========================");
        postOrderTraversal(root);
    }
}
