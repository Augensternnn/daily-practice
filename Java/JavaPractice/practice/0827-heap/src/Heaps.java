public class Heaps {
    /**
     *前提：除了 index 和它的孩子外，其他位置已经满足堆的性质了
     * 经过向下调整（堆化），最终完全成为一个堆
     * @param array  被看做堆的数组
     * @param size  数组中被看做堆的值的个数
     * @param index  要调整位置的下标
     */
    // 向下调整
    public static void heapify(int[] array, int size, int index){
        while (true){
            int left = 2 * index + 1;
            if(left >= size){
                return;
            }
            int max = left;
            if(left + 1 < size){
                if(array[left + 1] > array[left]){
                    max = left + 1;
                }
            }
            if(array[index] >= array[max]){
                return;
            }
            swap(array, index, max);
            index = max;
        }
    }
    public static void swap(int[] array, int i, int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    // 向上调整
    public  static void adjustUp(int[] array, int index){
        while(index >= 0) {
            if (index == 0) {
                return;
            }
            int parent = (index - 1) / 2;
            if (array[parent] >= array[index]) {
                return;
            }
            swap(array, index, parent);
            index = parent;
        }
    }

    // 建堆
    public static void createHeap(int[] array,int size){
        for(int i = (size - 2) / 2; i >= 0; i--){
            heapify(array,size,i);
        }
    }


}
