package test;

import java.util.Arrays;
import java.util.Scanner;

//餐馆
public class Restaurant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] tab = new int[n];
        int[][] cons = new int[m][2];
        for(int i = 0; i < n; i++){
            tab[i] = sc.nextInt();
        }
        Arrays.sort(tab);
        for(int i = 0; i < m; i++){
            int b = sc.nextInt();
            int c = sc.nextInt();
            cons[i][0] = b;
            cons[i][1] = c;
        }

    }
}
