import java.util.HashSet;
import java.util.Set;

public class problem03 {
    /*
    宝石与石头
    给定字符串 J（代表石头中宝石的类型）和字符串 S（代表你拥有的石头），S 中每个字符代表了一种你拥有的石头的类型
    求：你拥有的石头中有多少是宝石
    J 中的字符不重复，J 和 S 中的所有字符都是字母。字母区分大小写，因此：A 和 a 是不同类型的石头
     */
    public int numJewelsInStones(String j,String s){
        Set<Character> jewels = new HashSet<>();
        for(char ch : j.toCharArray()){
            jewels.add(ch);
        }
        int count = 0;
        for(char ch : s.toCharArray()){
            if(jewels.contains(ch)){
                count++;
            }
        }
        return count;
    }
}
