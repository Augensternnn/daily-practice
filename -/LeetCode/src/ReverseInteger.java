import java.math.BigInteger;

public class ReverseInteger {
    public static int reverse(int x){
        if(x == 0){
            return 0;
        }else {
            int num = x;
            String s = "";
            if(x < 0)
                x = x * (-1);
            while (x >= 10){
                int m = x % 10;
                if(m != 0)
                    s += m;
                x /= 10;
            }
            if(x > 0)
                s += x;
            if(num < 0){
                return new BigInteger(s).intValue();
            }else {
                return new BigInteger(s).negate().intValue();
            }
        }
    }
public static void main(String[] args) {
//    int t = new BigInteger("96463243").intValue();
//    System.out.println(t);
//    System.out.println(reverse(1534236469));
    System.out.println(reverse(-2147483648));
    }
}
