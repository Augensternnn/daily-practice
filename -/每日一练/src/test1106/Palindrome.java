package test1106;
/**
 * https://www.nowcoder.com/questionTerminal/9d1559511b3849deaa71b576fa7009dc
 */

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String a = in.nextLine();
            String b = in.nextLine();
            int count = 0;
            for(int i = 0; i <= a.length(); i++){
                StringBuilder sb = new StringBuilder(a);
                sb.insert(i, b);
                if(isPalindrome(sb.toString()))
                    count++;
            }
            System.out.println(count);
        }
    }
    public static boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while (i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }




//    public static boolean isPalindrome(String s, int i, int j){
//        while (i <= j) {
//            if (s.charAt(i) != s.charAt(j)) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String a = in.nextLine();
//        String b = in.nextLine();
//        int count = 0;
//        if(isPalindrome(a+b, 0, a.length()+b.length()-1)){
//            count++;
//        }
//        if(isPalindrome(b+a, 0, a.length()+b.length()-1)){
//            count++;
//        }
//        for(int i = 1; i < a.length(); i++){
//            if(isPalindrome(a.substring(0, i)+b+a.substring(i), 0, a.length()+b.length()-1)){
//                count++;
//            }
//        }
//        System.out.println(count);
//    }

}
