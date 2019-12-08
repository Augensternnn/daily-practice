package test1208;

import java.util.Scanner;

public class AddNum {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int sum = in.nextInt();
        int n = 5;
        int sum = 15;
        int[] arr = {5, 5, 10, 2, 3};
//        int[] arr = new int[n];
//        int i = 0;
//        while (i < n){
//            arr[i++] = in.nextInt();
//        }
        int count = 0;
        for(int j = 0; j < arr.length; j++){
            if(arr[j] == sum){
                count++;
            }else {
                int tmp = arr[j];
                for(int m = j+1; m < arr.length; m++){
                    if(tmp == arr[m]){
                        count++;
                    }else if(tmp < arr[m]){
                        tmp = sum - arr[j] - arr[m];
                    }else {
                        continue;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
