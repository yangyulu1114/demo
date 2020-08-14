import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
//    第一种方法是先建一个map,nums1里面的每一个数先通过map找到在nums2的位置，在从当前位置的后面去找最近的大于这个数的数
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums2.length; map.put(nums2[index], index), index++);
        for (int i = 0; i < nums1.length; i++) {
            int j = map.get(nums1[i]);
            for (; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
            if (j >= nums2.length) {
                result[i] = -1;
            }
        }
        return result;
    }
//方法二是借助栈找到nums2中的每一个数的next greater number，然后存到map中，然后nums1中的每个数再通过map找到对应的值
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int num : nums2) {
            while (!stack.isEmpty()) {
                if (num > stack.peek()) {
                    map.put(stack.pop(), num);
                } else {
                    break;
                }
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public void test() {
        int[] nums1 = new int[]{2,4};
        int[] nums2 = new int[]{1,2,3,4};
        int[] result = nextGreaterElement(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
