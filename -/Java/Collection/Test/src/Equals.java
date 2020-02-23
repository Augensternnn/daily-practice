import org.junit.Test;

public class Equals {
    @Test
    public void test1(){
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");

        System.out.println(s1==s2);            // true
        System.out.println(s1.equals(s2));     // true
        System.out.println(s3==s4);            // false
        System.out.println(s3.equals(s4));     // true
        System.out.println(s1==s3);            // false
        System.out.println(s1.equals(s3));     // true
    }

    @Test
    public void test2(){
        int a = 6;
        int b = 6;
        Integer a1 = 50;
        Integer a2 = 50;
        Integer a3 = 500;
        Integer a4 = 500;

        System.out.println(a==b);             // true
        System.out.println(a1==a2);           // true
        System.out.println(a1.equals(a2));    // true
        System.out.println(a3==a4);           // false
        System.out.println(a3.equals(a4));    // true
    }
}
