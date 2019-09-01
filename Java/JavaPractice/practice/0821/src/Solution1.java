import java.util.ArrayList;

public class Solution1 {
    // 括号问题
    public boolean isValid(String s){
        ArrayList<Character> stack = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            switch (ch){
                case '(':
                case '[':
                case '{':
                    stack.add(ch);
                case ')':
                case ']':
                case '}':
                    if(stack.isEmpty()){
                        return false;
                    }
                    char left = stack.remove(stack.size() - 1);
                    if(!match(left,ch)){
                        return false;
                    }
                    break;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean match(char left, char right){
        if(left == '(' && right == ')'){
            return true;
        }
        if(left == '[' && right == ']'){
            return true;
        }
        if(left == '{' && right == '}'){
            return true;
        }
        return false;
    }
}
