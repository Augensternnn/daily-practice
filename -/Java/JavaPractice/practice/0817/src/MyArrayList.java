import java.util.Arrays;

public class MyArrayList implements List{
    private int size = 0;
    private int[] array;

    @Override
    public boolean add(int element) {
        array[size] = element;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, int element) {
        if(index < 0 || index > array.length) {
            return false;
        }

        ensureCapacity();

        System.arraycopy(array, index, array, index + 1, size - index);

        size++;
        return true;
    }

    private void ensureCapacity(){
        int capacity;
        if(size < array.length){
            return;
        }else {
            capacity = 2 * array.length;
        }
        if(array != null){
            array = Arrays.copyOf(array, capacity)
        }else {
            array = new int[capacity];
        }
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public int set(int index, int val) {
        array[index] = val;
        return 0;
    }

    @Override
    public int remove(int index) {
        if(index < 0 || index > size - 1){
            System.out.println("index 下标不合法！");
        }else{
            for(int i = index; i < size; i++)
            {
                array[i] = array[i+1];
            }
            size--;
        }
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        if(size != 0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
