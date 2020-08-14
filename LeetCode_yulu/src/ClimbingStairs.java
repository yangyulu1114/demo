public class ClimbingStairs {
    public int climbStairs(int n) {
        int pre1 = 1, pre2 = 0, steps = 0;
        for (int i = 1; i <= n; i++) {
            steps = pre1 + pre2;
            pre2 = pre1;
            pre1 = steps;
        }
        return steps;
    }

    public void test() {
        System.out.println(climbStairs(4));
    }
}
