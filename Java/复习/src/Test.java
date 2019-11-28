public class Test {
    public static void main(String[] args) {
        // 实际运行时，会根据运行时的对象和传入参数
        // 来决定具体调用哪个方法
        Parent parent = new Child();
    }
}
class Parent{
    String value;
    Parent(){
        setValue("ss");
    }
    void setValue(String value){
        System.out.println("parent set value");
    }
}
class Child extends Parent{
    Child(){
        super();
    }
    void setValue(String value){
        System.out.println("Child set value");
    }
}
