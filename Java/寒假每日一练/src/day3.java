import org.junit.Test;

public class day3 {
    @Test
    public void test1(){
        // 循环无限次
        int i = 7;
        do{
            System.out.println(--i);
            --i;
        }while (i != 0);
        System.out.println(i);
    }

    // 383.赎金信
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return false;
        StringBuilder mag = new StringBuilder(magazine);
        for(int i = 0; i < ransomNote.length(); i++){
            if(mag.indexOf(ransomNote.charAt(i)+"") == -1){
                return false;
            }else {
                mag.deleteCharAt(mag.indexOf(ransomNote.charAt(i)+""));
            }
        }
        if (mag.length() < 0){
            return false;
        }
        return true;
    }

    // 9.判断是不是回文数
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i = 0, j = s.length()-1;
        while (i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static int getValue(int i){
        // case 后面没有 break，执行完一个 case 后会继续执行下一个 case 语句，直到遇到 break 或 switch 结束
        int result = 0;
        switch (i){
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = getValue(2);
        System.out.println(n);
    }

}
