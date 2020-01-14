import org.junit.Test;

import java.util.Arrays;
import java.util.jar.JarOutputStream;

public class day1 {
    @Test
    public void test1() {
        int x=20,y=5;
        char a='你',b='好';   // char是整数类型，在内存单元中以整数形式存放

        // + 两边均为数值型时，+ 进行加法运算
        System.out.println(x+y);    // 25
        System.out.println((x+y)+y);    // 30
        System.out.println(a+b);    // 43229

        System.out.println("********");

        // + 左右两边至少有一个为字符串时，+ 为拼接符，此时若要进行数值型的运算需要加括号
        System.out.println(""+x+y); // 205
        System.out.println(""+(x+y));   // 25
        System.out.println(""+(x+y)+y); // 255
        System.out.println(x+y+""+(x+y)+y); // 25255
        System.out.println(""+a);   // 你
        System.out.println(""+a+b); // 你好
        System.out.println(""+(a+b));   // 43229
        System.out.println(""+(a+b)+b); // 43229好
        System.out.println(a+""+b);     // 你好
    }

    @Test
    public void test2(){
        // char是整数类型，在内存单元中以整数形式存放
        char a='你',b='好';
        System.out.println(a+'0');
        System.out.println(a+'0'-'0');
        System.out.println(b+'0');
        System.out.println(b+'0'-'0');
        System.out.println(a);  // 你
        System.out.println(""+a);   // 你
        System.out.println(""+b);   // 好
        System.out.println(b);      // 好
        System.out.println(a+b);    // 43229
        System.out.println(""+a+b); // 你好
        System.out.println(""+(a+b));   // 43229
        System.out.println(""+(a+b)+b); // 43229好
        System.out.println(a+""+b);     // 你好
    }

    @Test
    public void test3(){
        char l = 'a';
        System.out.println(l);
        System.out.println(l+'0');
        System.out.println(l+'0'-'0');
        char ll = 'b';
        System.out.println(ll);
        System.out.println(ll+'0');
        System.out.println(ll+'0'-'0');
        char lll = 'a' + 'b';       //char类型相加，提升为int类型，输出对应的字符
        System.out.println((char)195);
        System.out.println(lll);
        char llll = 44;
        System.out.println(llll);
    }

    // 将字符串中的大写字母转换成小写字母
    public static String toLowerCase(String str) {
        String s = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)>='A' && str.charAt(i)<='Z')
                s += (char)(str.charAt(i)+32);
            else
                s += str.charAt(i);
        }
        return s;
    }

    // 将数组中的元素向右移动 k 个位置，其中 k 是非负数
    public static void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        int j = 0;
        if(k < 0){
            return;
        }else if((k>=0 && k<nums.length) || (k>nums.length)){
            if(k > nums.length){
                k = k - nums.length;
            }
            for(int i = nums.length-k; i < nums.length; i++){
                arr[j++] = nums[i];
            }
            for(int i = 0; i < nums.length-k; i++){
                arr[j++] = nums[i];
            }
        }else if(k == nums.length){
            arr = nums;
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = arr[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void mystery(int x){
        System.out.print(x % 10);
        if((x/10)!=0){
            mystery(x/10);
        }
        System.out.print(x%10);
    }

    public static void main(String[] args) {
        Cat.sleep();
        mystery(1234);
        System.out.println();
        System.out.println(toLowerCase("LOVELY"));
        int[] nums = {1, 2, 3};
        rotate(nums, 4);
    }
}
class Cat{
    public static void sleep(){
    }
}
