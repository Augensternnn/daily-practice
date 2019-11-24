package memory;

import org.junit.Assert;
import org.junit.Test;

public class IntegerInMemory {

    // int类型赋值，不管大小，都是在常量池中查找，如果有这个值，
    // 直接返回引用，如果没有，在常量池中创建一个对象再返回引用
    @Test
    public void test1_1(){// 测试通过
        int i1 = 10;
        int i2 = 10;
        Assert.assertTrue(i1 == i2);
    }
    @Test
    public void test1_2(){// 测试通过
        int i1 = 128;
        int i2 = 128;
        Assert.assertTrue(i1 == i2);
    }

    // Integer与int比较，都会进行自动拆装箱，实际是Integer中
    // 的value与int进行比较，所以不管大小，只要值相等，这两个
    // 变量就相等。
    @Test
    public void test2_1(){// 测试通过
        int i1 = 10;
        Integer i2 = 10;
        Assert.assertTrue(i1 == i2);
    }
    @Test
    public void test2_2(){// 测试通过
        int i1 = 128;
        Integer i2 = 128;
        Assert.assertTrue(i1 == i2);
    }

    // Integer与Integer比较，如果都是常量赋值的，那么在-128
    // 到127范围内的比较，就是常量池对象的比较，如果在范围外，
    // 就是堆里边对象的比较。
    @Test
    public void test3_1(){// 测试通过
        Integer i1 = 10;
        Integer i2 = 10;
        Assert.assertTrue(i1 == i2);
    }
    @Test
    public void test3_2(){// 测试不能通过
        Integer i1 = 128;
        Integer i2 = 128;
        Assert.assertTrue(i1 == i2);
    }

    // Integer与Integer比较，不管大小，如果有一个是new Integer()的方式
    // 创建的，那肯定就不相等。
    @Test
    public void test4_1(){
        Integer i1 = 10;
        Integer i2 = new Integer(10);
        Assert.assertTrue(i1 == i2);
    }
    @Test
    public void test4_2(){
        Integer i1 = 128;
        Integer i2 = new Integer(128);
        Assert.assertTrue(i1 == i2);
    }
}
