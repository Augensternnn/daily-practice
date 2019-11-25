package test1122;

import java.util.Scanner;

public class EatShell {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x0 = in.nextLong();
        long s = 100_000;
        long m = 1_000_000_007;

        long[] begin = new long[3];
        begin[0] = x0;
        begin[1] = (4 * begin[0] + 3) % m;
        begin[2] = (4 * begin[1] + 3) % m;

        long minStep = s;
        long cur = 0;
        int step = 0;
        for(int i = 0; i < 3; i++){
            cur = begin[i];
            step = i;
            while (cur != 0 && step < minStep){
                cur = (8 * cur + 7) % m;
                step++;
            }
            minStep = minStep < step ? minStep : step;
        }
        if(minStep < s){
            System.out.println(minStep);
        }else {
            System.out.println(-1);
        }
    }
}
