class Group{
	//属性
	String name;	//名称
	int num;		//人数
	
	//方法
		//构造方法
		//1.定义类的时候，若没有明确的给出构造方法，Java编译器会补一个默认的构造方法出来，如：Group(){}
		//2.一旦明确给出构造方法，则不会给默认的构造方法
		
	Group(String n, int m){
		name = n;
		num = m;
	}
		//普通方法
	void print(String welcome){
		System.out.printf("%s %s 的 %d 位同学们%n", //welcome, name, num
			welcome,		//形参
			name,			//属性
			num			//属性
		);
	}
}

class B{
	int sum;
	B(int a,int b,int c){
		System.out.println(a + b + c);
		sum = a + b + c;
	}
	void print(){
		System.out.pringln(sum);
	}
}

//一个文件只允许有一个public修饰的类，这个类名称和文件名同名
public class test10{
	public static void main(String[] args){
		Group group = new Group("信息173班",26);
		group.print("欢迎来到陕科大,");
		//欢迎来到陕科大，信息173 班的 26 位同学们
	}
}