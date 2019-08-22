import java.util.Arrays;

public class ArrayList implements List {
    int[] array = null;
    int size = 0;

    @Override
    public boolean add(int element) {
        return add(size, element);
    }

    @Override
    public boolean add(int index, int element) {
        if(index < 0 || index > size){
            System.out.println("下标不合法");
            return false;
        }
        ensureCapacity();
        System.arraycopy(array, index, array, index+1, size-index);
        array[index] = element;
        size++;
        return true;
    }

    private void ensureCapacity(){
        if(array != null && size < array.length){
            return;
        }
        int capacity;
        if(array == null){
            capacity = 10;
        }else{
            capacity = 2 * array.length;
        }
        if(array != null){
            array = Arrays.copyOf(array,capacity);
        }else{
            array = new int[capacity];
        }
    }

    @Override
    public int remove(int index) {
        if(index < 0 || index >= size){
            System.out.println("下标不合法");
            return -1;
        }
        int oldVal = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return oldVal;
    }

    @Override
    public int get(int index) {
        if(index < 0 || index >= size){
            System.out.println("下标不合法");
            return -1;
        }
        return array[index];
    }

    @Override
    public int set(int index, int element) {
        if(index < 0 || index >= size){
            System.out.println("下标不合法");
            return -1;
        }
        int oldVal = array[index];
        array[index] = element;
        return oldVal;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array,size));
    }
}
