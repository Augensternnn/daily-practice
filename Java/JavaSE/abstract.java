// 线性表
class List {
	private int size;	// 保存线性表中的数据个数
	
	List() {
		size = 0;
	}
	
	public void pushFront(int val) {
		insert(0, val);
	}
	
	public void pushBack(int val) {
		insert(size, val);
	}
	
	//抽象方法：只给出方法签名，没有方法实现
	//方法实现由子类完成
	public abstract void insert(int index, int val);
	
	protected void IncSize(){
		size++;
	}
	
	public int getSize() {
		return size;
	}
	
	abstract public void display();
	
}
// 顺序表 extends 线性表
class ArrayList extends List {
	private int[] array;
	
	// 这里其实可以不写
	ArrayList() {
		super();
		array = new int[10];
	}

	// 重写
	// 注解:@Override;保证代码正确性（编译器会帮忙检查其覆写是否正确）
	@Override
	public void insert(int index, int val) {
		for (int i = getSize(); i > index; i--) {
			array[i] = array[i - 1];
		}
		
		array[index] = val;
		
		super.IncSize();
	}	
	
	@Override
	public void display() {
		for (int i = 0; i < getSize(); i++) {
			System.out.println(array[i]);
		}
	}
	
}
public class abstract {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		list.pushFront(10);
		list.pushFront(20);
		list.pushFront(30);
		list.insert(3, 100);
		
		list.display();
	}
}

