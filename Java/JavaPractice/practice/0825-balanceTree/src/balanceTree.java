public class balanceTree {
    public static int calcHeight(Node root){
        if(root == null){
            return 0;
        }
        int left = calcHeight(root.left);
        int right = calcHeight(root.right);
        int height = left + right + 1;
        return height;
    }
    public static boolean isBalanced(Node root){
        if(root == null){
            return true;
        }
        boolean leftBalance = isBalanced(root.left);
        if(!leftBalance){
            return false;
        }
        boolean rightBalance = isBalanced(root.right);
        if(!rightBalance){
            return false;
        }
        int leftHeight = calcHeight(root.left);
        int rightHeight = calcHeight(root.right);
        int diff = leftHeight - rightHeight;
        if(diff > 1 || diff < 1) {
            return false;
        }
        return true;
    }
}
