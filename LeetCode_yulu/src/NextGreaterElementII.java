import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementII {
    //考虑时间复杂度应该用最坏的情况考虑
    public int[] nextGreaterElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        //两倍可以保证每一个数的greater number都能遍历到
        for (int i = 0 ; i < 2 * nums.length; i++) {
            int num = nums[i % nums.length];
            while (!stack.empty()){
                if (num > nums[stack.peek()]) {
                    map.put(stack.pop(), num);
                } else {
                    break;
                }
            }
            stack.push(i % nums.length);  //注意，因为这一题和I那道题不同，这一题是可以有重复值的，所以map里的key 不能是nums[i],而必须是
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.getOrDefault(i,-1);
        }
        return nums;
    }

    //方法四相对于方法1是用数组来模拟栈，因为栈可能会有一些额外的操作
    public int[] nextGreaterElements4(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] stack = new int[nums.length * 2]; //栈的大小最坏情况是nums.lenght * 2
        int top = -1;
        for (int i = 0 ; i < 2 * nums.length; i++) {
            int num = nums[i % nums.length];
            while (top >= 0){
                if (num > nums[stack[top]]) {
                    map.put(stack[top--], num);
                } else {
                    break;
                }
            }
            stack[++top] = i % nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.getOrDefault(i,-1);
        }
        return nums;
    }

    //方案5相对于方案4的改进就是用数组模拟了map，数组的index 就相当于map的key。
    //能用基本类型操作的就用基本类型，Java的一些类会有额外的操作
    public int[] nextGreaterElements5(int[] nums) {
        int[] map = new int[nums.length], stack = new int[nums.length * 2];//栈的大小最坏情况是nums.lenght * 2
        int top = -1;
        for (int i = 0 ; i < 2 * nums.length; i++) {
            if (i < nums.length) {
                map[i] = -1;  //map 里的元素默认情况为-1
            }
            int num = nums[i % nums.length];
            while (top >= 0){
                if (num > nums[stack[top]]) {
                    map[stack[top--]] = num;
                } else {
                    break;
                }
            }
            stack[++top] = i % nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map[i];
        }
        return nums;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            for (; j < 2 * nums.length; j ++) {
                if (nums[j % nums.length] > nums[i]) {
                    result[i] = nums[j % nums.length];
                    break;
                }
            }
            if (j >= 2 * nums.length) {
                result[i] = -1;
            }
        }
        return result;
    }
// 3是2的一种改进，不用每个元素都遍历2*length,每个元素遍历一个length就可以了，只要保证初自己本身的每个元素都遍历了就OK
    public int[] nextGreaterElements3(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
            for (int j = 0; j < nums.length; j ++) {
                if (nums[(i + j) % nums.length] > nums[i]) {
                    result[i] = nums[(i + j) % nums.length];
                    break;
                }
            }
        }
        return result;
    }

    public void test() {
        int[] input = new int[]{1,2,1};
        int[] result = nextGreaterElements5(input);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
