package com.bit;

import org.junit.Test;

import java.io.InputStream;

public class ResourceTest {
    /**
     * 推荐写相对路径时的api
     */
    @Test
    public void test1(){    // 通过相对路径去获取文件
        InputStream is = ResourceTest.class
                .getClassLoader()
                .getResourceAsStream("test1.txt");  // 相对路径：相对最终编译好的文件存放的路径
        // Java文件最终会放在编译好的class文件路径存放的路径
        System.out.println(is);

        InputStream is2 = ResourceTest.class
                .getClassLoader()
                .getResourceAsStream("test2.txt");
        System.out.println(is2);
    }

    @Test
    public void test2(){    // 通过相对路径去获取文件
        InputStream is = ResourceTest.class
//                .getClassLoader()
                .getResourceAsStream("../../test1.txt");    // ../：返回上级目录
        System.out.println(is);
    }
}
