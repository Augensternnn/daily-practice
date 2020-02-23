package test1110;
/**
 * 有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，但这些物品的总体积必须是40。
 * John现在有n个想要得到的物品，每个物品的体积分别是a1，a2……an。
 * John可以从这些物品中选择一些，如果选出的物体的总体积是40，那么利用这个神奇的口袋，John就可以得到这些物品。
 * 现在的问题是，John有多少种不同的选择物品的方式。
 *
 * 输入：输入的第一行是正整数n (1 <= n <= 20)，表示不同的物品的数目。
 *       接下来的n行，每行有一个1到40之间的正整数，分别给出a1，a2……an的值。
 *输出：输出不同的选择物品的方式的数目。
 */

import java.util.Scanner;

public class MagicBag {
    static int[] weight;
    static int N;
    static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            N = in.nextInt();
            weight = new int[N+1];
            for(int i = 1; i <= N; i++){
                weight[i] = in.nextInt();
            }
            count(40,N);
            System.out.println(count);
        }
    }
    public static void count(int s, int n){
        // 正好装满
        if(s == 0){
            ++count;
            return;
        }
        // 若 s<0 或 n<1 则不能完成
        if(s<0 || (s>0 && n<1))
            return;
        count(s-weight[n], n-1);
        count(s, n-1);
    }
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(count(arr, n, 40));
    }

    static int count(int[] arr, int i, int s) {
        if (s == 0) {
            return 1;
        } else if (i == 1) {
            if (arr[i] == s) {
                return 1;
            } else
                return 0;
        } else if (arr[i] > s) {
            return count(arr, i - 1, s);
        } else
            return count(arr, i - 1, s - arr[i]) + count(arr, i - 1, s);
    }

     */

    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            in.nextLine();
        }
        int count = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length;i++){
            int tmp = arr[i];
            if(tmp == 40){
                count++;
            }
            for(int j = i+1; j < arr.length; j++){
                if (tmp + arr[j] == 40){
                    count++;
                }else if(tmp + arr[j] > 40){
                    continue;
                }else {
                    j++;
                }
            }
        }
        System.out.println(count);
    }
    */
}
