public class test4{
//反转字符串
public static String reverse(String s){
	int length = s.length();
	String r = " ";
	//0,1,2... length - 1
	for(int i = length - 1; i >= 0; i--){		
		char ch = s.charAt(i); 
		r = r + ch;
	}
	return r;
}

//10进制转16进制，计算公式：
	/*
	1958转16进制：
	1958 % 16 == 6     1958 / 16 == 122
	122 % 16 == 10 也就是A   122 / 16 == 7
	7 < 16
	1958的16进制为7A6
	*/
public static String decToHex(int dec){
	String hex = "";
	while(dec >= 16){
		int remainder = dec % 16;
		dec = dec / 16;
		if(remainder < 10){
			hex += remainder;   //字符串 + int 类型 仍是字符串
		}else{
			char ch = (char)('A' + (remainder - 10));
			hex += ch;
		}
	}
	if(dec != 0){
		hex += dec;
	}
	return reverse(hex);
}

public static void main(String[] args){
	//逆置字符串
		System.out.printf(reverse("Hello"));
	// 10 进制转换 16 进制
		System.out.println(decToHex(21954));
    }
}
