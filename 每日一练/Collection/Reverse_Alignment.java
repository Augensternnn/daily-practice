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


    
    /*
    public int count(int[] A, int n){
        if(A == null || n == 0){
            return 0;
        }
        return mergeSortRecursion(A, 0, n-1);
    }
    public static int mergeSortRecursion(int[] arr, int l, int r){
        if(l == r){
            return 0;
        }
        int mid = (l + r) / 2;
        // 逆序对总数 = 左边数组中逆序对数量 + 右边数组中逆序对数量 +左右结合成新的顺序数组中逆序对的数量
        return mergeSortRecursion(arr, 1, mid) + mergeSortRecursion(arr, mid+1, r) + merge(arr, 1, mid, r);
    }
    public static int merge(int[] arr, int left, int mid, int right){
        int[] tmp = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        int inverseNum = 0;     //  新增，用来累加数组逆序对
        while (i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                tmp[index++] = arr[j++];
            }else {
                // 当前一个数组元素大于后一个数组元素时，累加逆序对
                // s[i] > s[j] 推导出 s[i] ... s[mid] > s[j]
                inverseNum += (mid - i + 1);
                tmp[index++] = arr[j++];
            }
        }
        while (i <= mid){
            tmp[index++] = arr[i++];
        }
        while (j <= right){
            tmp[index++] = arr[j++];
        }
        for (int k = 0; k < tmp.length; k++){
            arr[left++] = tmp[k];
        }
        return inverseNum;
    }

     */
}
