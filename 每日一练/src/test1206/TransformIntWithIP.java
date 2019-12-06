package test1206;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TransformIntWithIP {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.next();
//        int i = in.nextInt();
        String str = "10.0.3.193";
        int n = 167969729;
        String[] s = str.split("\\.");
        DecimalFormat df = new DecimalFormat("00000000");
        String res = "";
        for(int j = 0; j < s.length; j++ ){
            res = res + df.format(Integer.parseInt(Integer.toBinaryString(Integer.parseInt(s[j]))));
        }
        long ll = 0;
        for(int l = res.length()-1; l >= 0; l--){
            ll += (res.charAt(l)-'0')*Math.pow(2,res.length()-l-1);
        }
        System.out.println(ll);
        String ii = Integer.toBinaryString(n);
        int[] ar = new int[4];
        int mm = 0;
        for(int k = ii.length(); k >= 0; k --){
            String ss = df.format(ii.substring(k-8, k));
            for(int jj = 0; jj < ss.length(); jj++){

            }
        }
    }
}
