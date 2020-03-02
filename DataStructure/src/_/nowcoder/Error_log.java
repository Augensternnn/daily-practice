package _.nowcoder;

import java.util.*;

/**
 * 错误记录
 * https://www.nowcoder.com/questionTerminal/67df1d7889cf4c529576383c2e647c48
 */
public class Error_log {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        String key,filename,path;
        while (sc.hasNext()){
            path = sc.next();
            int id = path.lastIndexOf("\\");
            filename = (id<0) ? path : path.substring(id+1);
            int rows = sc.nextInt();
            key = filename + " " + rows;
            if(map.containsKey(key))
                map.put(key,map.get(key)+1);
            else
                map.put(key,1);
        }
        sc.close();
        //对记录进行排序
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            //降序
            @Override
            public int compare(Map.Entry<String, Integer> arg0, Map.Entry<String, Integer> arg1) {
                return(arg1.getValue()-arg0.getValue()) == 0? (arg0.getValue()-arg1.getValue()) : (arg1.getValue()-arg0.getValue());
            }
        });
        //只输出前8条
        int m=0;
        for(Map.Entry<String, Integer> mapping : list){
            m++;
            if(m<=8){
                String[] str = mapping.getKey().split(" ");
                String k = str[0].length()>16 ? str[0].substring(str[0].length()-16) : str[0];
                String n = str[1];
                System.out.println(k+" "+n+" "+mapping.getValue());
            }else{
                break;
            }
        }
    }
}
