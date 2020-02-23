import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class day5 {
    // 217.存在重复元素
    public boolean containsDuplicate(int[] nums) {
        // 方法一
        return Arrays.stream(nums).distinct().count() != nums.length;

        // 方法二：set可去重
//        Set<Integer> res = new HashSet<>();
//        for(int i : nums)
//            res.add(i);
//        return res.size()<nums.length ? true : false;
    }

    // 925.长按键入
    public boolean isLongPressedName(String name, String typed) {
        if(name.length() > typed.length())
            return false;
        int i=0, j=0;
        while (i<name.length() && j<typed.length()){
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else if(j>0 && typed.charAt(j) == typed.charAt(j-1)){
                j++;
            }else {
                return false;
            }
        }
        return i==name.length();
    }
}
