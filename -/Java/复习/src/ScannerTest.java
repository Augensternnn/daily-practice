
import org.junit.Test;

import java.util.Scanner;

public class ScannerTest {
    /**
     * 可以多次进行测试用例，在每个测试用例中，可以接收多行整数类型。如：
     * 第一行输入3
     * 第二行输入4 5 6
     * 第三行输入4 1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        // 全整形输入，建议使用hasNextInt()搭配nextInt()
        // 浮点数字类型，可以使用hasNextDouble()搭配nextDouble()，
        // 或者使用精度更好的hasNextBigDecimal()搭配nextBigDecimal()
        // 此外，也可以使用hasNextLine()搭配nextLine()自行解析整行数据
        while(sc.hasNextInt()){
            System.out.println("第"+(++index)+"次");

            int i1 = sc.nextInt();
            System.out.print("i1="+i1);

            int i2 = sc.nextInt();
            System.out.print(",i2="+i2);

            int i3 = sc.nextInt();
            System.out.print(",i3="+i3);

            int i4 = sc.nextInt();
            System.out.print(",i4="+i4);

            int i5 = sc.nextInt();
            System.out.print(",i5="+i5);

            int i6 = sc.nextInt();
            System.out.print(",i6="+i6);

            System.out.println();
        }
    }
}
