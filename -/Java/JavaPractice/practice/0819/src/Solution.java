import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

import java.util.ArrayList;
import java.util.List;

// 打印杨辉三角
public class Solution {
    public List<List<Integer>> generate1(int numRows){
        List<List<Integer>> list = new ArrayList<>();
        /*
        *   List<List<Integer>> list;
        *   list 是一种引用，List 类型的接口引用（Java 语法）
        *   list 逻辑上是一种线性表
        *   线性表的元素类型是 List<Integer>
                （java 语法）List 类型的接口引用
                             元素类型是 Integer 类类型的引用
                             Integer 是 int 的包装类
        * */
        for(int i = 0; i < numRows; i++){
            list.add(new ArrayList<>(i + 1));
        }
        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);
        for(int i = 2; i < numRows; i++){
            List<Integer> nums = list.get(i);
            nums.add(1);
            for(int j = 1;j < i;j++){
                int num = list.get(i - 1).get(j - 1)
                        + list.get(i - 1).get(j);
                nums.add(num);
            }
            nums.add(1);
        }
        return list;
    }

    public List<List<Integer>> generate2(int numRows){
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> nums = new ArrayList<>();
            nums.add(1);
            for(int j = 0; j <= i - 2; j++){
                List<Integer> preNums = list.get(i - 1);
                int p = preNums.get(j);
                int q = preNums.get(j + 1);
                int n = p + q;
                nums.add(n);
            }
            if(i != 0){
                nums.add(1);
            }
            list.add(nums);
        }
        return list;
    }

    private static void printPascalsTriangle(Solution s, int n){
        System.out.println(s.generate3(n));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        printPascalsTriangle(solution,4);
    }
}

