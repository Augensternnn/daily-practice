import java.util.HashMap;
import java.util.Map;
// 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
public class problem01 {
    Map<Integer,Integer> count(int[] numbers){
        // key --> 数字
        // value --> 该数字出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : numbers){
            // 判断下 n 在不在 map 中
                // 不在 --> 出现次数是1 ；在 --> 出现次数 +1
            int c = map.getOrDefault(n, 0);
            map.put(n, c + 1);
        }
        // 统计好每个数字的出现次数
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            int n= e.getKey();
            int c = e.getValue();
            if(c == 1){
                return n;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 1, 2, 4, 9, 2, 3, 1, 5, 8, 7, 2, 3};
        Map<Integer,Integer> map = count(numbers);
        System.out.println(map);
        /*
        KeySet();          取出所有的 key 所有的数字
        values();          取出的所有的 value 所有的出现次数
        entrySet();        所有的 数字及其出现次数的键值对
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int number = entry.getKey();
            int cnt = entry.getValue();
            if(cnt == 2){
                System.out.println(number);
            }
        }
         */
    }
}
