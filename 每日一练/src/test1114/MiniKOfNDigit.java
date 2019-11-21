package test1114;
/**
 * 找出n个数里最小的k个
 * 输入：每个测试输入包含空格分割的 n+1 个整数，最后一个整数为 k 值，n 不超过100
 * 输出：升序输出n个整数里最小的k个数
 */

import java.util.Arrays;
import java.util.Scanner;

public class MiniKOfNDigit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            String[] s = str.split(" ");
            int[] num = new int[s.length - 1];
            for (int i = 0; i < s.length - 1; i++)
                num[i] = Integer.parseInt(s[i]);
            int k = Integer.parseInt(s[s.length - 1]);
            Arrays.sort(num);
            for(int i = 0; i < k; i++)
                System.out.print(i==k-1 ? num[i] : num[i]+" ");
        }
    }

    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            String[] s = str.split(" ");
            int[] num = new int[s.length - 1];
            for(int i = 0; i < num.length; i++)
                num[i] = Integer.parseInt(s[i]);
            int k = Integer.parseInt(s[s.length - 1]);
            int start = 0;
            int end = num.length - 1;
            int index = qSort(num, start, end);
            while (index != k){
                if(index > k){
                    end = index - 1;
                    index = qSort(num, start, end);
                }else {
                    start = index + 1;
                    index = qSort(num, start, end);
                }
            }
            Arrays.sort(num, 0, k);
            for(int i = 0; i < k; i++)
                System.out.println(i==k-1 ? num[i] : num[i]+" ");
        }
    }
    public static int qSort(int[] num, int start, int end){
        int dig = num[start];
        while (start < end){
            while (start < end && num[end] >= dig)
                end--;
            num[start] = num[end];
            while (start < end && num[start] < dig)
                start++;
            num[end] = num[start];
        }
        num[start] = dig;
        return start;
    }

     */
}
