import java.util.ArrayList;
import java.util.List;

public class topic1 {
    //  返回二叉树前序遍历
    /*
    public List<Integer> preorderTraversal(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> leftPreOrder = preorderTraversal(root.left);
        List<Integer> rightPreOrder = preorderTraversal(root.right);
        list.add(root.value);
        list.addAll(leftPreOrder);
        list.addAll(rightPreOrder);
        return list;
    }
    */
    private List<Integer> list;
    private void preOrder(Node root){
        if(root == null){
            return;
        }
        list.add(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }
    public List<Integer> preorderTraversal(Node root){
        list = new ArrayList<>();
        preOrder(root);
        return list;
    }
}
