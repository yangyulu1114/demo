import java.util.Arrays;

public class NextGreaterElementIII {
    //edge case:230241 正确答案为230412   12443322的正确答案为13222344  时间复杂度nlogn
    public int nextGreaterElement(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int nextgreat_index = i, next_greater = nums[i];   //这里需要注意，一旦需要替换，要用比这个位置大的最小值替换
                for (int index = i; index < nums.length; index++) {
                    if (nums[index] > nums[i - 1] && nums[index] < next_greater) {
                        next_greater = nums[index];
                        nextgreat_index = index;
                    }
                }
                char temp = nums[nextgreat_index];
                nums[nextgreat_index] = nums[i - 1];
                nums[i - 1] = temp;
                Arrays.sort(nums, i , nums.length);  //排序是为了保证是最小值，sunbstring， sort,subList 都是左闭右开，不清楚的可以看注释
                long result = Long.valueOf(new String(nums)); //注意字符数组转字符串的方式
                if (result > Integer.MAX_VALUE) {
                    return - 1;
                }else {
                    return (int)result;
                }
            }
        }
        return -1;
    }

    //方法2就是把方法1嵌套的循环单独拎出来，显得逻辑比较简单
    public int nextGreaterElement2(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        int i = nums.length - 1;
        for (; i > 0 && nums[i] <= nums[i - 1]; i--);

        if (i <= 0){
            return -1;
        }

        int nextgreat_index = i, next_greater = nums[i];
        for (int index = i; index < nums.length; index++) {
            if (nums[index] > nums[i - 1] && nums[index] < next_greater) {
                next_greater = nums[index];
                nextgreat_index = index;
            }
        }
        char temp = nums[nextgreat_index];
        nums[nextgreat_index] = nums[i - 1];
        nums[i - 1] = temp;

        Arrays.sort(nums, i , nums.length);
        long result = Long.valueOf(new String(nums));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }


    public void test() {
        System.out.println(nextGreaterElement2(21));
    }
}
