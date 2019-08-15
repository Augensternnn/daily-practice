class Base {
	//有多个构造代码块，则按定义顺序执行
	{
		System.out.println("Base 的构造代码块 1");
	}
	
	Base() {
		System.out.println("Base 的构造方法");
	}
	
	static {
		System.out.println("Base 的静态代码块 1");
	}
	
	{
		System.out.println("Base 的构造代码块 2");
	}
	
	static {
		System.out.println("Base 的静态代码块 2");
	}
}

class Derived extends Base {
	{
		System.out.println("Derived 的构造代码块 1");
	}
	
	Derived() {
		this(18);
		System.out.println("Derived 的无参构造方法");
	}
	
	Derived(int n) {
		super();
		System.out.println("Derived 的有参构造方法");
	}
	
	static {
		System.out.println("Derived 的静态代码块 1");
	}
	
	{
		System.out.println("Derived 的构造代码块 2");
	}
	
	static {
		System.out.println("Derived 的静态代码块 2");
	}
}

public class Interview {
	public static void main(String[] args) {
		System.out.println("开始");
		new Derived();
		new Derived();
		System.out.println("结束");
	}
}



