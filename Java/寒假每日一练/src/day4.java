import java.util.Arrays;

public class day4 {
    // 58.最后一个单词的长度
    public static int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        if(str.length == 0) {
            return 0;
        }else {
            String lastWord = str[str.length-1];
            return lastWord.length();
        }


    }

    // 88.合并两个有序数组
    // 给定两个有序数组 nums1 和 nums2，将 nums2 合并到 nums1 中
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }

    public static void main(String[] args) {
//        int i = switchit(4);
//        System.out.println("value=" + i);
        int[] n1 = {1,2,4,5,6,0};
        int[] n2 = {3};
        merge(n1,5,n2,1);
    }
    public static int switchit(int x){
        int j = 1;
        switch (x){
            case 1:j++;
            case 2:j++;
            case 3:j++;
            case 4:j++;
            case 5:j++;
            default:j++;
        }
        return j+x;
    }
}
