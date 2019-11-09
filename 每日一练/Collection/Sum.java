package test1106;

import java.util.Scanner;

/*
    求 a+b 的和：多组读入，每行有两个数；每行输出一个结果
 */
public class Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a +b);
        }
    }
}
