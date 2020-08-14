public class MinimumFlipstoMakeaORbEqualtoc {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a != 0 || b != 0 || c != 0) {
            int c1 = c & 1;
            int a1 = a & 1;
            int b1 = b & 1;
            if ((a1 | b1) != c1) {
                if (c1 == 1) {
                    count++;
                } else {
                    count += a1 == 1 ? 1 : 0;
                    count += b1 == 1 ? 1: 0;
                }
            }
            a >>>= 1;
            b >>>= 1;
            c >>>= 1;
        }
        return count;
    }
    public void test() {
        System.out.println(minFlips(1, 2, 3));
    }
}
