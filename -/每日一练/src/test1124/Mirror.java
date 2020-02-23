package test1124;

class TreeNode{
    public int val;
    public TreeNode left = null;
    public TreeNode right  = null;

    public TreeNode(int val){
        this.val = val;
    }
}

public class Mirror {
    public void mirror(TreeNode root){
        if(root==null)
            return;
        TreeNode lRoot = root.left;
        TreeNode rRoot = root.right;
        root.left = rRoot;
        root.right = lRoot;
        while (root.left != null)
            mirror(root.left);
        while (root.right != null)
            mirror(root.right);


    }
    private void change(TreeNode left, TreeNode right){
        TreeNode tmp = null;
        tmp = left;
        left = right;
        right = tmp;
    }
}
