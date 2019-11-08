package test1106;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有一个整数数组，根据快排的思路，找出数组找中第K大的数
 * 给定一个整数数组a，同时给定它的大小n和要找的K(k在1到n之间)，请返回第k大的数，保证答案存在
 */
public class FindKth {
    public static int findKth(int[] array, int n, int k){
        Arrays.sort(array);
        return array[n - k];
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 2};
        System.out.println(findKth(arr, 5, 3));
    }
}