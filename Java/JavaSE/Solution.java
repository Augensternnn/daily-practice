import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate0(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> nums = new ArrayList<>();
            nums.add(1);
            for (int j = 0; j <= i - 2; j++) {
                List<Integer> preNums = list.get(i - 1);
                int p = preNums.get(j);
                int q = preNums.get(j + 1);
                int n = p + q;

                nums.add(n);
            }
            if (i != 0) {
                nums.add(1);
            }

            list.add(nums);
        }

        return list;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> list;
        list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= numRows; i++) {
            for (int j = 0; j < i; j++) {
                list.get(i).add(1);
            }
        }
    }

    private static void printPascalsTriangle(Solution s, int n) {
        System.out.println(s.generate(n));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        printPascalsTriangle(solution, 10);
    }
}
