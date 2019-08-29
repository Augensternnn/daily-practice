public class Node {
    public char val;
    public Node left = null;
    public Node right = null;

    Node(){}

    Node(char val){
        this.val = val;
    }
}
class ReturnValue{
    Node root;
    int used;
}

class Element{
    Node node;
    int level;

    Element(Node node, int level){
        this.node = node;
        this.level = level;
    }
}
