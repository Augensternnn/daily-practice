package List.LinkedList;

public class LinkedList<E> {
    static final int ELEMENT_NOT_FOUND = -1;
    private int size;
    private Node<E> first;

    private static class Node<E>{
        E element;
        Node<E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    public void clear() {
        size = 0;
        first = null;
    }

    public E get(int index) {
        return node(index).element;
    }

    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    public void add(int index, E element) {
        if(index == 0){
            first = new Node<>(element,first);
        }else {
            Node<E> prev = node(index-1);
            prev.next = new Node<>(element,prev.next);
        }
        size++;
    }

    public void add(E element) {
        add(size, element);
    }

    public E remove(int index) {
        Node<E> prev = node(index-1);
        return null;
    }

    public int indexOf(Object element) {
        return 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置对应的节点对象
     * @param index
     * @return
     */
    private Node<E> node(int index){
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private void outOfBounds(int index){
        throw new IndexOutOfBoundsException("index："+index+"，Size："+size);
    }
    private void rangeCheck(int index){
        if(index<0 || index>=size)
            outOfBounds(index);
    }
    private void rangeCheckForAdd(int index){
        if(index<0 || index>size)
            outOfBounds(index);
    }
}
