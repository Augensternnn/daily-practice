import java.util.Arrays;

public class practice0817_2 {
	private int size = 0;
	private int[] array;
	
	public practice0817_2() {
		array = new int[10];
	}
	public practice0817_2(int[] array){
		this.array = new int[array.length];
		for(int i = 0; i < array.length; i++){
			this.array[i] = array[i];
		}
		size = array.length;
	}
	
	// 将 element 插入到 index 所在下标处，对 index 进行合法性检验（取值范围[0,size]）
	public void insert(int index,int element){
		if(index < 0 || index > size){
			System.out.printf("index 输入不合法");
			return;
		}
		
		ensureCapacity();
		
		for(int i = size - 1; i >= index; i--){
			array[i + 1] = array[i];
		}
		array[index] = element;
		size++;
	}
	
	public void ensureCapacity(){
		if(size < array.length){
			return;
		}
		int oldCapacity = array.length;
		int newCapacity = oldCapacity + oldCapacity / 2;
		int[] newArray = new int[newCapacity];
		
		for(int i = 0; i < size; i++){
			newArray[i] = array[i];
		}
		array = newArray;
	}
	
	// 删除 index 下标处的元素值，对 index 进行合法性检验（取值范围：[0,size-1]）
	public void erase(int index){
		if(index < 0 || index > size-1){
			System.out.printf("index 输入不合法");
			return;
		}
		for(int i = index; i <= size-1; i++){
			array[i] = array[i+1];
		}
		size--;
	}
	
	public String toString(){
		return Arrays.toString(
			Arrays.copyOf(array,size)
			);
	}
	
	public static void main(String[] args){
		int[] array = { 1, 2, 3, 4, 5 };
		practice0817_2 arrayList = new practice0817_2(array);
		System.out.println(arrayList.toString());
		arrayList.insert(5, 106);	// 报错
		System.out.println(arrayList.toString());
		arrayList.erase(1);
		System.out.println(arrayList.toString());
	}
}