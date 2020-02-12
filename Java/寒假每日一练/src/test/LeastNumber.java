package test;

import java.util.ArrayList;
import java.util.Arrays;

//最小的K个数
public class LeastNumber {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length == 0 || k == 0 || input.length < k){
            return list;
        }
        Arrays.sort(input);
        for(int i = 0; i < k; i++){
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        ArrayList list = GetLeastNumbers_Solution(arr,4);
        System.out.println(list);
    }
}
