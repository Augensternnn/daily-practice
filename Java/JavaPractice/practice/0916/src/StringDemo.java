public class StringDemo {
    public static void main(String[] args) {
        String p = "hello";
        String q = "hello";
        String o = new String("hello");
        System.out.println(p.equals(q));
        System.out.println(p == q);     // true
        System.out.println("***************");
        System.out.println(p.equals(o));
        System.out.println(p == o);     // false    用 new String(...) 创建的对象不会进入常量池
        System.out.println("***************");
        Integer i = 3;
        Integer j = 3;
        System.out.println(i.equals(j));
        System.out.println(i == j);     // true
        System.out.println("***************");
        Integer m = 300;
        Integer n = 300;
        System.out.println(m.equals(n));
        System.out.println(m == n);     // false
    }
}
