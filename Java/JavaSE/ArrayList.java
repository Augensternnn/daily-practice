import java.util.Arrays;

public class ArrayList {
	private int size = 0;
	private int[] array;
	
	public ArrayList(){
		array = new int[10];
	}	
	// 用构造方法去初始化，方便测试
	public ArrayList(int[] array){
		// this.array（属性，即定义的整型数组变量） 和 array（形参array） 不是一回事
		// 申请的空间至少要 array.length 长
		this.array = new int[array.length];
		
		// 把传入数组的所有元素 copy 到属性 array 中
		for(int i = 0; i < array.length; i++){
			this.array[i] = array[i];
		}
		// 记得更新 size
		size = array.length;
	}
	
	// 将 element 插入到 index 所在的下标处
		// 要求：对 index 做合法性检验		
		// index 取值范围[0, size]
		
	// 最坏情况是 index == 0 的时候，时间复杂度 O(n)
	public void insert(int index,int element){
		if(index < 0 || index > size){
			System.out.printf("index 取值范围是 [0, %d]%n", size);
			// 【注】若要接着往下写，如写插入过程：需加入 return 或者 写成 if(){..}else{..} 的形式，否则即使 index 不合法，也会继续往下执行
			return;
		}
		
		// 要确保空间够用，否则进行扩容
		ensureCapacity();
		
		// 插入过程
			// 将 [index, size-1] 内的数据往后搬移一格（倒着遍历）
		for(int i = size - 1;i >= index; i--){
			array[i+1] = array[i];
		}
		array[index] = element;
		size++;
	}
	
	private void ensureCapacity(){
		if(size < array.length){
			return;
		}
		// 否则进行扩容	
			// 1.申请新空间，通常大小是 1.5 或 2 倍（避免浪费）
		int oldCapacity = array.length;
		int newCapacity = oldCapacity + oldCapacity / 2;
		int[] newArray = new int[newCapacity];
			// 2.搬家
		for(int i = 0; i < size; i++){
			newArray[i] = array[i];
		}
			// 3.通知大家我的新地址
		array = newArray;
			// 4.释放老空间，Java中 GC 会回收
	}
	
	//打印
	public String toString(){
		return Arrays.toString(
			Arrays.copyOf(array,size)
			);
	}
	
	// 删除 index 下标处的元素
	// 要求：对 index 做合法性检验		
		// index 取值范围[0, size-1]
	
	// 最坏情况是 index == 0 的时候，时间复杂度 O(n)
	public void erase(int index){
		if(index < 0 || index >= size){
			System.out.printf("index 取值范围是 [0, %d]%n", size - 1);
			return;
		}
		
		// 将 [index + 1, size-1] 内的数据往前搬移一格（从前往后遍历）
		for(int i = index + 1; i <= size - 1;i++){
			array[i - 1] = array[i];
		}
		size--;
		/*
			for(int i = index; i <= size - 1;i++){
				array[i] = array[i+1];
			}
			size--;
		*/
		//可选
		array[size] = 0;
	}
	
	public static void main(String[] args){
		int[] array = {1, 2, 3, 4, 5 };
		ArrayList arrayList = new ArrayList(array);
		System.out.println(arrayList.toString());
		arrayList.insert(5, 106);	// 若不进行扩容，会报错（因为在表的末尾插入，空间不够用）
		System.out.println(arrayList.toString());
		arrayList.erase(1);
		System.out.println(arrayList.toString());
	}
}