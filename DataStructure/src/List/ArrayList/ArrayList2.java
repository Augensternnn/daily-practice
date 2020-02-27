 package List.ArrayList;

 import java.util.ArrayList;
 import java.util.List;

 public class ArrayList2 {
    private int size;
    private int[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList2(int capaCity) {
        capaCity = (capaCity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaCity;
        elements = new int[capaCity];
    }
    public ArrayList2(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * 元素的数量
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(int element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到最后面
     * @param element
     */
    public void add(int element){
        add(size,element);
    }

    /**
     * 返回index位置对应的元素
     * @param index
     * @return
     */
    public int get(int index){
        rangeCheck(index);
        return elements[size];
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素
     */
    public int set(int index,int element){
        rangeCheck(index);
        int old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 往index位置添加元素
     * @param index
     * @param element
     */
    public void add(int index,int element){
        rangeCheckForAdd(index);
        ensureCapacity(size+1);
        for(int i = size; i > index; i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 删除index位置对应的元素
     * @param index
     * @return
     */
    public int remove(int index){
        rangeCheck(index);
        int old = elements[index];
        for(int i = index+1; i < size; i++){
            elements[i-1] = elements[i];
        }
        size--;
        return old;
    }

    /**
     * 查看元素的位置
     * @param element
     * @return
     */
    public int indexOf(int element){
        for(int i = 0; i < size; i++){
            if(elements[i] == element)
                return i;
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 清除所有元素
     */
    public void clear(){
        size = 0;
    }

     /**
      * 保证要有capacity的容量
      * @param capacity
      */
    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;
        if(oldCapacity >= capacity)
            return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);//左移1：乘2，右移1：除2
    }

    private void outOfBounds(int index){
        throw new IndexOutOfBoundsException("index："+index+"，Size："+size);
    }
    private void rangeCheck(int index){
        if(index<0 || index>=size)
            outOfBounds(index);
    }
     private void rangeCheckForAdd(int index){
         if(index<0 || index>size)
             outOfBounds(index);
     }

    @Override
    public String toString() {
        //size=3, [99, 88, 77]
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        //法一：
        /*for (int i = 0; i < size; i++) {
            string.append(elements[i]);
            if(i != size-1){
                string.append(", ");
            }
        }*/
        //法二：
        for (int i = 0; i < size; i++) {
            if(i != 0){
                string.append(", ");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
