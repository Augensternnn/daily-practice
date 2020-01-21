import java.io.*;

/**
 * 观察乱码的产生
 * 若现在本地系统所用的编码与程序所用编码不同，那么强制转换就会出现乱码
 * 乱码产生的本质：编码和解码不统一产生的问题
 */
public class RandomCode {
    public static void main(String[] args) throws IOException, UnsupportedEncodingException {
        OutputStream out = new FileOutputStream(new File("G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\RandomCode.txt"));
        out.write("你好世界".getBytes("ISO8859-1"));
        out.close();
    }
}
