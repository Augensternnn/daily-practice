public class Insert_In_Node {
    private static class Insert{
        private Insert next;
    }

    public static void main(String[] args) {
        Insert first = new Insert();
        Insert second = new Insert();
        Insert third = new Insert();
        first.next=second;
        second=third;
    }
}
