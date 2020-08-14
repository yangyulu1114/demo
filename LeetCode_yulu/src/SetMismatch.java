public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        //注意result的顺序
        int[] map = new int[nums.length + 1], result = new int[2];
        for (int i = 0; i < nums.length; map[nums[i]]++, i++);
        for (int i = 1, index = 0; i < map.length && index < 2; i++) {
            if (map[i] == 2) {
                result[0] = i;
                index++;
            }
            if (map[i] == 0) {
                result[1] = i;
                index++;
            }
        }
        return result;
    }
}
