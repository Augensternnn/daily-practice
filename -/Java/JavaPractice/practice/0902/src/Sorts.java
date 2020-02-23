import java.util.Random;

public class Sorts {
    // 归并排序
    public static void mergeSort(int[] array){
        mergeSortInternal(array, 0, array.length);
    }
    private static void mergeSortInternal(int[] array, int low, int high){
        /*
        int length = high - low;
        if(length <= 1){
            return;
        }
         */
        if(low + 1 >= high){
            return;
        }
        int mid = (low + high) / 2;
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array, mid, high);
        merge(array, low, mid, high);
    }
    private static void merge(int[] array, int low, int mid, int high){
        int length = high - low;
        int[] extra = new int[length];
        int iLeft = low;
        int iRight = mid;
        int iExtra = 0;
        while(iLeft < mid && iRight < high){
            if(array[iLeft] < array[iRight]){
                extra[iExtra++] = array[iLeft++];
            }else{
                extra[iExtra++] = array[iRight++];
            }
        }
        while(iLeft < mid){
            extra[iExtra++] = array[iLeft++];
        }
        while (iRight < high){
            extra[iExtra++] = array[iRight++];
        }
        for(int i = 0; i < length; i++){
            array[low + i] = extra[i];
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            boolean sorted = true;
            for(int j = 0; j < array.length - i - 1; j++){
                if (array[j] > array[j + 1]){
                    swap(array, j, j+1);
                    sorted = false;
                }
            }
            if(sorted){
                break;
            }
        }
    }
    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        Person[] people = new Person[20];
        Random random = new Random(201909020);
        for(int i = 0; i < people.length; i++){
            people[i] = new Person();
        }
    }
}
