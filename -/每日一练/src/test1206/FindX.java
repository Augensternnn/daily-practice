package test1206;

import java.util.Scanner;

public class FindX {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt();
            int[] arr = new int[n];
            int i = 0;
            while (i < n){
                arr[i++] = in.nextInt();
            }
            int x = in.nextInt();
            boolean signal = false;
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == x){
                    System.out.println(j);
                    signal = true;
                    break;
                }
            }
            if(signal == false){
                System.out.println(-1);
            }
        }
    }
}
