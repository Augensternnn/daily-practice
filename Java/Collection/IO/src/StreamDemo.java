import org.junit.Test;

import java.io.*;

public class StreamDemo {
    // 流：一组有顺序、有起点和终点的字节集合，即数据在两设备间的传输
    // 文件既可以作为输入设备，也可以作为输出设备
    // 字节流：8位的字节，数据流中最小数据单元是字节      InputStream、OutputStream
    // 字符流：16位的字节，数据流中最小数据单元是字符     Reader、Writer
    // File类不支持文件内容处理，若要处理文件内容，须通过流的操作模式来完成

    // 字节流
    @Test   // 复制图片
    public void test1() throws IOException {
        FileInputStream fin = new FileInputStream("G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\test.jpg");
        FileOutputStream fout = new FileOutputStream("G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\testCopy.jpg");
        int len = 0;
        byte[] buff = new byte[1024];
        while ((len=fin.read(buff))!=-1){
            fout.write(buff,0,len);
        }
        fin.close();
        fout.close();
    }

    @Test   // 文件拷贝
    public void test2() throws IOException {
        File file = new File("G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\buffer.txt");
        if(!file.isFile()) {
            System.out.println("is not a file");
            return;
        }
        BufferedInputStream bfis = new BufferedInputStream(new FileInputStream(file));
//        BufferedOutputStream bfos = new BufferedOutputStream(new FileOutputStream("src\\"+file.getName()));     // copy到src目录下
        BufferedOutputStream bfos = new BufferedOutputStream(new FileOutputStream("G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\buffercopy.txt"));
        byte[] bytes = new byte[1024];
        int temp = 0;    // 边读边写
        while ((temp=bfis.read(bytes))!=-1){     // 读
            bfos.write(bytes,0,temp);       // 写
        }
        bfos.flush();
        bfos.close();
        bfis.close();
        System.out.println("copy成功！");
    }

    @Test   // 有无缓冲，效率对比(读为例)
    public void test3() throws IOException {
        File file = new File("G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\demo.txt");
        // 缓冲流
        BufferedInputStream bfis = new BufferedInputStream(new FileInputStream(file));
        int temp = 0;
        long time = System.currentTimeMillis();     // 获取当前时间至1970-1-1的毫秒数
        while ((temp=bfis.read())!=-1){
//            System.out.println((char)temp);
        }
        time = System.currentTimeMillis()-time;
        bfis.close();
        System.out.println("缓冲流读："+time+"ms");

        // 非缓冲
        FileInputStream fis = new FileInputStream(file);
        temp = 0;
        time = System.currentTimeMillis();
        while ((temp=fis.read())!=-1){
//            System.out.println((char)temp);
        }
        time = System.currentTimeMillis()-time;
        fis.close();
        System.out.println("非缓冲区读："+time+"ms");
    }

    // 字符流
    
}
