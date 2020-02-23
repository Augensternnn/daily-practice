package test1129;

import java.util.Scanner;

public class RabbitSum {
    public static int getTotalCount(int monthCount){
        if(monthCount == 1 || monthCount == 2)
            return 1;
        else
            return getTotalCount(monthCount-1) + getTotalCount(monthCount-2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int month = in.nextInt();
            System.out.println(getTotalCount(month));
        }
    }
}
