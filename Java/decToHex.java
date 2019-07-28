//10 进制转 16 进制，计算公式:
	//例：1958 转 16 进制:1958 % 16 == 6	1958 / 16 == 122	122 % 16 == 10 也就是 A   122 / 16 == 7		7 < 16	故1958 的 16 进制 为 7A6
public class decToHex{		
	public static String decToHex(int dec) {
		String hex = "";
		while (dec >= 16) {
			int remainder = dec % 16;
			dec = dec / 16;
			
			if (remainder < 10) {
				hex += remainder;	// 字符串 + int 类型 仍是字符串
			} else {
				char ch = (char)('A' + (remainder - 10));
				hex += ch;
			}
		}
		if (dec != 0) {
			hex += dec;
		}
		
		return reverse(hex);
	}
	
	public static void main(String[] args) {
		System.out.println(decToHex(1958));
	}
}










