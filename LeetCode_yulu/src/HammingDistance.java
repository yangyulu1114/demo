public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int c = x ^ y, count = 0;
        while (c != 0) {
            count += ((c & 1) != 0) ? 1 : 0;
            c >>>= 1;
        }
        return count;
    }

    public void test() {
        System.out.println(hammingDistance(1, 4));
    }
}
