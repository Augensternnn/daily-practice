public class day9 {
    // 1.两数之和
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

    // 67.二进制求和
    public static String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int tmp = 0;
        int i = a.length()-1, j = b.length()-1;
        int len = Math.max(a.length(),b.length());
        while (len-- > 0) {
            int sum = a.charAt(i) + b.charAt(j) + tmp - 96;
            s.append(sum % 2);
            tmp = sum / 2;
            if (i > 0 && j == 0) {
                i--;
                b = "0";
            }else if (j > 0 && i == 0){
                j--;
                a = "0";
            }else {
                i--;
                j--;
            }
        }
        if(tmp == 1)
            s.append(1);
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        String s = addBinary(a,b);
        System.out.println(s);
    }
}
