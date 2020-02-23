package test1106;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有一个整数数组，根据快排的思路，找出数组找中第K大的数
 * 给定一个整数数组a，同时给定它的大小n和要找的K(k在1到n之间)，请返回第k大的数，保证答案存在
 */
public class FindKth {
    public int findKth(int[] a, int n, int k){
        return findKth(a, 0, n-1, k);
    }
    public int findKth(int[] a, int low, int high, int k){
        int part = partition(a, low, high);
        if(k == part - low + 1){
            return a[part];
        }else if(k > part - low + 1){
            return findKth(a, part+1, high, k-part+low-1);
        }else {
            return findKth(a, low, part-1, k);
        }
    }
    public int partition(int[] a, int low, int high){
        int key = a[low];
        while (low < high){
            while (low < high && a[high] <= key){
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] >= key){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }
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