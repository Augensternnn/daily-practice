//利用公式 Pi / 4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - ... 计算 pi（计算n项）
public class calcPi{
	public static double calcPi(int n) {
		double pi = 0;
		for (int i = 0; i < n; i++) {
			int m = 2 * i + 1;
			if (i % 2 == 0) {
				// 加
				pi = pi + 1.0 / m;
			} else {
				// 减
				pi = pi - 1.0 / m;
			}
		}
		return pi * 4;
	}

	public static void main(String[] args){
		double pi = calcPi(500);
		System.out.printf("pi = %f%n", pi);
	}
}