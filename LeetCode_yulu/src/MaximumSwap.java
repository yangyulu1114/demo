public class MaximumSwap {
    //edge case 1993
    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i] - '0', index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    if ((nums[j] - '0')  >= max) {  //这里要注意是>=，因为后面如果出现了一样的比i大的数，要把在后面的和i交换，这样才能保证最大值，例如1993的case,最大结果是9913，而不是9193
                        max = nums[j] - '0';
                        index = j;
                    }
                }
            }
            if (index != i) {
                char temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        return Integer.valueOf(new String(nums));
    }

    //时间复杂度O(N)
    public int maximumSwap2(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < nums.length; i++) {
            last[nums[i] - '0'] = i;   //记住每个数出现在最右边的位置，因为一会换的时候最好是换最大的数出现在最右边的位置
        }
        for (int i = 0; i < nums.length; i++) {
            for (int digit = 9; digit > nums[i] - '0'; digit--) {
                if (last[digit] > i) {   //从9开始，依次往下找，看有没有出现比第i个单元格更大的数，没有的话last[d]会等于0,如果有，看是不是在i的右边，如果是，交换就能得到最佳答案
                    char temp = nums[i];
                    nums[i] = nums[last[digit]];
                    nums[last[digit]] = temp;
                    return Integer.valueOf(new String(nums));
                }
            }
        }
        return num;
    }

    public void test() {
        System.out.println(maximumSwap2(2736));
    }
}
