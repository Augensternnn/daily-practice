import java.util.ArrayList;
import java.util.List;
public class PascalsTriangle{
	public List<List<Integer>> general(int numRows){
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0; i < numRows; i++){
			list.add(new ArrayList<>(i + 1));
		}
		list.get(0).add(1);
		list.get(1).add(1);
		list.get(1).add(1);
		for(int i = 2; i < numRows; i++){
			List<Integer> nums = list.get(i);
			nums.add(1);
			for(int j = 1; j < i; j++){
				int num = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
				nums.add(num);
			}
			nums.add(1);
		}
		return list;
	}
	
	//错误
	public List<List<Integer>> general2(int numRows){
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0; i < numRows; i++){
			List<Integer> nums = new ArrayList<>();
			nums.add(1);
			for(int j = 2; j <= i - 2; j++){
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
	
	private static void printPascalsTriangle(PascalsTriangle s,int n){
		System.out.println(s.general2(n));
	}
	
	public static void main(String[] args){
		PascalsTriangle s = new PascalsTriangle();
		printPascalsTriangle(s,4);
	}
}