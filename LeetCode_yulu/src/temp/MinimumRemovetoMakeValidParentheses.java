package temp;

import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {
    //本题的关键点在于括号的组合有多种情况，比如（（））， （（（））， ））（（））， （（）））等
    //有可能要删掉），有可能要删掉（，第二种情况需要知道要删掉的地方在哪里，所以stack里面push的不能是(，而应该是index，但是又不能直接delete,因为随着不断地删减，
    //index会发生变化，所以可以先把要删掉的地方标记出来，最后统一替换掉
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length();i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '*');
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        return sb.toString().replaceAll("\\*", "");
    }

    public String minRemoveToMakeValid2(String s) {
        int[] stack = new int[s.length()];
        StringBuilder sb = new StringBuilder(s);
        int top = -1;
        for (int i = 0; i < s.length();i++) {
            if (s.charAt(i) == '(') {
                stack[++top] = i;
            } else if (s.charAt(i) == ')') {
                if (top >= 0) {
                    top--;
                } else {
                    sb.setCharAt(i, '*');
                }
            }
        }
        while (top >= 0) {
            sb.setCharAt(stack[top--], '*');
        }
        return sb.toString().replaceAll("\\*", "");
    }
}
