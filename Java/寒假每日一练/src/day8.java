import java.util.Arrays;

public class day8 {
    // 66.加一
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >= 0; i--){
            if(digits[i]!=9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] arr = new int[digits.length+1];
        arr[0] = 1;
        return arr;
    }

    // 414.第三大的数
    public static int thirdMax(int[] nums) {
        int[] arr = Arrays.stream(nums).distinct().toArray();
        Arrays.sort(arr);
        if(arr.length<3)
            return arr[arr.length-1];
        else
            return arr[arr.length-3];
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        int a = thirdMax(nums);
        System.out.println(a);
    }
}
