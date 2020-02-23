import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class NumClassify {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (i < n){
            arr[i++] = in.nextInt();
        }
        int a1=0, a2=0, a3=0, a4=0, m=0;
        int s1=0, s2=0, s3=0, s4=0, s5=0;
        int[] a5 = new int[n];
        for(int j = 0; j < n; j++){
            if((arr[j]%5==0) && (arr[j]%2==0)){
                a1 += arr[j];
                s1++;
            }else if (arr[j]%5 == 1){
                a2 += (arr[j]*Math.pow(-1,((s2)%2)));
                s2++;
            }else if(arr[j]%5==2){
                a3 += 1;
                s3++;
            }else if(arr[j]%5==3){
                a4 += arr[j];
                s4++;
            }else if(arr[j]%5==4){
                a5[m++] = arr[j];
                s5++;
            }else {
                continue;
            }
        }
        if(s1 > 0){
            System.out.print(a1 + " ");
        }else{
            System.out.print("N ");
        }
        if(s2 > 0){
            System.out.print(a2 + " ");
        }else{
            System.out.print("N ");
        }
        if(s3 > 0){
            System.out.print(a3 + " ");
        }else{
            System.out.print("N ");
        }
        if(s4 > 0){
            DecimalFormat df = new DecimalFormat("#.0");
            System.out.print(df.format(a4*(1.0/s4)) + " ");
        }else{
            System.out.print("N ");
        }
        if(s5 > 0){
            Arrays.sort(a5);
            System.out.print(a5[n-1] + " ");
        }else{
            System.out.print("N");
        }
    }
}
