public class ReverseInteger {

    public int reverse(int x) {
        int newnumber = 0;

        while (x != 0) {

            newnumber = (newnumber > (Integer.MAX_VALUE / 10)) || newnumber < (Integer.MIN_VALUE / 10) ? 0 : newnumber * 10 + x % 10;
            x /= 10;
        }
        return newnumber;
    }

    public int reverse2(int x) {
        int newnumber = 0;

        while (x != 0) {

            if (newnumber > Integer.MAX_VALUE / 10 || newnumber < Integer.MIN_VALUE / 10) {
                return 0;
            } else {
                newnumber = newnumber * 10 + x % 10;
                x /= 10;
            }
        }
        return newnumber;
    }

    public int reverse3(int x) {
        long newnumber = 0;

        while (x != 0) {

            newnumber = newnumber * 10 + x % 10;
            x /= 10;
        }

        return newnumber >= Integer.MIN_VALUE && newnumber <= Integer.MAX_VALUE ? (int) newnumber : 0;
    }

    public void test() {
        System.out.println(reverse2(120));
        System.out.println(Integer.MAX_VALUE);
    }
}
