package test1120;

import java.math.BigInteger;
import java.util.Scanner;

public class AddLongInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s1 = in.next();
            String s2 = in.next();
            BigInteger num1 = new BigInteger(s1);
            BigInteger num2 = new BigInteger(s2);
            System.out.println(num1.add(num2));
        }
    }

//    public static String addTwoLongInt(String addend, String augend){
//        BigInteger num1 = new BigInteger(addend);
//        BigInteger num2 = new BigInteger(augend);
//        String result = String.valueOf(num1.add(num2));
//        return result;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String addend = in.nextLine();
//        String augend = in.nextLine();
//        System.out.println(addTwoLongInt(addend, augend));
//    }
}
