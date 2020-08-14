public class TotalHammingDistance {
    //这种方法可能会超时
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {   //注意这里j是从i的后一位开始，而不是从1开始
                count += hammingDistance(nums[i], nums[j]);
            }
        }
        return count;
    }
    public int hammingDistance(int x, int y) {
        int c = x ^ y, count = 0;
        while (c != 0) {
            count += ((c & 1) != 0) ? 1 : 0;
            c >>>= 1;
        }
        return count;
    }

    //这种方法就是要比较每一个数的每一个bit位

    public int totalHammingDistance2(int[] nums) {
        int count = 0, len = nums.length;

        for (int i = 1; i <= 32; i++) {
            int a = 0;
            for (int j = 0; j < len; j++) {
                a += (nums[j] & 1);
                nums[j] >>>= 1;   //这里要注意每次移一位就会改变数组的值，i循环32次，就会移位32次
            }
            count += a * (len - a);  //如果有a个1,那不同的是总的-相同的 = (len * (len - 1) )/2 - (a * (a - 1) / 2) - ((lem - n) * (len - n - 1))/2 = a (len -a)
        }
        return count;
    }

    public void test() {
        int[] nums = new int[]{4,14,2};
        System.out.println(totalHammingDistance2(nums));
    }
}
