import java.util.HashMap;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty()) {
                if (T[i] > T[stack.peek()]) {
                    map.put(stack.pop(), i);
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        for (int i = 0; i < T.length; i++) {
            T[i] = map.getOrDefault(i, - 1) == -1 ? 0 : map.get(i) - i;
        }
        return T;
    }

    public int[] dailyTemperatures2(int[] T) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] stack = new int[T.length];
        int top = -1;
        for (int i = 0; i < T.length; i++) {
            while (top >= 0) {
                if (T[i] > T[stack[top]]) {
                    map.put(stack[top], i - stack[top]);
                    top--;
                } else {
                    break;
                }
            }
            stack[++top] = i;
        }
        for (int i = 0; i < T.length; i++) {
            T[i] = map.getOrDefault(i, 0);
        }
        return T;
    }

    public int[] dailyTemperatures3(int[] T) {
        int[] map = new int[T.length];
        int[] stack = new int[T.length];
        int top = -1;
        for (int i = 0; i < T.length; i++) {
            while (top >= 0) {
                if (T[i] > T[stack[top]]) {
                    map[stack[top]] =  i - stack[top];
                    top--;
                } else {
                    break;
                }
            }
            stack[++top] = i;
        }
        return map;
    }
}
