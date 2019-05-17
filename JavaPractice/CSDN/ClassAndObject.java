public class ClassAndObject{
	String name;
	int age;
	String hobby;
	//构造方法：可以带参，也可以无参
	public ClassAndObject(String name){
		this.name = name;
	}
	//设置age的值
	public void setAge(int setAge){
		age = setAge;
	}
	//设置hobby的值
	public void setHobby(String setHobby){
		hobby = setHobby;
	}
	//打印信息
	public void printfClassAndObject(){
		System.out.println("姓名："+name);
		System.out.println("年龄："+age);
		System.out.println("爱好："+hobby);
	}
	public static void main(String[] args){
		//创建两个新对象
		ClassAndObject one = new ClassAndObject("student01");
		ClassAndObject two = new ClassAndObject("student02");
		//调用两个对象的成员
		one.setAge(18);
		one.setHobby("羽毛球");
		one.printfClassAndObject();
		
		two.setAge(19);
		two.setHobby("篮球");
		two.printfClassAndObject();
	}
}

