public class test5{
//利用公式 Pi / 4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 -... 计算Pi的值【最后一项的绝对值小于精度】

//public static double calcPi(double precision){
	//}

public static double calcPi(int n){
	double Pi4 = 0;
	for(int i = 0; i < n; i++){
		int m = 2 * i + 1;
		if(i % 2 == 0){
			//加
			Pi4 = Pi4 + 1.0 / m;
		}else{
			//减
			Pi4 = Pi4 - 1.0 / m;
		}
	}
	return Pi4 * 4;
}

public static void main(String[] args){
	double pi = calcPi(5000);
	System.out.printf("pi = %f%n",pi);
}
}
