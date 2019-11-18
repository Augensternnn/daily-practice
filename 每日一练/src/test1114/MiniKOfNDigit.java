package test1114;

import java.util.Arrays;
import java.util.Scanner;

public class MiniKOfNDigit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String s = str.replace(" ","");
        int[] arr = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            arr[i] = Integer.valueOf(s.charAt(i));
        }
        Arrays.sort(arr);
        for(int i = 0; i <= arr[arr.length-1]; i++)
            System.out.printf(arr[i]+" ");
    }

}
