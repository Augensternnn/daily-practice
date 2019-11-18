package test1118;

import java.util.Arrays;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println();
    }
    public static String[] getGray(int n){
        String[] result = new String[(int)Math.pow(2,n)];
        if(n == 1){
            result[0] = "0";
            result[1] = "1";
            return result;
        }
        String[] last = getGray(n - 1);
        System.out.println(Arrays.toString(last));
        for(int i = 0; i < last.length; i++){
            result[i] = "0" + last[i];
            result[result.length - i - 1] = "1" + last[i];
        }
        return result;
    }
}
