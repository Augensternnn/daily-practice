package memory;

public class ChainInMemory {
    private static class ChainNode{
        private ChainNode next;
    }

    public static void main(String[] args) {
        ChainNode first = new ChainNode();
        ChainNode second = new ChainNode();
        ChainNode third = new ChainNode();
        first.next = second;
        second = third;
    }
}
