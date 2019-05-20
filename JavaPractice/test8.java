/*
二分查找
前提：数组已经有序		public static int binarySearch(int[] array,int key);
在有序数组中查找key：如果找到，返回所在下标；如果没找到，返回-1.
*/

/*
冒泡排序
public static void swap(int array[],int i,int j){
	int t = array[i];
	array[i] = array[j];
	array[j] = t;
}
public static void bubbleSort(int[] array);
*/

/*
冒泡排序
1.依次比较相邻的两个数，永远让最大的数在后边。走完整个未排序区间一定能保证 最大的数会被推到最后去
	冒泡一次，可以让一个最大的数放到最后，一共经过n次
*/

public class test8{
	//二分查找
	/*
	1.可以继续循环的条件是：left和right确定的区间内还有数，left < right
	2.根据left和right计算中间位置的下标mid
		int mid = （left + right） / 2;
		int mid = left + （right - left) / 2;
	3.比较array[mid]和key
	（1）array[mid] == key		return mid;
	（2）key < array[mid]		right = mid;
	（3）key > array[mid]		left = mid + 1;
	*/
	public static int binarySearch(int[] array,int key){
		int left = 0;
		int right = array.length;
		//[left,right)	区间内还有数
		while(left < right){
			//计算中间位置的下标
			int mid = left + (right - left) / 2;
			//比较
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
	
	//冒泡排序
	
		//交换 array 数组的 i 和 j 下标位置的数
			//因为修改 array[i] 对应的修改就是引用共同指向的数据，所以修改是可以生效的
	public static void swap(int[] array,int i,int j){
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
		//冒泡排序
	public static void bubbleSort(int[] array){
			//减治算法:一次处理一个数
		for(int i = 0; i < array.length; i++){
				//需要经过 array.length 次冒泡
				//所谓的冒泡过程
				//在无序区间内，经过两两比较，把最大的数冒泡到最后
				
				boolean isSwapped = false;
				
				//无序：	[0,array.length - i]
				//有序：	[array.length - i, array.length]
				//进行冒泡过程，遍历整个无序区间
				for(int j = 0; j < array.length - i - 1; j++){
					//冒泡的过程中，保证大的数在后边
					if(array[j] > array[j + 1]){
						swap(array, j, j + 1);
						isSwapped = true;
					}
				}
		
				//如果一次完成的冒泡排序过程中，一次交换都没有发生，表明数组已经有序，所以排序完成
				if(!isSwapped){
					return;
				}
		}
	}
	
	public static void printArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.printf("%d%n",array[i]);
		}
	}
	
	public static void main(String[] args){
		//初始化一个数组出来
		int[] randomArray = new int[]{9,5,2,7,3,6,4,8};
		bubbleSort(randomArray);
		//System.out.println(Arrays.tostring(array));
		printArray(randomArray);
		
		
	}
}