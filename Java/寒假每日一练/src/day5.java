public class day5 {
    // 925.长按键入
//    public static boolean isLongPressedName(String name, String typed) {
//
//    }

    String str = new String("hello");
    char[] ch = {'a','b'};

    public static void main(String[] args) {
        day5 ex = new day5();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str+" and ");
        System.out.println(ex.ch);
    }
    public void change(String str,char ch[]){
        str="test ok";
        ch[0]='c';
    }
}
