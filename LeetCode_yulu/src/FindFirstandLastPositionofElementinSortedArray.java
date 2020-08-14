public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        for (int start = 0, end = nums.length - 1; start <= end; ) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                int first = mid - 1, last = mid + 1;
                for (; first >= 0 && nums[first] == nums[first + 1]; first--) ;
                ans[0] = first + 1;
                for (; last < nums.length && nums[last] == nums[last - 1]; last++) ;
                ans[1] = last - 1;
                return ans;
            }
        }
        return ans;
    }
}
