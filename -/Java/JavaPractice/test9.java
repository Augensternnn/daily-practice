//如何定义一个类
class Person{
	String name;
	int age;
	
	//不给出构造方法，会有一个默认的构造方法
	
	void print(){
		System.out.printf("name = %s, age = %d%n", name, age);
	}
}

public class test9{
	public static void main(String[] args){
		//只定义了一个引用变量，没有真正创建对象
	
		Person person = null;
		//如何根据类创建对象
		Person person = new Person();
	
		//使用对象
		//对象.属性
		//对象.方法
		person.name = "中国人";
		person.age = 5000;
		person.print();
		
		Person person1 = new Person();
		person1.name = "哈哈";
		person.age = 6;
		person1.print();
		
	}
	
}