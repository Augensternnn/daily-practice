import java.util.Arrays;

// 线性表
abstract class List {
	private int size;	// 保存线性表中的数据个数
	
	List() {
		size = 0;
	}
	
	public void pushFront(int val) {
		insertInternal(0, val);
	}
	
	public void pushBack(int val) {
		insertInternal(size, val);
	}
	
	// 抽象方法，只给出方法签名，没有方法实现
	// 方法实现子类来完成
	public void insert(int index, int val) {
		if (index < 0 || index > size) {
			System.out.println("index 越界");
		}
		
		insertInternal(index, val);
	}
	
	protected abstract void insertInternal(int index, int val);
	
	protected void incSize() {
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
	public void insertInternal(int index, int val) {
		ensureCapacity();     //考虑扩容
		
		for (int i = getSize(); i > index; i--) {
			array[i] = array[i - 1];
		}
		
		array[index] = val;
		
		super.incSize();
	}
	
	@Override
	public void display() {
		for (int i = 0; i < getSize(); i++) {
			System.out.println(array[i]);
		}
	}
	
	private void ensureCapacity() {
		if (getSize() < array.length) {
			return;
		}
		
		array = Arrays.copyOf(array, 2 * array.length);
	}
}

class Node {
	int val;
	Node next = null;
	
	Node(int val) {
		this.val = val;
	}
	
	Node(int val, Node next) {
		this.val = val;
		this.next = next;
	}
}

class LinkedList extends List {
	private Node head = null;
	
	@Override
	public void insertInternal(int index, int val) {
		if (index == 0) {
			head = new Node(val, head);
		} else {
			// 找到 index 位置的前一个结点
			Node prev = head;
			for (int i = 0; i < index - 1; i++) {
				prev = prev.next;
			}
			// 在这个结点后面插入 val 结点
			prev.next = new Node(val, prev.next);
			/*
			Node node = new Node(val);
			node.next = prev.next;
			prev.next = node;
			*/
		}
		
		incSize();
	}
	
	@Override
	public void display() {
		for (Node cur = head; cur != null; cur = cur.next) {
			System.out.println(cur.val);
		}
	}
}

public class Course0623 {
	static void testList(List list) {
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		list.pushFront(10);
		list.pushFront(20);
		list.pushFront(30);
		list.insert(3, 100);
		
		list.display();
	}
	
	public static void main(String[] args) {
		//List obj = new List();	// 错误，因为是抽象类
		// LinkedList list = new LinkedList();
		testList(new ArrayList());
		testList(new LinkedList());
	}
}
