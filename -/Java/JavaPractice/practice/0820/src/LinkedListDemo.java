import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("C");
        list.addLast("JavaSE");
        list.addLast("数据结构");
        list.addLast("操作系统");
        /*
        System.out.println(list.poll());
        System.out.println(list.pollFirst());
        System.out.println(list.pollLast());
        System.out.println(list.size());
         */
        /*
        System.out.println(list.pop());
        System.out.println(list.size());
         */
        System.out.println(list.size());
        System.out.println(list.peek());
        System.out.println(list.peekLast());

    }
}
