import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StringWriterTest {
    @Test
    public void test(){
        try {
            throw new RuntimeException("出错了");
        } catch (Exception e) {
            e.printStackTrace();    // 异常直接输出到控制台，有堆栈信息
            // e.getMessage()：获取自定义的输入的信息，但是没有堆栈信息
//            System.out.println(e.getMessage());

            // 输出到文件
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            System.out.println(sw.toString());
        }
    }
}
