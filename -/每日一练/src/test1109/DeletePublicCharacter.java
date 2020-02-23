package test1109;

import java.lang.ref.SoftReference;
import java.util.Scanner;

/**
 * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
 * 例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
 * 输入：每个测试输入包含2个字符串
 * 输出：输出删除后的字符串
 */
public class DeletePublicCharacter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            char[] ch = in.nextLine().toCharArray();
            String str = in.nextLine();
            for(int i = 0; i <ch.length; i++){
                if(!str.contains(String.valueOf(ch[i]))){
                    System.out.println(ch[i]);
                }
            }
        }
    }
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            String pattern = '[' + s2 + ']';
            String result = s1.replaceAll(pattern,"");
            System.out.println(result);
        }
    }

     */
}
