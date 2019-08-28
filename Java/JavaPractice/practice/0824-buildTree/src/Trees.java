import java.util.*;

public class Trees {
    public static Node buildTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        e.right = h;
        return a;
    }

    // 前序遍历
        // 递归
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
        // 非递归
    public static void preorderNoR(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (!stack.empty() || cur != null){
            while (cur != null){
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
    }

    // 中序遍历
        // 递归
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
        // 非递归
    public static void in(Node root){

    }

    // 后序遍历
        // 递归
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }
        // 非递归
    public static void post(Node root){

    }

    // 层序遍历
    public static void levelOrderTraversal(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
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

    public static List<List<Character>> levelOrder(Node root){
        List<List<Character>> retList = new ArrayList<>();
        if(root == null){
            return retList;
        }
        Queue<Element> queue = new LinkedList<>();
        Element e = new Element(root, 0);
        queue.add(e);
        while (!queue.isEmpty()){
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

    // 计算二叉树中结点个数
        // 遍历思想
    public static int nodeCount = 0;
    public static void calcTreeNode1(Node root){
        if(root == null){
            return;
        }
        nodeCount++;
        calcTreeNode1(root.left);
        calcTreeNode1(root.right);
    }
        // 汇总思想
    public static int calcTreeNode2(Node root){
        if(root == null){
            return 0;
        }
        int left = calcTreeNode2(root.left);
        int right = calcTreeNode2(root.right);
        int count = left + right + 1;
        return count;
    }

    // 计算叶子结点的个数
        // 遍历思想
    public static int leafCount = 0;
    public static int calcLeafCount1(Node root){
        if(root == null){
            return leafCount;
        }
        calcLeafCount1(root.left);
        // 代表是叶子结点
        if(root.left == null && root.right == null){
            leafCount++;
        }
        calcLeafCount1(root.right);
        return leafCount;
    }
        // 汇总思想
    public static int calcLeafCount2(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = calcTreeNode2(root.left);
        int right = calcTreeNode2(root.right);
        return left + right;
    }

    // 求二叉树高度
    public static int calcHeight(Node root){
        if(root == null){
            return 0;
        }
        int left = calcHeight(root.left);
        int right = calcHeight(root.right);
        int height = Math.max(left , right) + 1;
        return height;
    }

    // 计算第 k 层结点个数
    public static int calcKLevel(Node root,int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        int left = calcKLevel(root.left,k - 1);
        int right = calcKLevel(root.right,k - 1);
        int count = left + right;
        return count;
    }

    // 查找
    public static Node search(Node root,char val){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        Node left = search(root.left,val);
        if(left != null){
            return left;
        }
        Node right = search(root.right,val);
        if(right != null){
            return right;
        }
        return null;
    }
    public static boolean search2(Node root,char val){
        if(root == null){
            return false;
        }
        if(root.val == val){
            return true;
        }
        if(search2(root.left,val)){
            return true;
        }
        return search2(root.right,val);
    }
    public static boolean search3(Node root,Node t){
        if(root == null){
            return false;
        }
        if(root.val == t.val && isSameTree(root,t)){
            return true;
        }
        if(search3(root.left,t)){
            return true;
        }
        return search3(root.right,t);
    }

    // 判断两棵树是否相同
    public static boolean isSameTree(Node p,Node q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    // 判断两棵树是否镜像
    public static boolean isMirror(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    // 构建一棵树
        // 前序 +中序
    public static Node buildTree1(List<Character> preorder, List<Character> inorder){
        if (preorder.size() == 0) {
            return null;
        }
        char rootValue = preorder.get(0);
        int leftCount = inorder.indexOf(rootValue);
        Node root = new Node(rootValue);
        List<Character> leftPreorder = preorder.subList(1, 1 + leftCount);
        List<Character> leftInorder = inorder.subList(0, leftCount);
        Node left = buildTree1(leftPreorder, leftInorder);
        root.left = left;
        List<Character> rightPreorder = preorder.subList(1 + leftCount, preorder.size());
        List<Character> rightInorder = inorder.subList(leftCount + 1, inorder.size());
        Node right = buildTree1(rightPreorder, rightInorder);
        root.right = right;
        return root;
    }

        // 中序 + 后序
    public static Node buildTree2(List<Character> inorder,List<Character> postorder){
        if(inorder.size() == 0){
            return null;
        }
        char rootVal = postorder.get(postorder.size() - 1);
        int leftCount = inorder.indexOf(rootVal);
        List<Character> leftInorder = inorder.subList(0,leftCount);
        List<Character> leftPostorder = postorder.subList(0,leftCount);
        List<Character> rightInorder = inorder.subList(leftCount + 1,inorder.size());
        List<Character> rightPostorder = postorder.subList(leftCount,postorder.size() - 1);
        Node root = new Node();
        root.val = rootVal;
        root.left = buildTree2(leftInorder,leftPostorder);
        root.right = buildTree2(rightInorder,rightPostorder);
        return root;
    }
            // 数组
    public static Node buildTreeArray(char[] inorder,char[] postorder){
        if(inorder.length == 0){
            return null;
        }
        char rootVal = postorder[postorder.length - 1];
        int leftCount = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                leftCount = i;
            }
        }
        char[] leftInorder = Arrays.copyOfRange(inorder, 0, leftCount);
        char[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftCount);
        char[] rightInorder = Arrays.copyOfRange(inorder, leftCount + 1, inorder.length);
        char[] rightPostorder = Arrays.copyOfRange(postorder, leftCount, postorder.length - 1);
        Node root = new Node();
        root.val = rootVal;
        root.left = buildTreeArray(leftInorder,leftPostorder);
        root.right = buildTreeArray(rightInorder,rightPostorder);
        return root;
    }

        // 前序
    public static ReturnValue buildTreePreorder(List<Character> preorder) {
        if (preorder.size() == 0) {
            ReturnValue rv = new ReturnValue();
            rv.root = null;
            rv.used = 0;
            return rv;
        }
        char rootVal = preorder.get(0);
        if (rootVal == '#') {
            ReturnValue rv = new ReturnValue();
            rv.root = null;
            rv.used = 1;
            return rv;
        }
        ReturnValue leftRV = buildTreePreorder(preorder.subList(1, preorder.size()));
        ReturnValue rightRV = buildTreePreorder(preorder.subList(1 + leftRV.used, preorder.size()));
        Node root = new Node();
        root.val = rootVal;
        root.left = leftRV.root;
        root.right = rightRV.root;
        ReturnValue rv = new ReturnValue();
        rv.root = root;
        rv.used = 1 + leftRV.used + rightRV.used;
        return rv;
    }

    // 是否是平衡二叉树
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
        if(diff > 1 || diff < 1){
            return false;
        }
        return true;
    }

    // 根据二叉树创建字符串
    public static String treeStr(Node t){
        if(t == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorderTree(sb,t);
        String r = sb.toString();
        return r.substring(1,r.length() - 1);
    }
    public static void preorderTree(StringBuilder sb, Node root){
        if(root == null){
            return;
        }
        sb.append("(");
        sb.append(root.val);
        if(root.left == null && root.right != null){
            sb.append("()");
        }else{
            preorderTree(sb,root.left);
        }
        preorderTree(sb,root.right);
        sb.append(")");
    }

    // 二叉树的最近公共祖先
    public static Node lowestCommonAncestor(Node root,Node p,Node q){
        if(root == p || root == q){
            return root;
        }
        boolean pInLeft = search4(root.left,p);
        boolean qInLeft = search4(root.left,q);
        if(pInLeft && qInLeft){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(!pInLeft && ! qInLeft){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
    public static boolean search4(Node root,Node n){
        if(root == null){
            return false;
        }
        if(root == n){
            return true;
        }
        if(search4(root.left,n)){
            return true;
        }
        return search4(root.right,n);
    }

    public static void main(String[] args) {
        /*
        List<Character> preorder1 = Arrays.asList('A', 'B', 'D', 'E', 'G', 'C', 'F', 'H');
        List<Character> inorder = Arrays.asList('D', 'B', 'G', 'E', 'A', 'C', 'F', 'H');
        Node root = buildTree1(preorder1, inorder);
        System.out.println("成功");

        List<Character> preorder2 = Arrays.asList( (char)1,(char)2,(char)3,'#','#','#',(char)4,'#',(char)5,'#','#');
        ReturnValue rv = buildTreePreorder(preorder2);
        levelOrderTraversal(rv.root);
        */
        Node root = buildTree();
        preorderNoR(root);
    }
}
