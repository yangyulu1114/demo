import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                parentheses.push(s.charAt(i));
            } else if (!parentheses.isEmpty() && ((parentheses.peek() == '(' && s.charAt(i) == ')') || (parentheses.peek() == '[' && s.charAt(i) == ']') ||
                    (parentheses.peek() == '{' && s.charAt(i) == '}'))) {
                parentheses.pop();
            } else {
                return false;
            }
        }
        return parentheses.isEmpty();
    }

    public boolean isValid2(String s) {
        int top = -1;
        char[] stack = new char[s.length() + 1];
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack[++top] = c;
                    break;
                case ')':
                    if (top >= 0 && stack[top] == '(') {
                        top--;
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (top >= 0 && stack[top] == '[') {
                        top--;
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (top >= 0 && stack[top] == '{') {
                        top--;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return top == -1;
    }

    public void test() {
        String s = "{[]}";
        boolean result = isValid2(s);
        System.out.println(result);
    }
}
