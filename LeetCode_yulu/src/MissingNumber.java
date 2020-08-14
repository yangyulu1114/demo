public class MissingNumber {
    public int missingNumber(int[] nums) {
        int[] indexs = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            indexs[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            indexs[nums[i]] = i;
        }
        for (int i = 0; i < indexs.length; i++) {
            if (indexs[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {
        int number = 0;

        for (int i = 0; i < nums.length; i++) {
            number ^= nums[i];
            number ^= i;
        }
        return number ^= nums.length;
    }

    public void test() {
        int[] input = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber2(input));
    }
}
