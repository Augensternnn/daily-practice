package test1106;

import java.util.Scanner;

/*
    给出n阶方阵里所有数，求方阵里所有数的和
    第一行为一个整数n(n <= 1000)，表示方阵阶数为n
    接下来是n行数字，每行n个数用空格隔开
 */
public class MatrixSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;
        int x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = in.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }
}
