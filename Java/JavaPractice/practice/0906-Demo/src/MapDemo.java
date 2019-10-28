import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "world");
        map.put(3, "java");
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("============");
        map.put(1, "你好");
        map.put(2, "世界");
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
