package test1201;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class BalanceTree {
    public boolean isBalance(TreeNode root) {
        if(root == null)
            return true;
        boolean leftBalance = isBalance(root.left);
        if(!leftBalance)
            return false;
        boolean rightBalance = isBalance(root.right);
        if(!rightBalance)
            return false;
        int leftHeight = calcHeight(root.left);
        int rightHeight = calcHeight(root.right);
        int diff = leftHeight - rightHeight;
        if(diff > 1 || diff < 1)
            return false;
        return true;
    }
    public int calcHeight(TreeNode root){
        if(root == null)
            return 0;
        int left = calcHeight(root.left);
        int right = calcHeight(root.right);
        int height = Math.max(left, right) + 1;
        return height;
    }
}
