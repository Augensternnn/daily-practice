public class HashBucket {
    // 哈希桶
    private static class Node{
        int key;
        int value;
        Node next;
    }

    private Node[] array;
    private int size;

    HashBucket(){
        array = new Node[16];
        size = 0;
    }
}
