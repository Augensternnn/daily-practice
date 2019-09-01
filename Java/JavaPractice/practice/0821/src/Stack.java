import java.util.Arrays;

public class Stack {
    private int[] array = new int[10];
    private int top = 0;

    private void ensureCapacity() {
        if(top < array.length){
            return;
        }
        array = Arrays.copyOf(array, 2 * array.length);
    }

    public int push(int element) {
        ensureCapacity();
        array[top++] = element;
        return element;

    }
    public void pop() {

    }
    public int top() {

    }
    public boolean isEmpty() {

    }
    public int size() {
        return top;
    }
}
