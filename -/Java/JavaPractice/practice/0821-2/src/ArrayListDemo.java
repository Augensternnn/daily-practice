import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>(100);
        Set<String> set = new HashSet<>();
        set.add("你好");
        set.add("世界");
        set.add("中国");
        List<String> list3 = new ArrayList<>(set);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }
}
