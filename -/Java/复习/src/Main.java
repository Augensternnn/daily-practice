public class Main {
    public static void main(String[] args) {
        System.out.println(new Childs());
        System.out.println(new Childs());
    }
}
class Parents{
    static{
        System.out.println("Parent静态代码块");
    }

    Parents(){
        System.out.println("Parent构造方法");
    }
    {
        System.out.println("Parent实例代码块");
    }
}

class Childs extends Parents{
    static{
        System.out.println("Child静态代码块");
    }

    Childs(){
        System.out.println("Child构造方法");
    }
    {
        System.out.println("Child实例代码块");
    }
}

