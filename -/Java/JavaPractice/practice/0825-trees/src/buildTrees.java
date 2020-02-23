import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class buildTrees {
    // 构建一棵树
        // 前序 + 中序
    public static Node buildTree1(List<Integer> preorder, List<Integer> inorder){
        if(preorder.size() == 0){
            return null;
        }
        int rootVal = preorder.get(0);
        int leftCount = inorder.indexOf(rootVal);
        Node root = new Node(rootVal);
        List<Integer> leftPreorder = preorder.subList(1, 1 + leftCount);
        List<Integer> leftInorder = inorder.subList(0, leftCount);
        Node left = buildTree1(leftPreorder, leftInorder);
        root.left = left;
        List<Integer> rightPreorder = preorder.subList(1 + leftCount, preorder.size());
        List<Integer> rightInorder = inorder.subList(leftCount + 1, inorder.size());
        Node right = buildTree1(rightPreorder, rightInorder);
        root.right = right;
        return root;
    }

        // 中序 + 后序
    public static Node buildTree2(List<Integer> inorder, List<Integer> postorder){
        if(inorder.size() == 0){
            return null;
        }
        int rootVal = postorder.get(postorder.size() - 1);
        int leftCount = inorder.indexOf(rootVal);
        List<Integer> leftInorder = inorder.subList(0,leftCount);
        List<Integer> leftPostorder = postorder.subList(0, leftCount);
        List<Integer> rightInorder = inorder.subList(leftCount + 1,inorder.size());
        List<Integer> rightPostorder = postorder.subList(leftCount, inorder.size() - 1);
        Node root = new Node();
        root.val = rootVal;
        root.left = buildTree2(leftInorder,leftPostorder);
        root.right = buildTree2(rightInorder,rightPostorder);
        return root;
    }
    public static Node buildTree3(int[] inorder,int[] postorder){
        if(inorder.length == 0){
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        int leftCount = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                leftCount = i;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftCount);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftCount);
        int[] rightInorder = Arrays.copyOfRange(inorder, leftCount + 1, inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftCount, postorder.length - 1);
        Node root = new Node();
        root.val = rootVal;
        root.left = buildTree3(leftInorder,leftPostorder);
        root.right = buildTree3(rightInorder,rightPostorder);
        return root;
    }
        // 前序
    public static ReturnVal buildTree4(List<Integer> preorder){
        if(preorder.size() == 0){
            ReturnVal rv = new ReturnVal();
            rv.root = null;
            rv.used = 0;
            return rv;
        }
        int rootVal = preorder.get(0);
        if(rootVal == '#'){
            ReturnVal rv = new ReturnVal();
            rv.root = null;
            rv.used = 1;
            return rv;
        }
        ReturnVal leftRV = buildTree4(preorder.subList(1,preorder.size()));
        ReturnVal rightRV = buildTree4(preorder.subList(1 + leftRV.used, preorder.size()));
        Node root = new Node();
        root.val = rootVal;
        root.left = leftRV.root;
        root.right = rightRV.root;
        ReturnVal rv = new ReturnVal();
        rv.root = root;
        rv.used = 1 + leftRV.used + rightRV.used;
        return rv;
    }
}
