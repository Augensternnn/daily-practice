import java.util.Arrays;

public class practice0817_3{
	private int size = 0;
	private int[] array;
	
	public practice0817_3(int[] array){
		this.array = new int[array.length];
		for(int i = 0; i < array.length; i++){
			this.array[i] = array[i];
		}
		size = array.length;
	}
	
	public void insert(int index, int element){
		if(index < 0 || index > size){
			System.out.printf("index 输入不合法");
			return;
		}
		
		ensureCapacity();
		
		/*
		System.arraycopy(array, index, array, index + 1, size - index);
		*/
		for(int i = size; i >= index; i--){
			array[i] = array[i-1];
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
		
		for(int i = 0;i < array.length; i++){
			newArray[i] = array[i];
		}
		array = newArray;
		/*
		int capacity;
        if(size < array.length){
            return;
        }else {
            capacity = 2 * array.length;
        }
        if(array != null){
            array = Arrays.copyOf(array, capacity)
        }else {
            array = new int[capacity];
        }
		*/
	}
	
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
		practice0817_3 arrayList = new practice0817_3(array);
		System.out.println(arrayList.toString());
		arrayList.insert(5, 106);	// 报错
		System.out.println(arrayList.toString());
		arrayList.erase(1);
		System.out.println(arrayList.toString());
	}
}