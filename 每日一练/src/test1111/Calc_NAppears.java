package test1111;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入n个整数，输出出现次数大于等于数组长度一半的数
 * 输入：每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2
 * 输出：输出出现次数大于等于n/2的数
 */
public class Calc_NAppears {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s = s1.replace(" ","");
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length(); i++){
            int c = map.getOrDefault(s.charAt(i), 0);
            map.put((int)s.charAt(i), c+1);
        }
        double z = Math.ceil(s.length()/2);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() >= z){
                System.out.println(entry.getKey());
            }
        }
    }
}
