package test1208;

import java.util.Scanner;

public class Draw {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt();
            float s1 = factorial(n);
            float s2 = errorRow(n);
            float result = (s2 / s1) * 100;
            System.out.println(String.format("%.2f", result) + "%");
        }
    }
    public static float factorial(int n){
        if(n == 0 || n ==1)
            return 1;
        else
            return n * factorial(n-1);
    }
    public static float errorRow(int n){
        if(n == 1){
            return 0;
        }else if(n == 2){
            return 1;
        }else {
            return (n-1)*(errorRow(n-1) + errorRow(n-2));
        }
    }
}
