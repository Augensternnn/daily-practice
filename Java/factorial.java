//递归求n!
public class factorial{
	public static long factorial1(int n) {
		// 终止条件
		// 1! == 1		0! == 1
		if (n == 0 || n == 1) {
			return 1;
		}
		// 递推公式
		// n! == (n - 1)! * n
		return factorial1(n - 1) * n;
	}
}