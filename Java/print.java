public class print{
	public static void testPrint(){
		System.out.print("中国人");
		System.out.print(1);
		System.out.print("中国人 "+1);
		
		System.out.println();
		
		System.out.printf("我是中国人 %d %d%n", 1, 2);
		System.out.format("我是中国人 %d %d%n", 1, 2);
	}
	
	public static void main(String[] args){
		testPrint();
	}
}