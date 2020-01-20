import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {

    // Java中进行文件的处理操作需要本地操作系统支持
    // 若操作的是同名文件，可能出现延迟的问题，故：开发中尽可能避免文件重名

    @Test   // 路径、分隔符
    public void test() throws IOException {
        // 路径的构成：文件路径+文件名
        String path = "G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\";
        String name = "demo.txt";
        String pathname = path + name;

        // 路径分隔符：Windows下使用 \ ，Unix/Linux 系统下使用 /
        // 在使用路径分隔符时：采用File类的一个常量 public static final String separator 来描述
        // 例：
        // G:\Github\practice\Java
        // G: +File.separator+ Github +File.separator+ practice +File.separator+ Java
        System.out.println(File.separator);

        // 绝对路径：目录下的绝对位置，即：完整的描述文件位置的路径
            // 通常：http://www.sun.com/index.html 也代表一个URL绝对路径

        // 相对路径：相对于某个基准目录的路径
            // 使用相对路径创建文件
        File f = new File("a.txt");
        f.createNewFile();

        // 当前目录：JVM启动路径
            // "."或"./"代表当前目录
            // 获取当前 .java 文件的当前目录的完整路径（这个目录也是当前idea中JVM的启动路径）
        File file = new File(".");
        String absolutepath = file.getAbsolutePath();
        System.out.println(absolutepath);   // 输出：G:\Github\practice\Java\Collection\IO\. 注意有一个点号


    }

    @Test
    public void test1(){
        String pathname = "G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\demo.txt";

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
        File file = new File(pathname);
        if(file.exists()){
            file.delete();
            System.out.println("文件"+pathname+"存在，删除！");
        }else {
            try {
                file.createNewFile();
                System.out.println("文件"+pathname+"不存在，现已创建！");
            } catch (IOException e) {
                System.out.println("文件"+pathname+"创建失败！");
                e.printStackTrace();
            }
        }
    }

    @Test   // 创建指定一个或多个目录的路径、获取父路径
    public void test4(){
        String path = "G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\";
//        String dir_name = "demo_dir";   // 想要创建的目录
        String dir_name= "demo_dir\\dir1\\dir2\\dir3";     // 想要创建的目录路径
        String pathname = path + dir_name;
        File file = new File(pathname);

        if(!file.exists()){
//            file.mkdir();   // 创建一个空目录
            file.mkdirs();  // 创建一个可能具有多个目录的路径
        }else {
            System.out.println("路径已将存在，不需要创建！");
        }

        System.out.println("父路径："+file.getParent());   // 获取父路径
    }

    @Test   // 【重】
    public void test5() throws IOException {    // 获取父目录File对象，在父目录下创建文件
        String path = "G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\";
        String dir_name = "demo_dir\\dir1\\dir2\\demo.java";
        String pathname = path + dir_name;
        File file = new File(pathname);

        File pfile = file.getParentFile();  // 获取父目录File对象
        if(!pfile.exists()){    // 若路径不存在则创建
            pfile.mkdirs();
            // 获取File对象的绝对路径
            System.out.println("路径"+pfile.getAbsolutePath()+"不存在，创建");
        }
        if(!file.exists()){
            file.createNewFile();
        }

    }

    @Test   // 取得文件信息
    public void test6() throws IOException {
        String path = "G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\";
        String name = "demo.txt";
        String pathname = path + name;
        File file = new File(pathname);
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println("文件 "+name+" size："+file.length());

        System.out.println("文件 "+name+" 最近修改时间："+new Date(file.lastModified()));
    }

    @Test   // 列出一个目录的全部组成
    public void test7(){
        // 要操作的文件
        File file = new File("G:\\Github\\practice\\Java");
        // 保证存在且是一个目录
        if(file.exists() && file.isDirectory()){
            File[] res = file.listFiles();
            for(File f : res){
                System.out.println(f);
            }
        }
    }

    // 递归打印文件目录列表
        // File类的listFiles()方法只能列出本目录中的第一级目录
        // 要列出目录中所有级的信息，需要自己通过递归的模式来完成
    public static void main(String[] args) {
        File file = new File("G:\\Github\\practice\\Java");
        listAllFiles(file);
    }
    // 列出指定目录中的全部子目录信息
    public static void listAllFiles(File file){
        if(file.isDirectory()){ // 给定的file对象属于目录
            File[] res = file.listFiles();
            if(res != null){
                for(File f : res){
                    listAllFiles(f);
                }
            }
        }else { //给定的file是文件，直接打印
            System.out.println(file);
        }
    }

}
