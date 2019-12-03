package test1202;

import java.util.Arrays;
import java.util.Scanner;

public class HighScore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] arr = new int[n];
            int i = 0;
            while (i < n) {
                arr[i++] = in.nextInt();
            }
            for (int j = 1; j <= m; j++) {
                String s = in.next();
                int a = in.nextInt();
                int b = in.nextInt();
                switch (s) {
                    case "Q":
                        if (a > b) {
                            int t = a;
                            a = b;
                            b = a;
                        }
                        int[] ar = Arrays.copyOfRange(arr, a - 1, b);
                        Arrays.sort(ar);
                        System.out.println(ar[ar.length - 1]);
                    case "U":
                        arr[a - 1] = b;
                }
            }
        }
    }
}
