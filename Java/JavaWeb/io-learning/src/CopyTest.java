import org.junit.Test;

import java.io.*;

public class CopyTest {
    @Test
    public void test1(){        // 拷贝
        try {
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                File f = new File("E:\\新概念\\三\\lesson (03)\\25.Lesson 3 课文讲解4.flv");
                fis = new FileInputStream(f);
                File dest = new File("G:\\Github\\practice\\JavaWeb\\io-learning/1.flv");
                fos = new FileOutputStream(dest);
                byte[] bytes = new byte[1024];
                int len = 0;
                while((len=fis.read(bytes))!=-1){
                    fos.write(bytes, 0, len);
                }
            } finally {
                if(fis != null)
                    fis.close();
                if(fos != null)
                    fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        try {
            FileInputStream fis = null;
            FileOutputStream fos = null;
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                File f = new File("E:\\新概念\\三\\lesson (03)\\25.Lesson 3 课文讲解4.flv");
                fis = new FileInputStream(f);
                bis = new BufferedInputStream(fis);
                File dest = new File("G:\\Github\\practice\\JavaWeb\\io-learning/1.flv");
                fos = new FileOutputStream(dest);
                bos = new BufferedOutputStream(fos);

                byte[] bytes = new byte[1024];
                int len = 0;
                while((len=fis.read(bytes))!=-1){
                    fos.write(bytes, 0, len);
                }
                bos.flush();
            } finally {
                if(fis != null)
                    fis.close();
                if(fos != null)
                    fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
