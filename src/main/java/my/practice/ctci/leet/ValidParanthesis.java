package my.practice.ctci.leet;

import java.util.Stack;

/**
 * @author Vishal Joshi
 */
public class ValidParanthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            } else if((ch == ']' && stack.pop() != '[')
                    || (ch == ')' && stack.pop() != '(')
                    || (ch == '}' && stack.pop() != '{')) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
