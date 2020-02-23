public class test7{
	//找最大值
	public static int max(int[] array){
		int maxValue = Integer.MIN_VALUE;
		//int maxValue = array[0];
		for(int item : array){
			if(item > maxValue){
				maxValue = item;
			}
		}
		return maxValue;
	}

	//key在数组中第一次遇到的下标，如果数组中没有key，返回-1
	public static int indexOf(int[] array, int key){
		for(int i = 0; i < array.length; i++){
			if(array[i] == key){
				return i;
			}
		}
		return -1;
	}
	
	//给定一个数组，求平均分（去掉一个最低分和一个最高分）
	public static double average(int[] scores){
		int minValue = scores[0];
		int maxValue = scores[0];
		int sum = scores[0];
		for(int i = 1; i < scores.length; i++){
			if(scores[i] < minValue){
				minValue = scores[i];
			}
			if(scores[i] > maxValue){
				maxValue = scores[i];
			}
			sum += scores[i];
		}
		return (double)(sum - minValue - maxValue) / (scores.length - 2);
	}
	
	//完成数组拷贝
	public static int[] copyOf(int[] src, int newLength){
		//newLength 可能大于 src.length;
		//newLength 可能小于等于 src.length;
		int[] dest = new int[newLength];
		//利用默认值的特性，每个元素都是0
		int minLength = src.length < newLength ? src.length : newLength;
		for(int i = 0; i < minLength; i++){
			dest[i] = src[i];
		}
		return dest;
	}
	
	public static void main(String[] args){
		//初始化一个数组出来
		int[] array = {1,3,5,7,9,10};
		
		int maxValue = max(array);
		System.out.println("最大值是 " + maxValue);
		
		int index = indexOf(array, 19);
		System.out.println("19的下标是 " + index);
		
		//println后面的参数只能是一个字符串
		double averageScore = average(array);
		System.out.printf("平均分是 %.4f%n", averageScore);
	}
}
