public class BubbleSort {
    public static void swap(int[] array, int i, int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    // 冒泡排序
    public static void bubbleSort(int[] array){
        // 减治算法
        for(int i = 0; i < array.length; i++){
            // 需要经过 array.length 次冒泡，即在无序区间内经过两两比较，把最大的数冒泡至最后
            boolean isSwapped = false;

            // 无序：[ 0, array.length - i )
            // 有序：[ array.length - i, array.length )
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    swap(array, j, j+1);
                    isSwapped = true;
                }
            }
            // 如果一次完整的冒泡过程中，一次交换都没有发生,表明数组已经有序，所以排序完成
            if(!isSwapped){
                return;
            }
        }
    }
}
