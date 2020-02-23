import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class binarySearchTree {
    private static class Node{
        int key;
        int value;
        Node left;
        Node right;
    }
    private  Node root = null;

    // 键值对class
    public static class Entry{
        private int key;
        private int value;

        public int getKey(){
            return key;
        }

        public int getValue(){
            return value;
        }
    }

    // public Set<Map.Entry<Integer,Integer>> entrySet()
    // 返回所有的键值对
    public Set<Entry> entrySet(){
        // 通过层序遍历的方式
        Set<Entry> set = new HashSet<>();
        if(root == null){
            return set;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node front = queue.poll();
            Entry entry = new Entry();
            entry.key = front.key;
            entry.value = front.value;
            if(front.left != null){
                queue.add(front.left);
            }
            if(front.right != null){
                queue.add(front.right);
            }
        }
        return set;
    }

    public boolean containsKey(int key){
        // 通过搜索树的规则确定
    }

    public boolean containsValue(int value){
        // 只能遍历，时间复杂度为O(n)
        // 能用 containsKey 就不用 containsValue
    }
}
