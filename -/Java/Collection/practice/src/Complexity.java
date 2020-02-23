import java.util.Arrays;

public class Complexity {
    public void bubbleSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j+1]){
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
    }
    // 返回 key 所在的下标
    public static int binarySearch(int[] array, int key){
        int left = 0;
        int right = array.length;
        // 只要 [left, right) 还有数据，循环继续
        while (left < right){
            // 1. 计算中间位置的下标
            int mid = left + (right - left) / 2;
            // 2. 根据 array[mid] 和 key 的大小关系，决定下一步
            if(key == array[mid]){
                return mid;     // 找到了，返回下标
            }else if(key < array[mid]){
                // key 只能在 mid 的左边
                // 重新调整 [left, right) 表示的区间
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 1, 9, 5, 8, 3, 2, 4, 6, 7 };

        // 一般不这么做
        Complexity c = new Complexity();
        c.bubbleSort(array);	// 1. array[]
        // 2. 静态方法不能直接调用方法

        System.out.println(Arrays.toString(array));
    }
}
