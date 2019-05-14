public class test6{
public static void main(String[] args){
	int n = 198625;
	int count = 0;
	while(n > 0){
		n = n / 10;
		count++;
	}
	System.out.printf("%d",count);
	}
}