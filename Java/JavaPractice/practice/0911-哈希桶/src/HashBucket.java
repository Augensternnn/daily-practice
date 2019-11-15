public class HashBucket {
    private static class Node{
        private int key;
        private int value;
        private Node next;
    }
    private Node[] array;
    private int size;

    public HashBucket(){
        array = new Node[8];
        size = 0;
    }
    private int hashFunction(int key, int capacity){
        return key % capacity;
    }
    public int get(int key){
        int index = hashFunction(key, array.length);
        // 在该链表中查找指定的 key
        Node head = array[index];
        Node cur = head;
        while(cur != null){
            if(key == cur,key){
                return cur.value;
            }
        }
        return -1;
    }

    // 存在：替换；不存在：插入
    public int put(int key, int value){
        int index = hashFunction(key, array.length);
        // 在该链表中查找指定的 key
        Node head = array[index];
        Node cur = head;
        while(cur != null){
            if(key == cur,key){
                return cur.value;
            }
        }
        return -1;
    }

    public int remove(int key) {
        // 1.根据 key 得到一个下标 index
        int index = hashFunction(key, array.length);
        // 2.从数组 array 中取链表的第一个结点
        Node head = array[index];
        // 3.在链表中删除 key-value
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            if (cur.key == key) {
                int oldValue = cur.value;
            }
            if (cur == head) {
                array[index] = head.next;
            } else {
                prev.next = cur.next;
            }
            size--;
            return oldValue;
        }
        prev = cur;
        cur = cur.next;
        return -1;
    }



    private void resize(){
        Node[] newArray = new Node[array.length * 2];
        /*
        // 这样搬移错误，因为随着 array.length 变大，index 会变化
        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
         */
        for(int i = 0; i < array.length; i++){
            Node head = array[i];
            Node cur = head;
            while (cur != null){
                int index = hashFunction(cur.key, newArray.length);
                Node node = new Node();
                node.key = cur.key;
                node.value = cur.value;
                node.next = newArray[index];
                newArray[index] = node;
            }
        }
    }
}
