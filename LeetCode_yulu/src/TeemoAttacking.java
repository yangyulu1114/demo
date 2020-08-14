public class TeemoAttacking {
    //edge case:数组为空，duration不为0
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length, sum = 0; //len提前保存下来，这样循环时不用每次调用函数，会快一些
        if (len == 0) {
            return 0;
        }
        for (int i = 0; i < len - 1; i++) {
            if (timeSeries[i] + duration <= timeSeries[i + 1]) {
                sum += duration;
            } else {
                sum += (timeSeries[i + 1] - timeSeries[i]);
            }
        }
        return sum + duration;
    }
}
