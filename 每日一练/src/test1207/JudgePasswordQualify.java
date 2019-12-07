package test1207;

import java.util.Scanner;

public class JudgePasswordQualify {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.next();
            if(s.length() <= 8){
                System.out.println("NG");
            }else {
                int Dchara=0,xchara=0,num=0,other=0;
                for(int i = 0; i < s.length(); i++){
                    if('0'<=s.charAt(i)&&s.charAt(i)<='9'){
                        if(num==1)
                            continue;
                        else
                            num++;
                    }else if('a'<=s.charAt(i)&&s.charAt(i)<='z'){
                        if(xchara==1)
                            continue;
                        else
                            xchara++;
                    }else if('A'<=s.charAt(i)&&s.charAt(i)<='Z'){
                        if (Dchara==1)
                            continue;
                        else
                            Dchara++;
                    }else {
                        if(other==1)
                            continue;
                        else
                            other++;
                    }
                }
                if(Dchara+xchara+num+other<3){
                    System.out.println("NG");
                }else{
                    for(int i = 0; i < s.length()-6; i++){
                        for(int j = i + 3; j < s.length(); j++){
                            if(s.charAt(i) == s.charAt(j) && s.charAt(i+1) == s.charAt(j+1) && s.charAt(i+2) == s.charAt(j+2)){
                                System.out.println("NG");
                                return;
                            }else
                                break;
                        }
                    }
//                    int max = -1;
//                    for(int i = 0; i < s.length() - 1; i++){
//                        int count = 0;
//                        int p1 = 0;
//                        for(int j = i + 1; j < s.length(); j++){
//                            if(s.charAt(i) == s.charAt(j)){
//                                p1 = j;
//                                break;
//                            }
//                        }
//                        int k = i;
//                        while(p1 < s.length()){
//                            if(s.charAt(k) == s.charAt(p1)){
//                                count++;
//                                k++;
//                                p1++;
//                            }else{
//                                break;
//                            }
//                        }
//                        max = Math.max(max,count);
//                        count = 0;
//                    }
//
//                    if(max > 2){
//                        System.out.println("NG");
//                    }else{
//                        System.out.println("OK");
//                    }


                }

            }
        }
    }
}
