package test1108;

import java.util.Stack;

/**
 * 对于一个字符串，设计一个算法：判断其是否为一个合法的括号串。
 * 给定一个字符串 A 和它的长度 n，请返回一个 boolean 值代表它是否为一个合法的括号串。
 * 即：只包括括号字符；左括号和右括号一一对应
 */
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(')
                stack.push(A.charAt(i));
            if (A.charAt(i) == ')' && !stack.isEmpty())
                return A.charAt(i) == stack.pop();
            if (A.charAt(i) != '(' && A.charAt(i) != ')')
                return false;
        }
        return stack.isEmpty();
    }
}
