import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum1(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while(i < nums.length - 2){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                while (j < k && nums[i] + nums[j] + nums[k] < 0){
                    j++;
                }
                if(j >= k){
                    break;
                }
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> e = new ArrayList<>();
                    e.add(nums[i]);
                    e.add(nums[j]);
                    e.add(nums[k]);
                    result.add(e);
                    while (j < k && nums[j] == nums[j + 1]){
                        j++;
                    }
                    j++;
                }
                while (j < k && nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }
                if(j >= k){
                    break;
                }
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> e = new ArrayList<>();
                    e.add(nums[i]);
                    e.add(nums[j]);
                    e.add(nums[k]);
                    result.add(e);
                    while (j < k && nums[k] == nums[k - 1]){
                        k--;
                    }
                    k--;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]){
                i++;
            }
            i++;
        }
        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if (s < 0) {
                    j++;
                } else if (s > 0) {
                    k--;
                } else {
                    List<Integer> e = new ArrayList<>();
                    e.add(nums[i]);
                    e.add(nums[j]);
                    e.add(nums[k]);
                    result.add(e);
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if (s < 0) {
                    j++;
                } else if (s > 0) {
                    k--;
                } else {
                    List<Integer> e = new ArrayList<>();
                    e.add(nums[i]);
                    e.add(nums[j]);
                    e.add(nums[k]);
                    result.add(e);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
