import java.util.*;

public class problem01 {
    // 子域名访问计数
    public List<String> subdomainVisits(String[] cpdomains){
        Map<String, Integer> count = new HashMap<>();
        // 遍历整个字符串数组
        for(String cp : cpdomains){
            String[] t = cp.split(" ");
            int n = Integer.valueOf(t[0]);
            String domain = t[1];

            String[] u = domain.split("\\.");
            for(int i = 0; i < u.length; i++){
                String[] sub = Arrays.copyOfRange(u, i, u.length);
                // System.out.println(Arrays.toString(sub));
                String d = String.join(".", sub);
                // System.out.println(d);
                int oldCount = count.getOrDefault(d, 0);
                count.put(d, oldCount + n);
            }
            // System.out.println("=======================");
            System.out.println(count);
            List<String> result = new ArrayList<>();
            for(Map.Entry<String, Integer> e : count.entrySet()){
                String d = e.getKey();
                int v = e.getValue();
                result.add(v + " " + d);
            }
            return result;
        }
        return null;
    }
}
