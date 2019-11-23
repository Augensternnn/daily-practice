package test1120;

import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String c = in.next();
        drawSquare(length, c);
    }
    private static void drawSquare(int sideLen, String c){
        if(sideLen < 3 || sideLen > 20){
            return;
        }else {
            for(int i = 1; i <= Math.ceil((double)sideLen/2); i++) {
                if (i == 1 || i == Math.ceil((double)sideLen / 2)) {
                    for (int j = 1; j <= sideLen; j++)
                        System.out.print(c);
                } else {
                    for (int l = 1; l <= sideLen; l++) {
                        if (l == 1 || l == sideLen)
                            System.out.print(c);
                        else
                            System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

//    private static void drawSquare(int sideLen, String c){
//        if((sideLen < 3 || sideLen > 20) && (sideLen%2 != 0)){
//            return;
//        }else{
//            for(int i = 1; i <= sideLen/2; i++){
//                if(i == 1 || i == sideLen/2){
//                    for(int j = 1; j <= sideLen; j++)
//                        System.out.print(c);
//                }else {
//                    for(int l = 1; l <= sideLen; l++){
//                        if(l == 1 || l == sideLen)
//                            System.out.print(c);
//                        else
//                            System.out.print(" ");
//                    }
//                }
//                System.out.println();
//            }
//        }
//    }
}

