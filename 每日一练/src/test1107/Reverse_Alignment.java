package test1107;

public class Reverse_Alignment {
    public int count(int[] arr, int n){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[i])
                    count++;
            }
        }
        return count;
    }
}
