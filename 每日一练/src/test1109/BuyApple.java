package test1109;

import java.util.Scanner;

/**
 * 小易去附近商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装（包装不可以拆分）
 * 可是小易只想购买恰好 n 个苹果，小易想购买尽量少的袋数方便携带
 * 如果不能购买恰好 n 个苹果，小易将不会购买
 */
public class BuyApple {
    public static int bagNum(int n){
        int count = 0;
        for(int i = n / 8; i >= 0; i--){
            if((n - i*8) % 6 == 0){
                count = i + ((n - i*8) / 6);
                return count;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(bagNum(n));
    }
}
