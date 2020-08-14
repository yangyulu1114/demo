import java.util.PriorityQueue;

public class UglyNumberII {
    //HEAP
    public int nthUglyNumber(int n) {
        long count = 0, ans = 0;  //要注意当n 很大时，ans * 5可能会溢出，导致出现负的数影响排序，所以用Long
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.offer(1l);
        while (count < n) {
            ans = queue.poll();
            if (!queue.contains(ans * 2)) {
                queue.offer(ans * 2);
            }
            if (!queue.contains(ans * 3)) {
                queue.offer(ans * 3);
            }
            if (!queue.contains(ans * 5)) {
                queue.offer(ans * 5);
            }
            count++;
        }
        return (int)ans;
    }

    //动态规划，始终都是以可以满足条件的最小值来乘以2，3，或者5来进行比较
    public int nthUglyNumber2(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < n; i++) {
            nums[i] = Math.min(nums[t2] * 2, Math.min(nums[t3] * 3, nums[t5] * 5));
            if (nums[i] >= nums[t2] * 2) {
                t2++;
            }
            if (nums[i] >= nums[t3] * 3) {
                t3++;
            }
            if (nums[i] >= nums[t5] * 5) {
                t5++;
            }
        }
        return nums[n - 1];
    }

}
