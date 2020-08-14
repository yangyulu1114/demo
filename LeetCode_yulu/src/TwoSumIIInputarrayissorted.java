public class TwoSumIIInputarrayissorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        for (int i = 0, j = numbers.length - 1; i < j;) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                index[0] = i + 1;
                index[1] = j + 1;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return  index;
    }
}
