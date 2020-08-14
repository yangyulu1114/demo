import java.util.Stack;
//以下三种写法都是栈实现的三种不同方式,时间复杂度均为O(N)。还有一种是用replace方法，没写，因为时间复杂度要高一些，为O(N^2)
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (stack.isEmpty() || c != stack.peek()) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String removeDuplicates2(String S) {
        char[] stack = new char[S.length()];
        int index = -1;
        for (char c : S.toCharArray()) {
            if (index == -1 || c != stack[index]) {
                stack[++index] = c;
            } else {
                index--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (index >= 0) {
            sb.append(stack[index--]);
        }
        return sb.reverse().toString();
    }

    public String removeDuplicates3(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char c : S.toCharArray()) {
            if (sbLength == 0 || c != sb.charAt(sbLength - 1)) {
                sb.append(c);
                sbLength++;
            } else {
                sb.deleteCharAt((sbLength--) - 1);
            }
        }
        return sb.toString();
    }
}
