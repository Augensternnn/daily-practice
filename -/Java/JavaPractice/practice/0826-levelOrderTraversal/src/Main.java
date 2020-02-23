import java.util.*;

public class Main {
    public static void levelOrder1(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node front = queue.poll();
            System.out.println(front.val);
            if(front.left != null){
                queue.add(front.left);
            }
            if(front.right != null){
                queue.add(front.right);
            }
        }
    }

    public static List<List<Integer>> levelOrder2(Node root){
        List<List<Integer>> retList = new ArrayList<>();
        if(root == null){
            return retList;
        }
        Queue<Element> queue = new LinkedList<>();
        Element e = new Element(root, 0);
        queue.add(e);
        while(!queue.isEmpty()){
            Element front = queue.poll();

            if(front.level == retList.size()){
                retList.add(new ArrayList<>());
            }
            retList.get(front.level).add(front.node.val);

            if(front.node.left != null){
                queue.add(new Element(front.node.left, front.level + 1));
            }
            if(front.node.right != null){
                queue.add(new Element(front.node.right, front.level + 1));
            }
        }
        return retList;
    }

    // 判断是否是完全二叉树【空树是完全二叉树】
    public static boolean isCompleteTree(Node root){
        // 层序遍历，直到遇到 null
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (true){
            Node front = queue.poll();
            if(front == null){
                break;
            }
            queue.add(front.left);
            queue.add(front.right);
        }
        // 判断队列中剩余元素是否都是 null
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node != null){
                return false;
            }
        }
        return true;
    }
}
