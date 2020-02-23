import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("学生1"));
        System.out.println(map.getOrDefault("学生1","没有学生1"));
        System.out.println(map.get("学生1"));

        map.put("学生1","01234");
        map.put("学生2","56789");
        System.out.println("======================");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("学生1"));
        System.out.println(map.getOrDefault("学生1","啦啦啦"));
        System.out.println(map.get("学生1"));
        System.out.println("=======================");
        System.out.println(map.containsKey("学生3"));
        System.out.println(map.containsValue("01234"));
        System.out.println("=======================");
        Set<Map.Entry<String, String>> entryset = map.entrySet();
        for(Map.Entry<String, String> entry : entryset){
            System.out.println(entry.getKey() + "=");
            System.out.println(entry.getValue());
        }

    }
}
