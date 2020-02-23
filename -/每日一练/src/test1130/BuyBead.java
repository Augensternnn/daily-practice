package test1130;

import java.util.Scanner;

public class BuyBead {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        StringBuffer seller = new StringBuffer(s1);
        StringBuffer buyer = new StringBuffer(s2);
        for(int i = buyer.length()-1; i >= 0; i--){
            String s = buyer.substring(i, i+1);
            if(seller.indexOf(s) >= 0){
                seller.delete(seller.indexOf(s), seller.indexOf(s)+1);
                buyer.delete(i, i+1);
            }
        }
        if(buyer.length() == 0){
            System.out.println("Yes " + seller.length());
        }else {
            System.out.println("No " + buyer.length());
        }
    }
}
