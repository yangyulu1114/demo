import java.util.Arrays;

public class JumpGame {
    //BACKTRACKING时间复杂度是2的n次方，超时了，
    public boolean canJump(int[] nums) {
        return canJumpFromPosition(nums, 0);
    }

    public boolean canJumpFromPosition(int[] nums, int position) {
        if (position == nums.length - 1) {
            return true;
        }
        int furtherPosition = Math.min(position + nums[position], nums.length - 1);
        for (; furtherPosition > position; furtherPosition--) {
            if (canJumpFromPosition(nums, furtherPosition)) {
                return true;
            }
        }
        return false;
    }

    enum Index {
        GOOD, BAD, UNKNOWN
    }

    public boolean canJump2(int[] nums) {
        Index[] status = new Index[nums.length];
        Arrays.fill(status, Index.UNKNOWN);
        status[nums.length - 1] = Index.GOOD;
        return canJumpFromPosition(nums, 0, status);
    }

    //TOP-DOWN动态规划，用memeo保存状态，可以减少BACKTRACKING的次数如果已经futherPosition是可以的，就不用继续下去递归了，因为下一步可以，而这一步又可以跳到下一步，那肯定就可以
    public boolean canJumpFromPosition(int[] nums, int position, Index[] status) {
        if (status[position] != Index.UNKNOWN) {
            return status[position] == Index.GOOD;
        }

        int furtherPosition = Math.min(position + nums[position], nums.length - 1);
        for (; furtherPosition > position; furtherPosition--) {
            if (canJumpFromPosition(nums, furtherPosition, status)) {
                status[position] = Index.GOOD;
                return true;
            }
        }
        status[position] = Index.BAD;
        return false;
    }
    //BOTTOM-DOWN的动态规划，从后面往前面算status,这样可以省掉一些不必要的递归，最后只要status【0】是GOOD就可以
    public boolean canJump3(int[] nums) {
        Index[] status = new Index[nums.length];
        Arrays.fill(status, Index.UNKNOWN);
        status[nums.length - 1] = Index.GOOD;

        for(int current = nums.length - 2; current >= 0; current--) {
            int furtherPosition = Math.min(current + nums[current], nums.length - 1);
            for (; furtherPosition > current; furtherPosition--) {
                if (status[furtherPosition] == Index.GOOD) {
                    status[current] = Index.GOOD;
                    break;
                }
                if (furtherPosition == current) {
                    status[current] = Index.BAD;
                }
            }
        }
        return status[0] == Index.GOOD;
    }

    //贪心法，这个方法是有上面的方法3优化来的，从右往左遍历，其实就是看每一个nums[i]能不能跳过已经算过的最左边的GOOD位置，
//    如果能，那当前的位置就是新的最左边的GOOD,最后就是看最左边的GOOD位置是不是0
    public boolean canJump4(int[] nums) {
        int leftmost = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= leftmost) {
                leftmost = i;
            }
        }
        return leftmost == 0;
    }
}
