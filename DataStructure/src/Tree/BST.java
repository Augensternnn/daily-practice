package Tree;

import Tree.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.Queue;

/**
 * 二叉搜索树
 */
public class BST<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BST(){
        this(null);
    }

    public BST(Comparator<E> comparator){
        this.comparator = comparator;
    }

    private static class Node<E>{
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        public Node(E element,Node<E> parent){
            this.element = element;
            this.parent = parent;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        root = null;
        size = 0;
    }

    public void add(E element){
        elementNotNullCheck(element);
        //添加第一个节点
        if(root == null){
            root = new Node<>(element,null);
            size++;
            return;
        }

        //添加的不是第一个节点
        //找到父节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        do {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else { // 相等
                node.element = element;
                return;
            }
        } while (node != null);
        //看看插入到父节点哪个位置
        Node<E> newNode = new Node<>(element,parent);
        if(cmp > 0)
            parent.right = newNode;
        else
            parent.left = newNode;
        size++;
    }

    public void remove(E element){
        //remove(node(element));
    }

    public boolean contains(E element){
        return node(element) != null;
    }

    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else { // cmp < 0
                node = node.left;
            }
        }
        return null;
    }

    /**
     * @return 返回值等于0：e1 == e2；返回值大于0：e1 > e2；返回值小于0：e1 < e2
     */
    private int compare(E e1, E e2){
        if(comparator != null)
            return comparator.compare(e1, e2);
        return ((Comparable<E>)e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element){
        if(element == null)
            throw new IllegalArgumentException("element must not be null");
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element;
    }

    /**
     * 前序遍历
     */
    public void preorderTraversal(){
        preorderTraversal(root);
    }
    private void preorderTraversal(Node<E> node){
        if (node == null)
            return;
        System.out.println(node.element);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    /**
     * 中序遍历
     */
    public void inorderTraversal(){
        inorderTraversal(root);
    }
    private void inorderTraversal(Node<E> node){
        if (node == null)
            return;
        inorderTraversal(node.left);
        System.out.println(node.element);
        inorderTraversal(node.right);
    }

    /**
     * 后序遍历
     */
    public void postorderTraversal(){
        postorderTraversal(root);
    }
    private void postorderTraversal(Node<E> node){
        if (node == null)
            return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.element);
    }

    /**
     * 层序遍历
     */
    public void levelOrderTraversal(){
        if(root == null)
            return;
        Queue<Node<E>>
    }
}
