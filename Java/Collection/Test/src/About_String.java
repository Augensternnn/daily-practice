import org.junit.Assert;
import org.junit.Test;

public class About_String {
    // true：都是常量池中的字面量
    @Test
    public void test1(){// 测试通过
        String s1 = "hello";
        String s2 = "hello";
        Assert.assertTrue(s1 == s2);
    }

    // true：s3 = "he" + "llo"
    // JVM在编译期间会进行优化：s3为字面量拼接的字符串"hello"，存在常量池
    @Test
    public void test2(){// 测试通过
        String s1 = "hello";
        String s2 = "hel" + "lo";
        Assert.assertTrue(s1 == s2);
    }

    // s2创建了以下对象
    // 1."hello"：存在字符串常量池，如果常量池已有"hello"就不创建
    // 2.new String("hello")：存在堆中
    // s1为常量池的"hello"对象，s2为堆中的对象new String("hello")
    @Test
    public void test3(){// 测试不能通过
        String s1 = "hello";
        String s2 = new String("hello");
        Assert.assertTrue(s1 == s2);
    }

    // 调用intern方法时，如果池已经包含与equals(Object)方法确定的
    // 相当于此String对象的字符串，则返回来自池的字符串。 否则，此
    // String对象将添加到池中，并返回对此String对象的引用。
    // 由此可见，对于任何两个字符串s和t，s.intern() == t.intern()
    // 是true当且仅当s.equals(t)是true。
    @Test
    public void test4(){// 测试通过
        String s1 = "hello";
        String s2 = new String("hello");
        Assert.assertTrue(s1 == s2.intern());
    }

    // s4是用s2和s3两个常量池中的对象相加新生成的对象，存在堆中
    @Test
    public void test5(){// 测试不能通过
        String s1 = "hello";
        String s2 = "hel";
        String s3 = "lo";
        String s4 = s2 + s3;
        Assert.assertTrue(s1 == s4);
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "hel" + "lo";
        String s4 = new String("hello");
        String s5 = "hel";
        String s6 = "lo";
        String s7 = s5 +s6;
                                                // 运行结果
        System.out.println(s1==s2);             // true：都是常量池中的字面量
        System.out.println(s1==s3);             // true：JVM在编译期间会进行优化：s3为字面量拼接的字符串"hello"，存在于常量池
        System.out.println(s1==s4);             // false：s1为常量池中的"hello"对象；s4为堆中的对象new String("hello")
        System.out.println(s1==s4.intern());    // true：调用了intern()方法
        System.out.println(s1 == s7);           // false：s4存在于堆中
    }
}
