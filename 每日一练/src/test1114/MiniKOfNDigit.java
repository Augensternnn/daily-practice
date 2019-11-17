package test1114;

import java.util.Arrays;
import java.util.Scanner;

public class MiniKOfNDigit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*String str = in.nextLine();
        String[] s = str.split(" ");
        Arrays.sort(s);
        for(int i = 0; i <= Integer.valueOf(s[s.length-1]); i++)
            System.out.printf(s[i]+" ");
        */
        StringBuilder sb = new StringBuilder();
        while(in.hasNextInt()){
            sb.append(in.nextInt());
            int n = (int)sb.charAt(sb.length()-1);
            int[] arr = new int[sb.length()-2];
            for(int i = 0; i < arr.length;i++){
                arr[i] = (int)sb.charAt(i);
            }
            for(int i = 0; i < arr.length; i++){
                System.out.println(arr[i]);
            }
        }


    }

}
