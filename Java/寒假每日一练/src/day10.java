import java.util.ArrayList;
import java.util.Arrays;

public class day10 {
    // 8.字符串转换整数(atoi )
    public static int myAtoi(String str) {
        if(str=="")
            return 0;
        String s = str.replace(" ","");
        if(s=="")
            return 0;
        long min=Integer.MIN_VALUE, max=Integer.MAX_VALUE;
        int index=1;
        if((s.charAt(0)=='-' || s.charAt(0)=='+') || (s.charAt(0)>='0' && s.charAt(0)<='9')){
            for(int i=1; i<s.length(); i++){
                if(s.charAt(i)>='0' && s.charAt(i)<='9')
                    index++;
                else break;
            }
            long n = Long.decode(s.substring(0,index));
            if(n < min){
                return (int)min;
            }else if(n > max){
                return (int)max;
            }else {
                return (int)n;
            }
        }else {
            return 0;
        }
    }

    // 34.在排序数组中查找元素的第一个和最后一个位置
    public static int[] searchRange(int[] nums, int target) {
        ArrayList list = new ArrayList();
        int[] arr = new int[2];
        for(int i = 0; i < nums.length; i++)
            list.add(nums[i]);
        if(list.indexOf(target)==-1){
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }else {
            arr[0] = list.indexOf(target);
            arr[1] = list.lastIndexOf(target);
            return arr;
        }
    }

    public static void main(String[] args) {
//        String s = "";
//        int n = myAtoi(s);
//        System.out.println(n);
        int[] nums = {5,6,7,8,9,1};

    }
}
