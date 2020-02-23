import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MyString implements Comparable<MyString> {
    private final char[] value;

    // public 的方法列出
    // 需要复制数组，保证数组的引用不会被泄露【重】
    // 泄露会导致通过泄露的引用，修改属性的值
    // 从而破坏对象的不可变特性
    public MyString(char value[]){
        this.value = Arrays.copyOf(value, value.length);
    }

    public MyString(char value[], int offset, int count){
        this.value = Arrays.copyOfRange(value, offset, offset + count);
    }

    // 这里引用泄露没有问题，因为新的对象也不会去修改 value 数组中的值
    // 相比较与 copyOf ，可以省去复制的时间，提升效能
    public MyString(MyString s){
        // this.value = Arrays.copyOf(s.value, s.value.length);
        this.value = s.value;
    }

    // 模拟的对象池
    private static List<MyString> pool = new ArrayList<>();
    // 模拟直接定义字符串
    // 会直接入池
    public static MyString literal(MyString s){
        for(MyString ms : pool){
            if(ms.equals(s)){
                return ms;
            }
        }
        MyString rs = new MyString(s);
        pool.add(rs);
        return rs;
    }

    // 手动入池
    // 如果常量池中已经有该相等的对象，返回引用
    // 否则在常量池中创建对象，并返回引用
    public MyString intern() {
        for(MyString ms : )
    }
    // 模拟直接定义字符串
    // 会直接入池
    public MyString(boolean intern) {
    }




    public char charAt(int index){
        return value[index];
    }

    // 不能直接返回引用，防止引用泄露
    public char[] toCharArray(){
        return Arrays.copyOf(value, value.length);
    }

    public boolean equalsIgnoreCase(MyString s){
        if(s == null){
            return false;
        }
        // 效率比较低(因为有数组的拷贝)：return toUpper().equals(s.toUpper());
        // 效率较高：一个一个 value 进行比较
        if(value.length != s.value.length){
            return false;
        }
        for(int i = 0; i < value.length; i++){
            char a = value[i];
            char b = s.value[i];
            if(a == b){
                continue;
            }
            if(a >= 'a' && a <= 'z'){
                a += ('A' - 'a');
                if(a == b){
                    continue;
                }
            }else if(a >= 'A' && a <= 'Z'){
                a += ('a' - 'A');
                if(a == b){
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object s){
        /*
        1. 判断引用是否指向同一个对象
        2. s 是不是 null
        3. s 是不是一个 MyString 类型的对象
        4. 比较属性的相等性
         */
        if(this == s){
            return true;
        }
        if(s == null){
            return false;
        }
        // s.getClass() == getClass
        if(!(s instanceof MyString)){
            return false;
        }
        return Arrays.equals(value, ((MyString) s).value);
    }

    // 保证对象的不可变性
    public MyString toUpper(){
        // 1.构造一个新的对象
        // 2.遍历新对象的 value
        // 3.把小写字母变成大写字母
        // 4.返回新的对象
       MyString s = new MyString(value);
       for (int i = 0; i < s.value.length; i++){
           if(s.value[i] >= 'a' && s.value[i] <= 'z'){
               s.value[i] = (char)(s.value[i] - 'a' + 'A');
           }
       }
       return s;
     }

    public MyString toLower() {
        return null;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        for(char c : value){
            hash = hash ^ c;    // 异或^ 可以保证平均性
        }
        return hash;
    }

    public MyString substring(int begin, int end) {
        return new MyString(value, begin, end - begin);
    }

    @Override
    public String toString() {
        return new String(value);
    }

    @Override
    public int compareTo(MyString o) {
        if(o == null){
            return 1;   //比 o 大（null 被看作最小的）
        }
        int length = Math.min(value.length, o.value.length);
        for(int i = 0; i < length; i++){
            char a = value[i];
            char b = o.value[i];
            if(a < b){
                return -1;
            }else if(a > b){
                return 1;
            }
        }
        if(value.length > o.value.length){
            return 1;
        }else if(value.length < o.value.length){
            return -1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        char[] a = { 'a', 'b', 'c' };
        MyString s = new MyString(a);
        MyString t = new MyString(s);
        System.out.println(s);
        System.out.println(t);
        System.out.println(s.equals(t));
        MyString r = t.toUpper();
        System.out.println(s);
        System.out.println(t);
        System.out.println(r);
        System.out.println(s.equals(t));
        a[0] = 'z';
        System.out.println(s);
        System.out.println(t);
        System.out.println(r);
        System.out.println(s.equals(t));
        System.out.println("abcde".compareTo("abc"));
    }
}
