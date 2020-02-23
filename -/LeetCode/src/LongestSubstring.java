import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        String longestStr = "";
        int i = 0, j = i + 1;
        while (i < j) {
            if (i < s.length() && j < s.length()) {
                String str = s.substring(i, j);
                if (!str.contains(s.subSequence(j,j+1))) {
                    String strr = str + s.charAt(j);
                    if ((j - i + 1) > longestStr.length())
                        longestStr = strr;
                    j+=1;
                }else {
                    i++;
                    j = i + 1;

                }
            }else
                break;
        }
        if(longestStr.length() == 0 && s.length() != 0)
            longestStr += s.charAt(0);
        return longestStr.length();
    }

//    public static int lengthOfLongestSubstring(String s) {
//        if(s.length() == 0)
//            return 0;
//        String longestStr = "";
//        int i = 0, j = i + 1;
//        while (i < j) {
//            if (i < s.length() && j < s.length()) {
//                StringBuilder str = new StringBuilder(s.substring(i, j));
//                String ss = str.toString();
//                if (!ss.contains(s.subSequence(j,j+1))) {
//                    str.append(s.charAt(j));
//                    if ((j - i + 1) > longestStr.length())
//                        longestStr = str.toString();
//                    j+=1;
//                }else {
//                    i++;
//                    j = i + 1;
//                }
//            }else
//                break;
//        }
//        if(longestStr.length() == 0 && s.length() != 0)
//            longestStr += s.charAt(0);
//        return longestStr.length();
//    }


    // 暴力法
    /*
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for(int j = i + 1; j <= n; j++)
                if(allUnique(s, i, j))
                    ans = Math.max(ans, j-i);
        return ans;
    }
    public boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for(int i = start; i < end; i++){
            char ch = s.charAt(i);
            if(set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }

     */

    // 滑动窗口
    /*
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else
                set.remove(s.charAt(i++));
        }
        return ans;
    }

     */

    // 优化的滑动窗口
    /*
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j = 0, i = 0; j < n; j++){
            if(map.containsKey(s.charAt(j)))
                i = Math.max(map.get(s.charAt(j)), i);
            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }

        // int [26]：用于字母 'a' - 'z' 或 'A' - 'Z'； int [128]：用于ASCII码； int [256]：用于扩展ASCII码
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for(int j = 0, i = 0; j < n; j++){
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j-i+1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

     */
}
