package test1127;

import java.util.Scanner;

public class ScoreOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int a = in.nextInt();
            String[][] nums = new String[n][2];
            int[] count = new int[n];
            for(int i = 0; i < n; i++){
                nums[i][0] = in.next();
                nums[i][1] = in.next();
            }
            for(int i = 0; i < n-1; i++){
                for(int j = i+1; j < n; j++){
                    if(a == 0){
                        if(Integer.valueOf(nums[i][1]).compareTo(Integer.valueOf(nums[j][1])) >-1){
                            count[i] ++;
                        }else{
                            count[j]++;
                        }
                    }else{
                        if(Integer.valueOf(nums[i][1]).compareTo(Integer.valueOf(nums[j][1])) >0){
                            count[i] ++;
                        }else{
                            count[j]++;
                        }
                    }
                }
            }
            changeStr(nums,n,count);

            if(a == 0){  //降序
                for(int i = n-1;i>-1;i--){
                    System.out.print(nums[i][0] + " ");
                    System.out.println(nums[i][1]);
                }
            }else{//升序
                for(int i = 0;i<n;i++){
                    System.out.print(nums[i][0] + " ");
                    System.out.println(nums[i][1]);
                }
            }
        }



    }
    public static void changeStr(String[][] nums,int n,int[] count){
        int i = 0;
        while(i <n){
            if(count[i] == i){
                i++;
            }else{
                String s0 = nums[count[i]][0];
                String s1 = nums[count[i]][1];
                nums[count[i]][0] = nums[i][0];
                nums[count[i]][1] = nums[i][1];
                nums[i][0] = s0;
                nums[i][1] = s1;
                int tmp = count[i];
                count[i] = count[count[i]];
                count[tmp] = tmp ;
            }
        }
    }
}
