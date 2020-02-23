public class BinarySearch {
    /*
    二分查找
    前提：数组已经有序
    在有序数组中查找 key ，如果找到：返回所在下标；没找到：返回 -1
     */

    public static int binarySearch(int[] array, int key){
        int left = 0;
        int right = array.length;
        while(left < right){
            // int mid = (right + left) / 2;
            int mid = left + (right - left) / 2;
            if(key == array[mid]){
                return mid;
            }else if(key < array[mid]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
