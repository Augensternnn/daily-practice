public class sort{
	// 插入排序
	public static void insertSort1(int[] array){
		// 有序区间     [0, i]
        // 无序区间     [i + 1, array.length]
        // 待插入的数据是 array[i + 1]
        // 插入过程在有序区间内查找
		for(int i = 0; i < array.length - 1; i++){
			int key = array[i + 1];
			int j;
			for(int j = i; j >= 0 && key < array[j]; j--){
				array[j + 1] = array[j];
			}
			array[j + 1] = key;
		}
	}
		
	public static void insertSort1(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			int key = array[i + 1];
			int j;
			for(j = i; j >= 0; j--){
				if(key >= array[j]){
						break;
				}
			}
			// j + 1 放 key 的位置
			for(int k = i; k > j; k--){
				array[k + 1] = array[k];
			}
			array[j + 1] = key;
		}
	}
	
	// 希尔排序
	public static void shellSort(int[] array){
		int gap = array.length;
		while(true){
			//  gap = gap / 3 + 1;    gap= gap / 2;
			gap = gap / 3 + 1;
			insertSortWithGap(array, gap);
		}
	}
	private static void insertSortWithGap(int[] array,int gap){
		for(int i = 0; i < array.length - gap; i++){
			int key = array[i + gap];
			int j;
			for(j = i;j >= 0 && key < array[j]; j -= gap){
				array[j + gap] = array[j];
			}
			array[j + gap] = key;
		}
	}
		
	// 直接选择排序
	public static void selectSort(int[] array){
		// 每次选最大的数
		for(int i = 0; i < array.length - 1; i++){
			// 无序区间 [0, array.length - i)
            // 有序区间 [array.length - i, array.length)
			int max = 0;
			for(int j = 1; j < array.length - i; j++){
				if(array[i] > max){
					max = j;
			}
		}
		// 交换最大的数和无序区间的最后一个数
		swap(array, max, array.length - i - 1);
		}
	}
	private static void swap(int[] array, int i, int j){
		
	}
}
