public class Node {
    public int val;
    public Node left = null;
    public Node right = null;

    Node(){}
    Node(int val){
        this.val = val;
    }
}

class ReturnVal{
    Node root;
    int used = 0;
}
