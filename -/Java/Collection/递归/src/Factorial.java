public class Factorial {
    // 求 n!
        // 递归方法
    public static long factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return factorial(n - 1) * n;
    }
        //  循环方法
    public static long factorial2(int n){
        long fact = 1;
        for(int i = 1; i <= n; i++){
            fact = fact * i;
        }
        return fact;
    }
}
