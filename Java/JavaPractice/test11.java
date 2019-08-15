class Person{
	private String name;
	private int age;
	
	//静态属性
	public static int createdCount;
	
	public Person(String name,int age){
		createdCount++;
		System.out.printf("Person(%s, %d)%n", name, age);
		this.name = name;
		this.age = age;
	}
	
	public Person(){
		this("比特学生",18);      //必须出现在第一行
		System.out.printf("Person()%n");
	}
	
	public void print(){
		Person.printPerson(this);
	}
	
	public static void printPerson(Person person){
		System.out.printf("Person{name = %s,age = %d}%n",person.name,person.age);
	}
}


class test11{
	public static void main(String[] args){
		System.out.println(Person.createdCount);
		Person p1 = new Person();
		p1.print();
		System.out.println(Person.createdCount);
		new Person("java10班",30).print();
		System.out.println(Person.createdCount);
	}
}