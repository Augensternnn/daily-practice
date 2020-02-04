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

    
}
