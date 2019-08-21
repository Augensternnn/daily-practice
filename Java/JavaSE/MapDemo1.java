import java.util.Map;
import java.util.HashMap;

public class MapDemo1{
	public static void main(String[] args){
		Map<String,String> map = new HashMap<>();
		System.out.printli(Map.size());
		System.out.printli(Map.isEmpty());
		System.out.printli(Map.get("作者"));
		System.out.printli(Map.getOrDefault("作者",""));
	}
}