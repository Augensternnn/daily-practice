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
    public static int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }else {
            Arrays.sort(chars);
            int res=0,tmp=1,i=1;

            while (i<chars.length){
                if(chars[i-1] == chars[i]){
                    tmp++;
                    i++;
                }else {
                    if(tmp == 1){
                        res++;
                    }else {
                        String s = tmp+"";
                        for(int j = 0; j < s.length(); j++){
                            chars[++res] = s.charAt(j);
                        }
                    }
                    tmp = 1;
                    chars[++res] = chars[i];
                    i++;
                }
            }
            if(i==chars.length && tmp!=1){
                String s = tmp+"";
                for(int j = 0; j < s.length(); j++){
                    chars[res++] = s.charAt(j);
                }
            }
            System.out.println(chars);
            return res;
        }

    }

    public static void main(String[] args) {

        char[] chars = {'a','a','b','b','c','c','c'};
        int re = compress(chars);
        System.out.println(re);
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
