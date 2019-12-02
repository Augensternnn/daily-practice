import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        // 实际项目部署环境可能与开发环境不同，因此路径分隔符可能不同
        // Windows下使用的是 \ ，Unix/Linux系统下使用的是 /
        // 故在使用路径分隔符时，采用File类的一个常量 public static final String separator 来描述

        // 查看自己平台的路径分隔符
        System.out.println(File.separator);
    }
    @Test
    public void test1(){
        // 注意最后的\\拼接，不是必须的
        // 路径构成：文件路径 + 文件名
        String path = "G:\\Github\\practice\\JavaWeb\\io-learning\\";
        String name = "demo.txt";
        String pathname = path + name;

        File file = new File(pathname);

        boolean res = file.exists();
        System.out.println("文件" + pathname + "是否存在：" + res);

        res = file.isDirectory();
        System.out.println("文件" + pathname + "是否是目录：" + res);

        res = file.isFile();
        System.out.println("文件" + pathname + "是否是文件：" + res);

        file.delete();
        if(!file.exists())
            System.out.println("删除文件成功！");
        else
            System.out.println("删除文件失败！");
    }

    @Test
    public void test2(){
        String pathname = "G:\\Github\\practice\\JavaWeb\\io-learning\\demo1.txt";
        File file = new File(pathname);
        File file1 = new File(pathname);
        if(!file1.exists()){
            try {
                file1.createNewFile();
            } catch (IOException e) {   // 文件部分异常，常见为IOException
                //e.printStackTrace();
                System.out.println("文件" + pathname + "创建失败");
            }
        }else {
            System.out.println("文件" + pathname + "已经存在，不需创建");
        }
    }

    @Test
    public void test3(){
        String pathname = "G:\\Github\\practice\\JavaWeb\\io-learning\\demo2.txt";
        File file = new File(pathname);
        if(file.exists()){
            file.delete();
            System.out.println("文件" + pathname + "存在，已经删除！");
        }else {
            // 文件不存在，创建
            try {
                file.createNewFile();
                System.out.println("文件" + pathname + "不存在，已经创建！");
            } catch (IOException e) {   // 文件部分异常，常见为IOException
                System.out.println("文件" + pathname + "创建失败");
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4(){
        String path = "G:\\Github\\practice\\JavaWeb\\io-learning\\";
//        String dir_name = "demo_dir";   // 想要创建的目录
        String dir_name = "demo_dir\\dir1\\dir2\\dir3";     // 想要创建的目录路径
        String pathname = path + dir_name;

        File file = new File(pathname);
        if(!file.exists()){
            file.mkdir();   // 创建一个空目录
            file.mkdirs();  // 创建一个可能具有多个目录的路径
        }else {
            System.out.println("路径已经存在，不需要创建");
        }
    }

    @Test
    public void test5() throws IOException {
        String pathname = "G:\\Github\\practice\\JavaWeb\\io-learning\\demo_dir\\dir1\\dir2\\demo.java";
        File file = new File(pathname);

        File pfile = file.getParentFile();  // 获取父目录File对象
        if(!pfile.exists()){    // 检测路径是否存在，不存在创建
            pfile.mkdirs();
            // 获取File对象的绝对路径
            System.out.println("路径" + pfile.getAbsolutePath() + "不存在，已经创建");
        }
        if(!file.exists()){
            file.createNewFile();
        }
    }
}
