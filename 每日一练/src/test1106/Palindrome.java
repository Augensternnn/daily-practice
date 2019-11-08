package test1106;
/**
 * 每组输入数据共两行：第一行为字符串A，第二行为字符串B，字符串长度均小于100且只包含小写字母
 * 输出一个数字，表示把字符串B插入字符串A之后构成一个回文串的方法数
 */

import java.util.Scanner;

public class Palindrome {
    public static boolean isPalindrome(String s, int i, int j){
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int count = 0;
        if(isPalindrome(a+b, 0, a.length()+b.length()-1)){
            count++;
        }
        if(isPalindrome(b+a, 0, a.length()+b.length()-1)){
            count++;
        }
        for(int i = 1; i < a.length(); i++){
            if(isPalindrome(a.substring(0, i)+b+a.substring(i), 0, a.length()+b.length()-1)){
                count++;
            }
        }
        System.out.println(count);
    }
}
