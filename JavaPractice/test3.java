public class test3{
//求阶乘
	//递归方法
public static long factorial1(int n){
	//终止条件：1！==1     0！==1
	if(n == 0 || n == 1){
		return 1;
	}
	//递推公式：n!==(n - 1)!*n
	return factorial1(n - 1)*n;
}
	//循环方法
public static long factorial2(int n){
	//n!=1 *2 * 3 * ... * n      一共要循环n次
	long fact = 1;
	for(int i = 1; i <= n; i++){
		fact = fact * i;
	}
	return fact;
}

//利用公式 e = 1 + 1/1! +1/2! +1/3! +1/4! +.... 计算自然底数e
public static double calcE(int n){
	double e = 0;
	for(int i = 0; i < n; i++){
		e = e + ((double)1 / factorial1(i));
	}
	return e;
}
public static double calcE(double precision){
	double e = 0;
	int n = 0;
	while(true){
		double item = 1.0 / factorial1(n++);
		e += item;
		if(item < precision){
			break;
		}
	}
	return e;
}

public static void main(String[] args){
	int n = 4;
	//阶乘
	long fact1 = factorial1(n);
	System.out.printf("阶乘是 %d%n",fact1);
	long fact2 = factorial2(n);
	System.out.printf("阶乘是 %d%n",fact2);	
	//求e
	double e = calcE(10);
	System.out.printf("e = %f%n",e);
		//给定精度去求，要求最后一项的结果 < 精度
		e = calcE(1E-4);     //e = calcE(0.0001);
		System.out.printf("e = %f%n",e);
		
}
}
