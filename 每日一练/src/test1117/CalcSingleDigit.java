package test1117;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalcSingleDigit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int[] arr = new int[str.length()];
        for(int i = 0 ; i < str.length(); i++){
            arr[i] = str.charAt(i)-'0';
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else
                map.put(arr[i], 1);
        }
        for(int i = 0; i < 10; i++){
            if(map.containsKey(i))
                System.out.println(i + ":" + map.get(i));
        }
    }
}
