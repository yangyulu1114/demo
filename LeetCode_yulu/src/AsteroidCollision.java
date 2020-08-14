import java.util.Stack;

public class AsteroidCollision {
    //多做几遍
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
//        stack.push(asteroids[0]);
        for(int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
                continue;
            }
            int collide = asteroids[i];
            while (!stack.isEmpty()) {
                int top = stack.pop();
                if (top <= 0 || (top >= 0 && collide >= 0)) {
                    stack.push(top);
                    stack.push(collide);
                    break;
                }
                if (Math.abs(top) == Math.abs(collide)) {
                    break;
                } else if (Math.abs(top) < Math.abs(collide)) {
                    if (stack.isEmpty()) {
                        stack.push(collide);
                        break;
                    }
                    continue;
                } else {
                    stack.push(top);
                    break;
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; result[i] = stack.pop(), i--);
        return result;
    }

    public int[] asteroidCollision2(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int index = -1;
        for(int i = 0; i < asteroids.length; i++) {
            if (index == -1) {
                stack[++index] = asteroids[i];
                continue;
            }
            int collide = asteroids[i];
            while (index >= 0) {
                int top = stack[index--];
                if (top <= 0 || (top >= 0 && collide >= 0)) {
                    stack[++index] = top;
                    stack[++index] = collide;
                    break;
                }
                if (Math.abs(top) == Math.abs(collide)) {
                    break;
                } else if (Math.abs(top) < Math.abs(collide)) {
                    if (index == -1) {
                        stack[++index] = collide;
                        break;
                    }
                    continue;
                } else {
                    stack[++index] = top;
                    break;
                }
            }
        }
        int[] result = new int[index + 1];
        for (int i = index; i >= 0; result[i] = stack[i], i--);
        return result;
    }

    public void test() {
        int[] input = new int[] {5, 10, -5};
        int[] result = asteroidCollision(input);
        for(int n : result) {
            System.out.println(n);
        }
    }
}
