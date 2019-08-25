class Node{
	public char val;
	public Node left = null;
	public Node right = null;
	
	Node(char val){
		this.val = val;
	}
}
public class treesSearch{
	//  查找二叉树中结点
	public static Node search(Node root,char val){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        Node left = search(root.left,val);
        if(left != null){
            return left;
        }
        Node right = search(root.right,val);
        if(right != null){
            return right;
        }
        return null;
    }
    public static boolean search2(Node root,char val){
        if(root == null){
            return false;
        }
        if(root.val == val){
            return true;
        }
        if(search2(root.left,val)){
            return true;
        }
        return search2(root.right,val);
    }
    public static boolean search3(Node root,Node t){
        if(root == null){
            return false;
        }
        if(root.val == t.val && isSameTree(root,t)){
            return true;
        }
        if(search3(root.left,t)){
            return true;
        }
        return search3(root.right,t);
    }
	
	public static boolean isSameTree(Node p,Node q){
		if(p == null && q == null){
			return true;
		}
		if(p == null || q == null){
			return false;
		}
		return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
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
		System.out.println(search2(root,'F'));
	}
}