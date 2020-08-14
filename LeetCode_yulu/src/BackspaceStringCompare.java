import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = constructStack(S);
        Stack<Character> t = constructStack(T);
        return s.equals(t);
    }
    public Stack<Character> constructStack(String S) {
        Stack<Character> s  = new Stack<>();
        for (Character c : S.toCharArray()) {
            if (c == '#') {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(c);
            }
        }
        return s;
    }

    public boolean backspaceCompare2(String S, String T) {
        char[] stack1 = new char[S.length()], stack2 = new char[T.length()];
        int top = conStructStack(S, stack1);
        if (conStructStack(T, stack2) != top) {
            return false;
        }
        for (int i = 0; i <= top; i++) {
            if (stack1[i] != stack2[i]) {
                return false;
            }
        }
        return true;
    }

    public int conStructStack (String S, char[] stack) {
        int top = -1;
        for (Character c : S.toCharArray()) {
            if (c == '#') {
                if (top >= 0) {
                    top--;
                }
            } else {
                stack[++top] = c;
            }
        }
        return top;
    }

    public void test() {

    }
}
