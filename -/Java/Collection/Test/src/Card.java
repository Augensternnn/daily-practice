import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Card {
    /**
     *
     * @param num  表示用2*n张牌
     * @param k    表示洗K次牌
     * @param arr  初始的牌顺序
     * @return
     */
    public static int[] playCard(int num,int k,int[] arr){
        for(int i=0; i<k; i++){
            playCardInternal(num,arr);
        }
        return arr;
    }
    private static void playCardInternal(int num,int[] arr){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<num;i++){
            list.add(arr[arr.length-i-1]);
            list.add(arr[arr.length/2-i-1]);
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(arr.length-i-1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int sum=scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<sum;i++){
            String string=scanner.nextLine();
            String[] strings1=string.split(" ");
            String number=scanner.nextLine();
            String[] strings2=number.split(" ");
            int[] arr=new int[strings2.length];
            for(int j=0;j<arr.length;j++){
                arr[j]=Integer.valueOf(strings2[j]);
            }
            int[] ret=playCard(Integer.valueOf(strings1[0]),Integer.valueOf(strings1[1]),arr);
            for(int k=0;k<ret.length;k++){
                if(k!=ret.length-1) {
                    System.out.print(ret[k] + " ");
                }else{
                    System.out.print(ret[k]);
                }
            }
            System.out.println();
        }
    }
}
