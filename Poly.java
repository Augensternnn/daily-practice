class Base {
	void method() {
		System.out.println("Base 的 method 方法");
	}
	
	static void staticMethod() {
		System.out.println("Base 的 staticMethod 方法");
	}
}

class D1 extends Base {
	@Override
	void method() {
		System.out.println("D1 的 method 方法");
	}
	
	static void staticMethod() {
		System.out.println("D1 的 staticMethod 方法");
	}
}

public class Poly {
	public static void main(String[] args) {
		D1   d1 = new D1();
		Base base = d12;
		// 普通方法看后边的对象类型来决定执行哪个方法
		base.method();			// D1.method()
		d1.method();			// D1.method()
		// 静态方法看前面的引用类型来决定执行哪个方法
		// 不建议这么调用
		base.staticMethod();		// Base.staticMethod();
		d1.staticMethod();		// D1.staticMethod();
	}
}







