import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.sort;

/*
https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int c = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int tmp = nums[i] + nums[j];
                int index = j + 1;
                while (index < nums.length){
                    if(nums[index] == (-1*tmp)){
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[index]);
                        Collections.sort(l);
                        list.add(c, l);
                        c++;
                    }
                    index++;
                }
            }
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] num = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(num));
    }
}
