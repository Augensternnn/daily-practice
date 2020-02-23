import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class ScannerDemo {
    private interface Where {
        boolean test(Integer i);
    }
    private static class C implements Where {
        @Override
        public boolean test(Integer i) {
            return i % 2 == 0;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) { list.add(i); }
        ArrayList<Integer> oushu = new ArrayList<>();
        Where where = new C();
        for (int v : list) { if (where.test(v)) { oushu.add(v); } }
        /*
        while (true) {
            Date date = new Date();
            SimpleDateFormat fmt = new SimpleDateFormat("Y-M-d HH:mm:ss");
            System.out.println(fmt.format(date));
            Thread.sleep(1000);
        }
        */
        /*
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("D")) {
                iterator.remove();
            }
        }
        System.out.println(list);
        */

        /*
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个数字:");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("你输入的数字是: |%d|%n", n);

        System.out.println("请输入一句话:");
        String s = scanner.nextLine();
        System.out.printf("你输入的一句话是: |%s|%n", s);
        */
    }
}
