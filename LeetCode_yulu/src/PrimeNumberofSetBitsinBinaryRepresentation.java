import java.util.HashSet;

public class PrimeNumberofSetBitsinBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        int[] prime = new int[]{2,3,5,7,11,13,17,19,23,29,31};
        HashSet<Integer> set = new HashSet<>();
        for (int n : prime) {
            set.add(n);
        }
        for (int i = L; i <= R; i++) {
            int count = 0, num = i;
            while (num != 0) {
                count++;
                num &= (num - 1);
            }
            if (set.contains(count)) {
                ans++;
            }
        }
        return ans;
    }

    public int countPrimeSetBits2(int L, int R) {
        int ans = 0;
        for (int x = L; x <= R; x++) {
            if (isPrime(Integer.bitCount(x))) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isPrime(int x) {
        return x == 2 || x == 3 || x == 5 || x == 7 || x == 11 || x == 13 || x == 17 || x == 19;
    }
}
