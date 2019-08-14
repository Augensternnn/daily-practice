abstract class Base {
	String field = "父类的属性";
	
	int a;
	
	// 因为父类定义了构造方法，所以没有了默认的无参构造方法
	Base(int a) {
		this.a = a;
	}
	
	abstract void abstractMethod();
}

final class Derived extends Base {
	String field = "子类的属性";
	
	// 必须显式给出构造方法，因为父类没有无参的构造方法
	Derived(int a) {
		// super();		编译错误，因为父类没有无参的构造方法
		super(a);
	}
	
	void printFields(String field) {
		System.out.println(field);
		System.out.println(this.field);
		System.out.println(super.field);
	}
	
	// Derived 要不做一个抽象类（前面加 abstract），要不覆写父类的抽象方法
	@Override
	void abstractMethod() {
	}
}

// 编译错误，因为 Derived 已经是最终类了
// class DerivedOfDerived extends Derived {}

public class Show {
	public static void main(String[] args) {
		new Derived(18).printFields("传入的参数");
		// new Base(18);	编译错误，因为 Base 是一个抽象类
	}
}