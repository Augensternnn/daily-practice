package test1115;

/**
 *  输入一个正整数n,求n!(即阶乘)末尾有多少个0
 *  比如: n = 10; n! = 3628800,所以答案为2
 *  输入：输入为一行，n(1 ≤ n ≤ 1000)
 *  输出：输出一个整数,即题目所求
 */

import java.util.Scanner;

public class CalcZero {
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long nFact = 1;
        for (int i = 1; i <= n; i++) {
            nFact *= i;
        }
        String s = "" + nFact;
        int c = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == '0') {
                c++;
            } else
                break;
        }
        System.out.println(c);
    }

     */
}
