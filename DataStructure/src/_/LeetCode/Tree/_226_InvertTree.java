package _.LeetCode.Tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 226.翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _226_InvertTree {
    //前序
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //后序
    public TreeNode invertTree1(TreeNode root) {
        if(root == null)
            return root;

        invertTree1(root.left);
        invertTree1(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    //中序
    public TreeNode invertTree2(TreeNode root) {
        if(root == null)
            return root;

        invertTree2(root.left);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree2(root.left);//注意这里
        return root;
    }

    //层序
    public TreeNode invertTree3(TreeNode root) {
        if (root == null)
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
        return root;
    }
}
