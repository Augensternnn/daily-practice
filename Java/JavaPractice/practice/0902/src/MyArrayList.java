import java.util.List;

public class MyArrayList<E> implements List<E> {
    private E[] array;
    private int size;

    public MyArrayList(){
        // 【了解】泛型无法定义泛型数组：没法直接定义一个泛型数组，因为不知道是啥类型的
            // array = new E[100];     ×
        // 压制警告的注解
        array = (E[])new Object[100];
        size = 0;
    }

    public void add(E element){
        array[size++] = element;
    }

    public void remove(){
        array[--size] = null;
        // size--;      这种写法会引发内存泄露
        //              原本语义上应该死去的对象
        //              因为写法问题，导致 GC
        //
    }
}
