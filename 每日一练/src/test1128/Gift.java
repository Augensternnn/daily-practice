package test1128;

import java.util.Arrays;

public class Gift {
    public int getValue(int[] gifts, int n) {
        Arrays.sort(gifts);
        if(gifts[n/2 - 1] == gifts[n/2]){
            return gifts[n/2];
        }else{
            return 0;
        }
    }
}
