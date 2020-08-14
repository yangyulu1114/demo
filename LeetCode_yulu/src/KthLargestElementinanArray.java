import java.util.Arrays;
import java.util.PriorityQueue;
//文田写的第一种可以再看一下,看一下快排的方法
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLarges2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            queue.offer(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public void test() {
        int[] input = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(input, 4));

    }
}
