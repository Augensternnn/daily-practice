public class MyPriorityQueue {
    private int[] array = new int[100];
    private int size = 0;

    // O(log(n))
    public void add(int element){
        array[size++] = element;
        Heaps.adjustUp(array,size - 1);
    }

    // O(log(n))
    public int poll(){
        int e = array[0];
        array[0] = array[--size];
        Heaps.heapify(array, size, 0);
        return e;
    }

}
