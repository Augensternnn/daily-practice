import java.util.Arrays;

// 顺序表（Sequence List）中保存的数据元素类型是 int
public class SeqList {
    // 属性
    private int[] array;       // 用来保存数据
    private int size;          // 保存 array 已经有的数据个数

    // 构造方法
    public SeqList(){
        // 初始化部分：
            // 1. 初始化 array，给定一个默认大小
            // 2. 初始化 size，没有数据，所以 size = 0
        array = new int[11];        // 11 可以调节
        size = 0;
    }

    // 支持的方法
    // 头插：O(n)
    public void pushFront(int element){
        ensureCapacity();
        // i 为数据下标，遍历范围是：[size - 1, 0]
        for(int i = size-1; i >= 0; i--){
            array[i+1] = array[i];
        }
        array[0] = element;
        size++;
    }
    // 尾插：O(1)
    public void pushBack(int element){
        ensureCapacity();
        array[size++] = element;
    }
    // 中间插入：即根据下标做插入 O(n)
    public void insert(int index, int element){
        // 要检查 index 的合法性：[0, size]
        if(index < 0 || index > size){
            System.out.println("index输入不合法！");
            return;
        }
        ensureCapacity();
        // i 代表的是空间的下标
        for(int i = size; i > index; i--){
            array[i] = array[i-1];
        }
        array[index] = element;
        size++;
    }
    // 头删
    public void popFront(){
        if(size == 0){
            System.out.println("为空顺序表，无法删除");
            return;
        }
        for(int i = 0; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        array[--size] = 0;
    }
    // 尾删
    public void popBack(){
        if(size == 0){
            System.out.println("为空顺序表，无法删除");
            return;
        }
        array[--size] = 0;
    }
    public void erase(int index) {
        if (size == 0) {
            System.out.println("空顺序表，无法删除");
            return;
        }
    }
    // 查找
    public int indexOf(int element){
        for(int i = 0; i < size; i++){
            if(array[i] == element)
                return i;
        }
        return -1;
    }
    // 根据下标，获取元素
    public int get(int index){
        // 要检查 index 的合法性
        if(index < 0 || index >= size){
            System.out.println("下标错误！");
            return -1;
        }
        return array[index];
    }
    // 给定下标，修改下标所在元素的值
    public void set(int index, int element){
        array[index] = element;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int capacity(){
        return array.length;
    }
    // 便于打印，显示顺序表中已有元素
    public String toString(){
        return Arrays.toString(Arrays.copyOf(array,size));
    }
    public void remove(int element){        // O(n)
        int index = indexOf(element);
        if(index != -1){
            erase(index);
        }
    }
    public void removeAll(int element){
        /*
        // 时间：O(n^2)	空间：O(1)
        int index;
        while ((index = indexOf(element)) != -1){
            erase(index);
        }
        */
        /*
        //时间：O(n)	空间：O(n)
		int[] newArray = new int[size];
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (array[i] != element) {
				newArray[j++] = array[i];
			}
		}
		// 最后剩下的数一共有 j 个
		// 1. 把数据搬回去 2. 更新 size
		for (int i = 0; i < j; i++) {
			array[i] = newArray[i];
		}
		size = j;
		*/
        // 时间：O(n)	空间：O(1)
        int j = 0;
        for(int i = 0; i <size; i++){
            if(array[i] != element)
                array[j++] = array[i];
        }
        size = j;
    }

    // 内部使用的方法
    // 无论是否需要扩容，调用完这个方法，保证容量一定够用
    private void ensureCapacity(){
        if(size <array.length)
            return;     // 不需要扩容
        // 1. 申请新房子
        int newCapacity = array.length + array.length / 2;
        int[] newArray = new int[newCapacity];
        // 2. 搬家
        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        // 3. 发朋友圈
        this.array = newArray;
        // 4. 退老房子，利用 java 的垃圾回收，自动回收原来的数组
    }

    public static void test1(String[] args) {
        SeqList seqList = new SeqList();

        // []
        System.out.println(seqList.toString());
        // 尾插 1 2 3
        seqList.pushBack(1);
        seqList.pushBack(2);
        seqList.pushBack(3);
        // [ 1, 2, 3 ]
        System.out.println(seqList.toString());

        // 头插 10 20 30
        seqList.pushFront(10);
        seqList.pushFront(20);
        seqList.pushFront(30);
        // [ 30, 20, 10, 1, 2, 3 ]
        System.out.println(seqList.toString());

        seqList.insert(2, 100);
        seqList.insert(4, 200);
        // [ 30, 20, 100, 10, 200, 1, 2, 3 ]
        System.out.println(seqList.toString());
        System.out.printf("当前容量: %d%n", seqList.capacity());

        seqList.pushBack(1000);
        seqList.pushBack(2000);
        seqList.pushBack(3000);
        seqList.pushBack(4000);
        seqList.pushBack(5000);
        seqList.pushBack(6000);
        System.out.printf("当前容量: %d%n", seqList.capacity());

        seqList.popFront();
        seqList.popFront();
        seqList.popFront();
        seqList.popFront();
        // [ 200, 1, 2, 3 ]
        System.out.println(seqList.toString());

        seqList.popBack();
        seqList.popBack();
        seqList.popBack();
        // [ 200 ]
        System.out.println(seqList.toString());
    }

    public static void test2(String[] args) {
        SeqList s = new SeqList();
        s.pushBack(1);
        s.pushBack(2);
        s.pushBack(3);
        s.pushBack(4);
        s.pushBack(1);
        s.pushBack(2);
        s.pushBack(3);
        s.pushBack(4);
        // [ 1, 2, 3, 4, 1, 2, 3, 4 ]
        System.out.println(s.toString());
        s.remove(2);
        // [ 1, 3, 4, 1, 2, 3, 4 ]
        System.out.println(s.toString());
        s.removeAll(4);
        // [ 1, 3, 1, 2, 3 ]
        System.out.println(s.toString());
    }

    public static void main(String[] args) {
        test1(args);
        test2(args);
    }
}
