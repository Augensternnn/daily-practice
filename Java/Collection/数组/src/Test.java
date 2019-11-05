import java.util.Arrays;

public class Test {
    public static void testArrayIndex(){
        int[] array = { 1, 2, 3, 4, 5 };
        // 下标取值范围 [0, 4]
        //System.out.println(array[3L]);
        //System.out.println(array[-1]);
    }


    public static void method1(int[] array){
        // 通过动态方式，将 array 指向新的数组
        // 引用指向新位置的更改，不会影响实参
        array = new int[10];
        for(int i = 0; i < 10; i++){
            array[i] = 100 + i;
        }
    }
    public static void method2(int[] array){
        // 通过引用，更改实际的数组中的值
        // 实参可以感受到变化
        array[0] = 2019;
    }


    public static void testCopyArray(){
        int[] srcArray = {1, 2, 3, 4, 5};

        // 数组被完全 copy 了一份
        // srcArray 和 destArray 指向不同的数组，所以改变互相不影响
        int[] destArray = Arrays.copyOf(srcArray, srcArray.length);
        destArray[0] = 2019;
        System.out.println(srcArray[0]);

        // 只是 copy 了引用，srcArray 和 destRefArray 指向相同的数组，所以改变互相可见
        int[] destRefArray = srcArray;
        destRefArray[0] = 519;
        System.out.println(srcArray[0]);

        // 利用 System.arraycopy 实现 copy
        int[] destSystemArray = new int[srcArray.length];
        System.arraycopy(srcArray, 0, destSystemArray, 0, srcArray.length);
    }


    public static void testDefaultValue() {
        int[] array;
        array = new int[10];
        // 不初始化，每个元素的值都是默认值
        System.out.print(Arrays.toString(array));
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));

        System.out.println("*********************");

        method1(array);
        System.out.println(Arrays.toString(array));
        System.out.println("---------------------");
        method2(array);
        System.out.println(Arrays.toString(array));

        System.out.println("*********************");

        testCopyArray();

        System.out.println("*********************");

        testDefaultValue();
    }
}

