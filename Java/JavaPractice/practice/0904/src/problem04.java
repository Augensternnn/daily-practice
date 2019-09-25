import java.util.HashSet;
import java.util.Scanner;
import java.util.ServiceConfigurationError;
import java.util.Set;

public class problem04 {
    /*
    https://www.nowcoder.com/questionTerminal/f88dafac00c8431fa363cd85a37c2d5e
    坏键盘打字：旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出肯定坏掉的那些键。
    输入描述：
            输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
    输出描述：
    按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。保证至少有一个坏键
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expected = scanner.nextLine();
        String actual = scanner.nextLine();
        // set 是实际打印出的字符，全部大写
        Set<Character> set = new HashSet<>();
        // 不区分大小写，统一把字符串转为大写
        char[] a = actual.toUpperCase().toCharArray();
        for(char c : a){
            set.add(c);
        }
        char[] b = expected.toUpperCase().toCharArray();
        // 记录已经打印过的键
        Set<Character> brokenKeys = new HashSet<>();
        for(char c : b){
            if(!set.contains(c)){
                // c 对应的键是坏的
                if(!brokenKeys.contains(c)){
                    System.out.println(c);
                    brokenKeys.add(c);
                }
            }
        }
    }
}
