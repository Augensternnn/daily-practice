import java.util.Scanner;
public class finonacci {
    static int i = 0;
    private static int fib(int n){
        int[] arr = new int[10];
        int a,b;
        if(n % 2 == 1){
            a = (n - 1) / 2;
            b = n - a;
        }else{
            a = n / 2;
            b = a;
        }
        arr[i] = a;
        i += 1;
        if(b / 2 > 2) {
            fib(b);
        }
        arr[i + 1]= arr[i - 1] - arr[i];
        return i;
    }
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = fib(n);
        System.out.println("步数为："+count);
    }
}
