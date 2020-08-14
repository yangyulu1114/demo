public class RotatedDigits {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        return count;
    }
    public boolean isValid(int n) {
        int count = 0;
        while (n != 0) {
            int remainder = n % 10;
            if (remainder == 3 || remainder == 4 || remainder == 7) {
                return false;
            }
            if (remainder == 2 || remainder == 5 || remainder == 6 || remainder == 9) {
                count++;
            }
            n /= 10;
        }
        return count > 0;
    }
//深度遍历
    public int rotatedDigits2(int N) {
        int dp[] = new int[N + 1];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) {
                    dp[i] = 1;
                } else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = i / 10, b = i % 10;
                if (dp[a] == 0 || dp[b] == 0) {
                    continue;
                }
                if (dp[a] == 1 && dp[b] == 1) {
                    dp[i] = 1;
                } else {
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }

    public void test() {
    }
}
