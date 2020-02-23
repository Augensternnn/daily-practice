import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RomanToInt {
    public static int romanToInt(String s) {
        // V -- 5；X -- 10；L -- 50；C -- 100；D -- 500；M -- 1000
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        HashMap<Character, List<Character>> special = new HashMap<>();
        special.put('I', Arrays.asList('V', 'X'));
        special.put('X', Arrays.asList('L', 'C'));
        special.put('C', Arrays.asList('D', 'M'));
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i < s.length() - 1) {
                char next = s.charAt(i + 1);
                if (special.containsKey(c)) {
                    if (special.get(c).contains(next)) {
                        int nextInt = map.get(next);
                        int curInt = map.get(c);
                        n += (nextInt - curInt);
                        i++;
                        continue;
                    }
                }
            }
            int curInt = map.get(c);
            n += curInt;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("I"));
        System.out.println(romanToInt("II"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("V"));
        System.out.println(romanToInt("VI"));
        System.out.println(romanToInt("VII"));
        System.out.println(romanToInt("VIII"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("X"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}

