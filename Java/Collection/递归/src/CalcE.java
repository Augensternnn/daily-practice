public class CalcE {
    // n!
    public static long factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return factorial(n - 1) * n;
    }
    /**
     *  利用公式 e = 1 + 1/1! + 1/2! + 1/3! + 1/4! + ... 计算自然对数的底 e
     * @param precision     最后一项的精度 <= precision
     * @return
     */
    public static double calcE(double precision){
        double e = 0;
        int n = 0;
        while (true){
            double item = 1.0 / factorial(n++);
            e += item;
            if(item < precision){
                break;
            }
        }
        return e;
    }

    /**
     * 利用公式 e = 1 + 1/1! + 1/2! + 1/3! + 1/4! + ... 计算自然对数的底 e
     * @param n     一共需要计算 n 项
     * @return
     */
    public static double calcE(int n){
        double e = 0;
        for (int i = 0; i < n; i++) {
            e = e + ((double)1 / factorial(i));
        }
        return e;
    }
}
