import java.util.Arrays;

public class CopyOf {
    public static int[] copyOf(int[] src, int newLength){
        // newLength 可能大于、小于或等于 src.length
        int[] dest = new int[newLength];
        int minLength = src.length < newLength ? src.length : newLength;
        for(int i = 0; i < minLength; i++){
            dest[i] = src[i];
        }
        return dest;
    }

    public static void main(String[] args) {
        int[] array = new int[]{ 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(Arrays.toString(copyOf(array, 3)));
        System.out.println(Arrays.toString(copyOf(array, 10)));
    }
}
