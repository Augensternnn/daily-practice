package test1108;

import java.util.Scanner;

/**
 * 读入一个字符串str，输出字符串str中的连续最长的数字串
 */
public class Longest_DigitsString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String maxStr = "";
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                count = 1;
                int index = i;
                for(int j = i + 1; j < s.length(); j++){
                    if(s.charAt(j) >= '0' && s.charAt(j) <= '9'){
                        count++;
                        index = j;
                    }else {
                        break;
                    }
                }
                if(count > maxStr.length()){
                    maxStr = s.substring(i, index+1);
                }
            }else {
                continue;
            }
        }
        System.out.println(maxStr);
    }
}
