//利用 e = 1 + 1/1! + 1/2! + 1/3! + 1/4! + 1/5! +...计算e
public class calcE{
	public static long factorial(int n){
		if(n == 1 || n == 0){
			return 1;
		}
		else return factorial(n - 1) * n;
	}
	
	//最后一项的精度 <= precision
	public static double calcE(double precision){
		double e = 0;
		int n = 0;
		while(true){
			double item = 1.0 / factorial(n++);
			e = e + item;
			if(item < precision){
				break;
			}
		}
			return e;
	}
	
	//计算n项
	public static double calcE(int n){
		double e = 0;
		for(int i = 0; i < n; i++){
			e = e + ((double)1 / factorial(i));
		}
		return e;
	}
	
	public static void main(String[] args){
		double e = calcE(10);
		System.out.printf("e = %f%n",e);
		
		e = calcE(1E-4);
		System.out.printf("e = %f%n",e);
	}
}