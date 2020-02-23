public class Node {
    public int val;
    public Node left = null;
    public Node right = null;

    Node(int val){
        this.val = val;
    }
}

class Element{
    int level;
    Node node;
    Element(Node node,int level){
        this.level = level;
        this.node = node;
    }
}
