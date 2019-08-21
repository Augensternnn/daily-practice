import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class CollectionDemo2 {
	public static void main(String[] args){
		Collection<String> collection = new ArrayList<>();
		collection.add("陕西");
		collection.add("科技");
		collection.add("大学");
		System.out.println(collection.size());
		System.out.println(collection.isEmpty());
		Object[] array1 = collection.toArray();
		System.out.println(Arrays.toString(array1));
		collection.remove("陕西");
		System.out.println(collection.size());
		System.out.println(collection.isEmpty());
		Object[] array2 = collection.toArray();
		System.out.println(Arrays.toString(array2));
		collection.clear();
		System.out.println(collection.size());
		System.out.println(collection.isEmpty());
		Object[] array3 = collection.toArray();
		System.out.println(Arrays.toString(array3));
	}
}