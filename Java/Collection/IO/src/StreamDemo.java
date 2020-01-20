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
    @Test   // 复制文件(FileReader、FileWriter)
    public void test4() throws IOException {
        // 创建输入流对象
        FileReader fr = new FileReader("G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\Reader.txt");
        // 创建输出流对象
        FileWriter fw = new FileWriter("G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\ReaderCopy.txt");

        // 读写数据
        int ch;
        while ((ch=fr.read())!=-1)
            fw.write(ch);

        // 释放资源
        fw.close();
        fr.close();
    }

    @Test   // 文件拷贝(BufferedReader、BufferedWriter)
    public void test5() throws IOException {
        FileReader reader = new FileReader("G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\BufferedReader.txt");
        BufferedReader bReader = new BufferedReader(reader);
        FileWriter writer = new FileWriter("G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\BufferedReaderCpoy.txt");
        BufferedWriter bWriter = new BufferedWriter(writer);
        String content = "";
        // readLine 一行一行的读取
        while ((content=bReader.readLine())!=null){
            bWriter.write(content+"\r\n");  // \r\n 换行
        }
        /**
         *  关闭流的顺序：
         *  当 A 依赖 B 的时候：先关闭 A，再关闭 B
         *  带缓冲的流最后关闭的时候会执行一次 flush
         */
        reader.close();
        bReader.close();
        bWriter.close();
        writer.close();
    }

    @Test   // InputStreamReader
    public void test6(){
        // 执行的时候放main里比较好

        // 创建字节流对象； System.in 代表从控制台输入
        InputStream in = System.in;
        // 创建字符流对象
        BufferedWriter bw = null;
        BufferedReader br = null;

        try {
            // 实例化字符流对象：通过 InputStreamReader 将字节输入流转化成字符输入流
            br = new BufferedReader(new InputStreamReader(in));
//            br = new BufferedReader(new InputStreamReader(in,"GBK"));
            bw = new BufferedWriter(new FileWriter("G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\demo.txt"));
            // 定义读取数据的行
            String line = null;
            // 读取数据
            while ((line=br.readLine())!=null){
                // 如果输入是"exit"就退出
                if("exit".equals(line))
                    break;
                // 将数据写入文件
                bw.write(line);
                // 写入新的一行
                bw.newLine();
                // 刷新数据缓冲
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放资源
                try {
                    if(bw != null)
                        bw.close();
                    if(br != null)
                        br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

    @Test   // OutputStreamWriter
    public void test7(){
        // 定义字节输出流对象：System.out
        OutputStream out = System.out;
        // 定义字符流对象
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            // 通过 OutputStreamWriter 将字符流转换为字节流对象
            bw = new BufferedWriter(new OutputStreamWriter(out));
//        bw = new BufferedWriter(new OutputStreamWriter(out,"GBK"));
            br = new BufferedReader(new FileReader("G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\demo.txt"));
            // 定义读取行的字符串
            String line = null;
            // 读取数据
            while ((line=br.readLine())!=null){
                // 输出到控制台
                bw.write(line);
                // 新的一行
                bw.newLine();
                // 刷新缓冲
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            try {
                if(bw != null)
                    bw.close();
                if(br != null)
                    br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

    }
}
