import java.util.Arrays;
import java.util.Stack;

public class day6 {
    // 977.有序数组的平方
    public static int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int i = 0;
        for(int temp : A){
            res[i++] = temp*temp;
        }
        Arrays.sort(res);
        return res;
    }

    // 917.仅仅反转字母
    public static String reverseOnlyLetters(String S) {
        // 法一：栈
//        Stack<Character> letters = new Stack<>();
//        for(char c : S.toCharArray()){
//            if(Character.isLetter(c))
//                letters.push(c);
//        }
//        String res = "";
//        for(char c : S.toCharArray()){
//            if(Character.isLetter(c))
//                res += letters.pop();
//            else
//                res += c;
//        }
//        return res;

        // 法二：双指针
        String res = "";
        int j = S.length()-1;
        for(int i = 0; i < S.length(); i++){
            if(Character.isLetter(S.charAt(i))){
                while (!Character.isLetter(S.charAt(j)))
                    j--;
                res += S.charAt(j--);
            }else {
                res += S.charAt(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "7_28]";
        String res = reverseOnlyLetters(s);
        System.out.println(res);
    }
}
