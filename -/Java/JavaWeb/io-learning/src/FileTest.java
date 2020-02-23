import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileTest {
    @Test
    public void test1() throws IOException {
//            // 路径复制过来中间变为两个 \ （Windows系统需要两个 \ 支持）
//            // \\ 可以用 / 替换，两个也可以同时在一个路径中使用
//        new File("G:/Github/practice\\JavaWeb/io-learning");
        File file = new File("G:\\Github/practice\\JavaWeb\\io-learning\\fileTest.txt");
        System.out.println(file.exists());
        File f2 = new File("test1.txt");
        System.out.println("f2 = " + f2.exists());

        // 不建议采取这种方式（相对路径）来创建文件，除非对相对路径有把握
        // 创建的文件不一定在期望路径下
        // 若已经创建了text2.txt，再次执行还能继续创建成功，新创建的text2.txt会把之前的覆盖掉
        File f3 = new File("test2.txt");
        f3.createNewFile();

        File g = new File("g:/");
        for(File f : g.listFiles()){    // listFiles()：返回一个File类型的数组
            System.out.println(f.getPath());    // getPath()：获取文件路径     $RECYCLE.BIN：回收站
        }
    }

    @Test
    public void test2(){
        // 实现一个方法，把某个目录所有子文件夹和子文件获取并打印
        File dir = new File("G:\\Github");
        List<File> files = listFiles(dir);
        // Lambda表达式：
//        files.stream().forEach(System.out::println);    // 打印不出来路径
        files.stream()
                .forEach((f)->{
                    System.out.println(f.getPath());
                });
    }
    public List<File> listFiles(File file){
        List<File> list = new ArrayList<>();
        list.add(file);
        if(file.isDirectory()){
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    list.addAll(listFiles(f));
                }else{
                    list.add(f);
                }
            }
        }
        return list;
    }
//    public void listFiles(File file){
//        System.out.println(file.getPath());
//        if(file.isDirectory()){
//            for(File f : file.listFiles()){   // 这个写法不严谨，如果该文件夹下没有文件，可能会有问题
//                if(f.isDirectory()){
//                    // 如果是文件夹：listFiles()
//                    listFiles(f);
//                }else {
//                    // 如果是文件：打印
//                    System.out.println(f.getPath());
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        test3();
    }
    public static void test3(){
        // 给定多个测试用例，每个测试用例输入如下：
        // 4
        // 5 6 7
        // 11
        // 输出是这样的：
        // abc
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            System.out.println("hasNext");
                // nextInt()：是阻塞式方法
            int i1 = sc.nextInt();
//            System.out.println("i1");
            int i2 = sc.nextInt();
//            System.out.println("i2");
            int i3 = sc.nextInt();
//            System.out.println("i3");
            int i4 = sc.nextInt();
//            System.out.println("i4");
            int i5 = sc.nextInt();
//            System.out.println("i5");
            // 流操作：
            // 1.要么对于每个有明确结束标识api的api，需要明确返回这个标识，对于scanner就是换行符
            // 2.流关闭
            System.out.println("abc");
        }
    }
}
