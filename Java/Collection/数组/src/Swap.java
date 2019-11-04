public class Swap {
    /*
    交换 array 数组的 i 和 j 下标位置的数
    因为修改 array[i] 对应的修改就是引用共同指向的数据，所以修改是可以生效的
     */
    public static void swap(int[] array, int i, int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
