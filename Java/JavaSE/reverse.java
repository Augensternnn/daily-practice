//逆置字符串
public class reverse{
	public static String reverse(String s){
		int length = s.length();
		String r = "";
		// 0, 1, 2 ... length - 1
		for(int i = length - 1; i >= 0; i--){
			char ch = s.charAt(i);
			r = r + ch;
		}
		return r;
	}
	
	public static void main(String[] args){
		System.out.println(reverse("Hello"));
	}
}