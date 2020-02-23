public class LinkedList implements List {
    private static class Node{
        private int val;
        private Node prev;
        private Node next;

        private Node(int val){
            this.val = val;
            this.prev = null;
            this.next = null;
        }

        private Node(int val,Node prev,Node next){
            this(val);
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + "}";
        }
    }

    private Node head = null;
    private Node last = null;
    private int size = 0;

    @Override
    public boolean add(int element) {
        return add(size, element);
    }

    @Override
    public boolean add(int index, int element) {
        if(index < 0 || index > size){
            System.out.println("下标不合法");
            return false;
        }
        if(index == 0){
            head = new Node(element, null, head);
            if(head.next != null){
                head.next.prev = head;
            }
            if(size == 0){
                last = head;
            }
            size++;
            return true;
        }
        if(index == size){
            last = new Node(element, last, null);
            if(last.prev != null){
                last.prev.next = last;
            }
            if(size == 0){
                head = last;
            }
            size++;
            return true;
        }
        Node node = getNode(index);
        Node newNode = new Node(element, node.prev, node);
        node.prev.next = newNode;
        node.prev = newNode;
        size++;
        return true;
    }

    private Node getNode(int index){
        if(index < size / 2){
            Node cur = head;
            for(int i = 0; i < index; i++){
                cur = cur.next;
            }
            return cur;
        }else{
            Node cur = last;
            for(int i = 0; i < size - index - i; i++){
                cur = cur.prev;
            }
            return cur;
        }
    }

    @Override
    public int remove(int index) {
        if(index < 0 || index >= size){
            System.out.println("下标不合法");
            return -1;
        }
        Node node = getNode(index);
        if(node.prev != null) {
            node.prev.next = node.next;
        }else{
            head = head.next;
        }
        if(node.next != null){
            node.next.prev = node.prev;
        }else{
            last = node.prev;
        }
        size--;
        return node.val;

    }

    @Override
    public int get(int index) {
        if(index < 0 || index >= size){
            System.out.println("下标不合法");
            return -1;
        }
        return getNode(index).val;
    }

    @Override
    public int set(int index, int element) {
        if(index < 0 || index >= size){
            System.out.println("下标不合法");
            return -1;
        }
        Node node = getNode(index);
        int oldVal = node.val;
        node.val = element;
        return oldVal;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String r = "[";
        for(Node c = head; c != null; c = c.next){
            r += (c.val + ",");
        }
        r += "]";
        return r;
    }
}
