import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    @Test
    public void test1(){
        // 路径的构成：文件路径+文件名
        String path = "G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\";
        String name = "demo.txt";
        String pathname = path + name;

        File file= new File(pathname);

        boolean res = file.exists();
        System.out.println("文件"+pathname+"是否存在："+res);

        res = file.isDirectory();
        System.out.println("文件"+pathname+"是否是目录："+res);

        res = file.isFile();
        System.out.println("文件"+pathname+"是否是文件："+res);

        file.delete();
        if(!file.exists()){
            System.out.println("删除文件成功！");
        }else {
            System.out.println("删除文件失败！");
        }
    }

    @Test   // 创建新文件
    public void test2(){
        // File 类只是创建文件本身，对其内容不做处理
        String pathname = "G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\demo.txt";
        File file = new File(pathname);
        if(!file.exists()){
            try {
                // 有创建失败的风险，需要捕捉异常
                file.createNewFile();
            } catch (IOException e) {
                // 文件部分异常，常见为 IOException
                System.out.println("文件"+pathname+"创建失败");
//                e.printStackTrace();
            }
        }else {
            System.out.println("文件"+pathname+"已经存在，不需创建");
        }
    }

    @Test   // 编写文件基本操作（文件不存在则创建，存在则删除）
    public void test3(){
        String pathname = "G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\demo.txt";
    }

    @Test
    public void test4(){
        String pathname = "G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\demo.txt";
    }

    @Test
    public void test5(){
        String pathname = "G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\demo.txt";

    }

    @Test
    public void test6(){

    }

    @Test
    public void test7(){

    }

    @Test
    public void test8(){

    }

    @Test
    public void test9(){

    }


}
