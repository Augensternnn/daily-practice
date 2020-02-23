package test1114;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            if(n > 1000)
                n = 999;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                list.add(i);
            }
            int i = 0;
            while (list.size() > 1){
                i = (i + 2) % list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));
        }
    }
}
