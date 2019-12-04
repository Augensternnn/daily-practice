import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileInputStreamTest {
    @Test
    public void test1(){        // 字节流
        try {
            System.out.println(System.getProperty("user.dir"));
            // 这里相对路径：指在一个项目中，相对其他文件的路径
            File f = new File("src/test1.txt");    // 可以写 相对路径 或 绝对路径
            System.out.println(f.exists());

            // 读取文件：文件读取字节流
            FileInputStream fis = new FileInputStream(f);
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len=fis.read(bytes)) != -1){
                String s = new String(bytes, 0, len);
                System.out.println(s);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){        // 字符流
        try {
            System.out.println(System.getProperty("user.dir"));
            File f = new File("src/test1.txt");
            System.out.println(f.exists());

            // 读取文件：文件读取字符流
            FileReader fr = new FileReader(f);
            char[] chars = new char[1024];
            int len = 0;
            while((len=fr.read(chars)) != -1){
                String s = new String(chars, 0, len);
                System.out.println(s);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){        // 缓存文件操作流
        try {
            System.out.println(System.getProperty("user.dir"));
            File f = new File("src/test1.txt");
            System.out.println(f.exists());
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);

            byte[] bytes = new byte[1024];
            int len = 0;
            while((len=bis.read(bytes)) != -1){
                String s = new String(bytes, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4(){        // 字符流
        try {
            System.out.println(System.getProperty("user.dir"));
            File f = new File("src/test1.txt");
            System.out.println(f.exists());
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while((s=br.readLine()) != null){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5(){        // 写
        try {
            System.out.println(System.getProperty("user.dir"));
            File f = new File("src/test1.txt");
            System.out.println(f.exists());
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("1=123\n");
            bw.write("唐诗");
            bw.newLine();
            bw.write("宋词");
            bw.flush();     // 对缓冲区的数据直接执行写入操作，“刷新”到文件中
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6(){
        try {
            System.out.println(System.getProperty("user.dir"));
            File f = new File("G:\\Github\\practice\\JavaWeb\\io-learning\\test.txt");
            System.out.println(f.exists());
            FileInputStream fis = new FileInputStream(f);
            // 读取文件可以指定一种编码
            // 保存文件时是GBK编码，读取时也需要使用相应编码
            InputStreamReader isr = new InputStreamReader(
                    fis, "GBK");
            // 在不知道是什么类型时：
//            InputStreamReader isrr = new InputStreamReader(fis, StandardCharsets.US_ASCII);
//            char[] chars = new char[1024];
//            int len = 0;
//            while((len=isr.read(chars)) != -1){
//                System.out.println(new String(chars,0,len));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
}
