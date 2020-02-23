 package List.ArrayList;

public class ArrayList2 {
    private int size;
    private int[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList2(int capaCity) {
        capaCity = (capaCity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaCity;
        elements = new int[capaCity];
    }
    private ArrayList2(){
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
        elements[size++] = element;
    }

    /**
     * 返回index位置对应的元素
     * @param index
     * @return
     */
    public int get(int index){
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException("index："+index+"，Size："+size);
        return elements[size];
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素
     */
    public int set(int index,int element){
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException("index："+index+"，Size："+size);
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

    }

    /**
     * 删除index位置对应的元素
     * @param index
     * @return
     */
    public int remove(int index){
        return 0;
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
}
