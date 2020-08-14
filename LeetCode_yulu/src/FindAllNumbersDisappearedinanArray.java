import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//注意edge case： [], [1,1,1,1] [4, 4, 4, 4], [1, 2, 2, 4]

public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length;) {
            if (nums[i] == i || nums[i] == nums.length || nums[nums[i]] == nums[i]) {
                i++;
            }else {
                int index = nums[i];
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
        }
        List<Integer> list = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] != i) {
                list.add(i);
            }
            if (nums[i] == nums.length) {
                flag = true;
            }
        }
        if (flag == false && nums.length > 0) {
            list.add(nums.length);
        }
        return list;
    }

//    可以把出现过的数标记为负数，而不改变绝对值，因为负数本身是不包含在数组中的，这样就可以省掉替换操作,剩下来的正的数就是没出现过的
    public class FindAllNumbersDisappearedinanArray2 {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1; // 减一是因为第n个数的索引是n - 1
                if (nums[index] > 0) {   //当出现几次时，第一次出现已经标为负了，第二遍就不用再标了
                    nums[index] = -nums[index];
                }
            }
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    list.add(i + 1);
                }
            }
            return list;
        }
    }
        public void test() {
        List<Integer> list = new ArrayList<>();
        int[] input = new int[]{1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < input.length; i++) {
            list.add(input[i]);
        }
        list.remove(4);
        System.out.println(list.get(4));
    }
}
