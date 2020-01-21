import org.junit.Test;

import java.io.InputStream;

/**
 * 推荐写相对路径时的path
 */
public class RelativePath {
    @Test   // 通过相对路径去获取文件
    public void test1(){
        InputStream is = RelativePath.class
                .getClassLoader()
                .getResourceAsStream("test.txt");
        // 相对路径：相对最终编译好的文件存放的路径
        // Java文件最终会放在编译好的class文件路径存放的路径
        System.out.println(is);
    }

    @Test   // 通过相对路径去获取文件
    public void test2(){
        InputStream is = RelativePath.class
                .getClassLoader()
                .getResourceAsStream("../../../test.txt");     // ../：返回上级目录
        System.out.println(is);
    }
}
