public class IndexOf {
    // key 在数组中第一次遇到的下标，如果数组中没有 key ，返回 -1
    public static int indexOf(int[] array, int key){
        for(int i = 0; i < array.length; i++){
            if(key == array[i]){
                return i;
            }
        }
        return -1;
    }
}
