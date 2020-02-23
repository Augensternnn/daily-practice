package test1202;

import java.util.Scanner;

public class Upgrade {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int monsters = in.nextInt();
            int a = in.nextInt();
            int[] arr = new int[monsters];
            int i = 0;
            while (i < monsters){
                arr[i++] = in.nextInt();
            }
            for(int j = 0; j < arr.length; j++){
                if(arr[j] <= a){
                    a += arr[j];
                }else {
                    a += maxCommonDivisor(arr[j], a);
                }
            }
            System.out.println(a);
        }
    }
    public static int maxCommonDivisor(int m, int n){
        if(m < n){      // 保证被除数大于除数
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0){
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }
}
