import java.util.*;

class TreeNode<E>{
    E val;
    TreeNode<E> left;
    TreeNode<E> right;

    TreeNode(E e){
        this.val = e;
    }
}

class Pair<E>{
    TreeNode<E> node;
    int level;

    Pair(TreeNode<E> node, int level){
        this.node = node;
        this.level = level;
    }
}

public class TreeGeneric {
    public static <E> List<List<E>> levelOrder(TreeNode<E> root){
        Queue<Pair<E>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        List<List<E>> ret = new ArrayList<>();
        while (!queue.isEmpty()){
            Pair<E> front = queue.poll();
            if(ret.size() == front.level){
                ret.add(new ArrayList<>());
            }
            ret.get(front.level).add(front.node.val);
            if(front.node.left != null){
                queue.offer(new Pair<>(front.node.left, front.level));
            }
            if(front.node.right != null){
                queue.offer(new Pair<>(front.node.right, front.level));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode<Integer> n1 = new TreeNode<>(1);
        TreeNode<Integer> n2 = new TreeNode<>(2);
        TreeNode<Integer> n3 = new TreeNode<>(3);
        TreeNode<Integer> n4 = new TreeNode<>(4);
        TreeNode<Integer> n5 = new TreeNode<>(5);

        n1.left = n2; n1.right = n3;
        n2.left = n4; n3.right = n5;

        List<List<Integer>> r = levelOrder(n1);
        System.out.println(r);
    }
}
