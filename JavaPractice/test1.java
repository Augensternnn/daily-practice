public class test1{
	public static void learnUnicode() {
		String a = "中国";
		String b = "\u4e2d\u56fd";
		System.out.println(a);
		System.out.println(b);
	}
	
	public static void learnLiteral() {
		//byte a = 127;
		//int a = 100L;
		int a = 0xFF;
		int b = 0b11;
		int c = 99;
	}
	
	public static void learnRange() {
		System.out.println("byte 型的范围");
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
	}
	
	public static void learnStringAdd(){
		int a = 3;
		int b = 4;
		System.out.println("结果是" + a + b);
		System.out.println("结果是" + (a + b));
	}
		
    public static void main(String[] args){
	    learnUnicode();
		learnLiteral();
		learnRange();
		learnStringAdd();
	}
}
