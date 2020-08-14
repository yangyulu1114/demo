public class RotateArray {
    public void rotate2(int[] nums, int k) {
        //K需要对数组长度取余，因为当K=数组长度+1时和位移1位是等价的
        k = k % nums.length;
        int index = 0, temp = nums[index];

        for (int i = 0; i < nums.length; i++) {
//
            if (nums.length % k == 0 && i % k == 0) {
                index++;
                temp = nums[index % nums.length];
            }
            int c = (index + k >= nums.length) ? (index + k) % nums.length : index + k;
            int a = nums[c];
//
            nums[c] = temp;
            index = c;
//            temp = a;
        }
    }

    public void rotate1(int[] nums, int k) {
        //K需要对数组长度取余，因为当K=数组长度+1时和位移1位是等价的
        k = k % nums.length;

        for (int count = 0, start = 0; count < nums.length; start++) {
//陷入重复循环那start+1肯定是没走到过的
            int current = start;
            int pre = nums[start];
            do {
                //要避免越界
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                current = next;
                count++;
//count++ 不能忘，只能替换nums.length 次
            } while (start != current);  //要避免陷入无效的重复循环路线
        }
    }

//    旋转一个数组获字符串可以先内部部分颠倒，然后再整体颠倒
    public void rotate(int[] nums, int k) {
//        K需要对数组长度取余，因为当K=数组长度+1时和位移1位是等价的
        k %= nums.length;
  //位移几位后面就有几位被挤出去，挤出去的部分形成一个部分整体颠倒
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        for (; start < end; start++, end--) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
        }
    }

    public void test() {
        int[] input = new int[] {-1,-100,3,99};
        rotate(input, 2);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
}
