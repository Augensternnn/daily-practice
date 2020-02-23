public class MyLinkedList implements List {
    private static class Node {
        private int val;
        private Node prev;
        private Node next;

        private Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }

        private Node(int val, Node prev, Node next) {
            this(val);
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    /**
     * 记录链表的第一个结点
     */
    private Node head = null;
    /**
     * 记录链表的最后一个结点
     */
    private Node last = null;
    /**
     * 记录链表中当前元素的个数
     */
    private int size = 0;

    @Override
    public boolean add(int element) {
        return add(size, element);
    }

    /**
     * 把 element 插入到 index 位置处
     * @param index 下标
     * @param element 元素
     * @return true 代表成功、false 代表失败
     */
    @Override
    public boolean add(int index, int element) {
        // 1. 检查下标的合法性
        if (index < 0 || index > size) {
            System.out.println("下标不合法");
            return false;
        }
        //  2.1 当 index == 0 的时候，需要特殊处理
        if (index == 0) {
            head = new Node(element, null, head);
            if (head.next != null) {
                head.next.prev = head;
            }
            if (size == 0) {
                last = head;
            }
            size++;
            return true;
        }

        if (index == size) {
            last = new Node(element, last, null);
            if (last.prev != null) {
                last.prev.next = last;
            }
            if (size == 0) {
                head = last;
            }
            size++;
            return true;
        }
        // 2. 找到 index 位置的结点的结点 node
        //    2. 如果 index 在左边，从 head 往后找，如果在右边，从 last 往前找
        Node node = getNode(index);
        // 3. 把 element 装到结点中
        // 4. node 前驱的 next = element 所在的结点
        // 5. element 所在结点的 next = node
        Node newNode = new Node(element, node.prev, node);
        node.prev.next = newNode;
        node.prev = newNode;
        size++;
        // 6. size++

        return true;
    }

    /**
     * 找到 index 下标所在的结点
     * index 一定是合法的
     * 判断是从前往后找，还是从后前找
     * @param index [0, size)
     * @return
     */
    private Node getNode(int index) {
        if (index < size / 2) {
            Node cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }

            return cur;
        } else {
            Node cur = last;
            for (int i = 0; i < size - index - 1; i++) {
                cur = cur.prev;
            }
            return cur;
        }
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        return getNode(index).val;
    }

    @Override
    public int set(int index, int val) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node node = getNode(index);
        int oldValue = node.val;
        node.val = val;
        return oldValue;
    }

    @Override
    public int remove(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node node = getNode(index);
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            last = node.prev;
        }
        size--;

        return node.val;
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
        for (Node c = head; c != null; c = c.next) {
            r += (c.val + ",");
        }
        r += "]";

        return r;
    }
}
