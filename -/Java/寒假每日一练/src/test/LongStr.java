package test;

import java.util.Scanner;

//字符串中找出连续最长的数字串
public class LongStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String tmp = "",res = "";
        for(int i = 0; i <s.length(); i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                tmp += s.charAt(i);
            }else {
                if(res.length()<tmp.length())
                    res = tmp;
                tmp="";
            }
        }
        if(res.length()<tmp.length())
            res = tmp;
        System.out.println(res);
    }
}
