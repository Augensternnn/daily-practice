package test1106;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/e016ad9b7f0b45048c58a9f27ba618bf
 */
public class FindKth {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 5};
        System.out.println(findKth(arr, 5, 3));
    }
    public static int findKth(int[] arr, int n, int k){
        
    }
//    public int findKth(int[] a, int n, int k){
//        return findKth(a, 0, n-1, k);
//    }
//    public int findKth(int[] a, int low, int high, int k){
//        int part = partition(a, low, high);
//        if(k == part - low + 1){
//            return a[part];
//        }else if(k > part - low + 1){
//            return findKth(a, part+1, high, k-part+low-1);
//        }else {
//            return findKth(a, low, part-1, k);
//        }
//    }
//    public int partition(int[] a, int low, int high){
//        int key = a[low];
//        while (low < high){
//            while (low < high && a[high] <= key){
//                high--;
//            }
//            a[low] = a[high];
//            while (low < high && a[low] >= key){
//                low++;
//            }
//            a[high] = a[low];
//        }
//        a[low] = key;
//        return low;
//    }
    /*
    public static int findKth(int[] array, int n, int k){
        Arrays.sort(array);
        return array[n - k];
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 2};
        System.out.println(findKth(arr, 5, 3));
    }
     */
}
