package test1206;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TransformIntWithIP {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.next();
//        int i = in.nextInt();
        String str = "10.0.3.193";
        int ip = 167969729;
        String[] s = str.split("\\.");
        DecimalFormat df = new DecimalFormat("00000000");
        String res = "";
        for(int j = 0; j < s.length; j++ ){
            res = res + df.format(Integer.parseInt(Integer.toBinaryString(Integer.parseInt(s[j]))));
        }
        long result1 = 0;
        for(int l = res.length()-1; l >= 0; l--){
            result1 += (res.charAt(l)-'0')*Math.pow(2,res.length()-l-1);
        }
        System.out.println(result1);
        String str2 = Integer.toBinaryString(ip);
        int[] ar = new int[4];
        int jj = 0;
        int index = str2.length();
        while (jj < 4){
            String ss = null;
            if(str2.substring(0, index).length() >= 8) {
                ss = str2.substring(index - 8, index);
            }else {
                ss = str2.substring(0, index);
            }
            int ii = 0;
            for(int m = ss.length()-1; m >= 0; m--){
                ii += (ss.charAt(m)-'0')*Math.pow(2, ss.length()-m-1);
            }
            ar[jj++] = ii;
            index -= 8;
        }
        for(int i = ar.length-1; i >= 0; i--){
            if(ar[i] == ar[0])
                System.out.print(ar[0]);
            else
                System.out.print(ar[i] + ".");
        }
    }
}
