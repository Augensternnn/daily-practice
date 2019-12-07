package test1207;

import java.util.Scanner;

public class ShouXingNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int x = in.nextInt();
            int n = x * x;
            int tmp = x;
            int len = 0;
            while (tmp > 0){
                tmp /= 10;
                len++;
            }
            StringBuilder s = new StringBuilder();
            while (len > 0){
                s.append(n % 10);
                n /= 10;
                len--;
            }
            String str = s.reverse().toString();
            int m = new Integer(str).intValue();
            if(x == Integer.parseInt(str)){
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }
        }
    }
}
