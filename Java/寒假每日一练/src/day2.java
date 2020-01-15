import java.util.ArrayList;
import java.util.Arrays;

public class day2 {
    // 给定一个数组 nums 和一个值 val，原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
    // 不要使用额外的数组空间，元素的顺序可以改变
    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }else {
            int i = 0, j = nums.length-1;
            while (i < j){
                if(nums[i] == val){
                    while (i<j && nums[j] == val){
                        j--;
                    }
                    nums[i] = nums[j];
                    nums[j] = val;
                    i++;
                    j--;
                }else {
                    i++;
                }
            }
            int n = 0;
            for(int l = 0; l < nums.length; l++){
                if(nums[l] != val){
                    n++;
                }else {
                    break;
                }
            }
            return n;
        }
    }

    // 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    // 数组中无重复元素
    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }else if(nums[nums.length-1] == target){
            return nums.length;
        }else {
            ArrayList arr = new ArrayList(Arrays.asList(nums));
            if(arr.indexOf(target) != -1){
                return arr.indexOf(target);
            }else {
                int i = target+1;
                while (nums[i] == -1){
                    i++;
                }
                    return arr.indexOf(i);
            }
        }

    }


    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int n = searchInsert(nums,5);
        System.out.println(n);
    }
}
