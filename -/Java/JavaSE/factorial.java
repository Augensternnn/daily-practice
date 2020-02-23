//求n!
public class factorial{
	//递归方法
	public static long factorial_1(int n){
		if(n == 0 || n == 1){
			return 1;
		}
		else return factorial_1(n - 1) * n;
	}
	//循环方法
	public static long factorial_2(int n){
		long fact = 1;
		for(int i = 1; i <= n; i++){
			fact = fact * i;
		}
		return fact;
	}
	
	public static void main(String[] args){
		int n = 9;
		
		long fact1 = factorial_1(n);
		System.out.printf("阶乘是%d%n",fact1);
		
		long fact2 = factorial_2(n);
		System.out.printf("阶乘是%d%n",fact2);
	}	
}