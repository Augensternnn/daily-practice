import java.util.ArrayList;
import java.util.Arrays;

public class day2 {
    public static int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length;
        while (i != j){
            if(nums[i] == val){
                if(nums[j] == val)
                    j--;
                nums[i] = nums[j];
                nums[j] = val;
                i++;
                j--;
            }else {
                i++;
            }
        }
        int l = 0;
        for(l = 0; l < nums.length; l++){
            if(nums[l] != val){
                l++;
            }else {
                break;
            }
        }
        return l+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
    }
}
