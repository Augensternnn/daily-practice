// 定义一个类
class Person {
	String name;
	int age;
	// 若不给出构造方法，会有一个默认的构造方法
	Person() {}
	
	Person(String n, int a) {
		System.out.println(n);
		name = n;
		age = a;
	}
	
	void print() {
		System.out.printf("name = %s, age = %d%n", name, age);
	}
}

public class classAndObject1{
	public static void main(String[] args) {
		// 只定义了一个引用变量，没有真正创建对象
		Person personNull = null;
		
		// 根据类创建对象
		Person person = new Person();
		
		// 使用对象
		// 对象.属性
		// 对象.方法
		person.name = "中国人";
		person.age = 5000;
		person.print();
		
		
		Person personBit = new Person();
		personBit.name = "数学";
		personBit.age = 5;
		personBit.print();
		
		
		Person person3 = new Person();
		person3.print();
		
		Person person4 = new Person("第四个", 18);
	}
}