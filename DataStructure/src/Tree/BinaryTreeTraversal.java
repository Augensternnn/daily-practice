package Tree;

/**
 * 二叉树遍历
 */
public class BinaryTreeTraversal {
    private int size;
    private static Node root;

    /**
     * 前序遍历
     */
    //递归
    public static void preorderRecursion(){
        preorderRecursion(root);
    }
    private static void preorderRecursion(Node node){
        if(node == null)
            return;
        System.out.println(node.element);
        preorderRecursion(node.left);
        preorderRecursion(node.right);
    }
    //非递归


    private static class Node{
        int element;
        Node left;
        Node right;
        Node parent;
        public Node(int element, Node parent){
            this.element = element;
            this.parent = parent;
        }
    }
}
