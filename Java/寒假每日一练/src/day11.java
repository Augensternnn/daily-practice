import java.util.Arrays;

public class day11 {
    // 125.验证回文串
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i<j){
            while (i<j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while (i<j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // 443.压缩字符串
//    public int compress(char[] chars) {
//        Arrays.sort(chars);
//        int res=1,tmp=1;
//        for(int i = 0; i < chars.length; i++){
//            if(chars[i+1] == chars[i]){
//                tmp++;
//            }else {
//                chars[res] = (char)tmp;
//            }
//        }
//    }

    public static void main(String[] args) {
        int num = 10;
//        System.out.println(test(num));  // 30
        char c = (char)(num+'0');
        System.out.println(c);

    }
    public static int test(int b){
        try {
            b += 10;
            return b;
        }catch (RuntimeException e) {

        } catch (Exception e2) {

        } finally {
            b+=10;
            return b;
        }
    }
}
