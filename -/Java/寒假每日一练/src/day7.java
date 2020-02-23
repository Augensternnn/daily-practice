import java.util.Arrays;

public class day7 {
    // 905.按奇偶排序数组
    public static int[] sortArrayByParity(int[] A) {
        // 偶数在前，奇数在后
        int i = 0, j = A.length-1;
        while (i < j){
            if(A[i]%2==0){
                i++;
            }else {
                while (A[j]%2 != 0 && j > i) {
                    j--;
                }
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
                j--;
                i++;
            }
        }
        return A;
    }

    // 724.寻找数组的中心索引
    public static int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for(int x : nums)
            sum += x;
        for(int i = 0; i < nums.length; i++){
            if(leftsum == sum - nums[i] -leftsum)
                return i;
            leftsum += nums[i];
        }
        return -1;
    }

}
