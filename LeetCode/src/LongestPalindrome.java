public class LongestPalindrome {
//    public static String longestPalindrome(String s) {
//        String maxPali = "";
//        for(int i = 0; i < s.length(); i++){
//            for(int j = i+1; j <= s.length(); j++){
//                String str = s.substring(i, j);
//                if(isPalindrome(str) && str.length() > maxPali.length())
//                    maxPali = str;
//            }
//        }
//        return maxPali;
//    }
//    private static boolean isPalindrome(String s){
//        int i = 0;
//        int j = s.length() - 1;
//        while (i < j){
//            if(s.charAt(i) != s.charAt(j))
//                return false;
//            i++;
//            j--;
//        }
//        return true;
//    }

    // 最长公共子串
    public static String longestPalindrome(String s) {
        if(s.equals(""))
            return "";
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0, maxEnd = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                if(s.charAt(i) == reverse.charAt(j)){
                    if(i==0 || j==0){
                        arr[i][j] = 1;
                    }else {
                        arr[i][j] = arr[i-1][j-1]+1;
                    }
                }
                if(arr[i][j] > maxLen){
                    maxLen = arr[i][j];
                    maxEnd = i;
                }
            }
        }
        return s.substring(maxEnd-maxLen+1, maxEnd+1);
    }





    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }
}
