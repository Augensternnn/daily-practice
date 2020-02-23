public class Max {
    // 找最大值
    public static int max1(int[] array){
        int m = array[0];
        for(int i = 0; i < array.length; i++){
            if(array[i] > m){
                m = array[i];
            }
        }
        return m;
    }

    public static int max2(int[] array){
        int maxValue = Integer.MIN_VALUE;
        for(int item : array){
            if(item > maxValue){
                maxValue = item;
            }
        }
        return maxValue;
    }
}
