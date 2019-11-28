public class Fibonacci {
    // 1 1 2 3 5 8
    // 1 2 3 4 5 6
    // f(n)=f(n-1)+f(n-2)
    public static int f(int n){
        if(n < 1)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        return f(n-1)+f(n-2);
    }

    public static void main(String[] args) {
        System.out.println(f(3));
    }
}
