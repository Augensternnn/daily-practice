import java.util.Stack;

public class Main {
    public static Node exampleTree(){
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b;  a.right = c;
        b.left = d;  b.right = e;
        c.left = f;  c.right = g;
        e.right = h;
        return a;
    }

    // 前序遍历
        // 递归
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
        // 非递归
    public static void preNoOrder(Node root){
      Stack<Node> stack = new Stack<>();
      Node cur = root;
      while (!stack.empty() || cur != null){
          while (cur != null){
              System.out.println(cur.val);
              stack.push(cur);
              cur = cur.left;
          }
          Node top = stack.pop();
          cur = cur.right;
      }
    }
}
