package _.nowcoder;

import java.util.Scanner;

/**
 * 说反话
 * https://www.nowcoder.com/questionTerminal/aced908691df4ebca6744f9fbd437749
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        String s = "";
        for(int i = strs.length-1; i >= 0; i--){
            if(i == 0){
                s += strs[i];
            }else {
                s += strs[i] + " ";
            }
        }
        System.out.println(s);
    }
}
