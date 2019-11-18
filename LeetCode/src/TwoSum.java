/**
 * https://leetcode-cn.com/problems/two-sum/
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // 方法一
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] == target - nums[i]){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    /*
    // 方法二
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int k = target - nums[i];
            if(map.containsKey(k) && map.get(k) != i){
                return new int[] {i, map.get(k)};
            }
        }
        return null;
//        throw new IllegalArgumentException("没有这两个数");
    }

    // 方法三
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int k = target - nums[i];
            if(map.containsKey(k))
                return new int[] {map.get(k), i};
            map.put(nums[i], i);
        }
        return null;
//        throw new IllegalArgumentException("没有这两个数");
    }

     */
}
