public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int reversedNumber = getReverse(x);

        return reversedNumber == x;
    }

    public int getReverse(int x) {
        int newnumber = 0;

        while (x != 0) {
            newnumber = newnumber *10 + x%10;
            x /= 10;
        }

        return newnumber;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || ( x > 0 && x %10 == 0)) {
            return false;
        }

        int reversedNumber = 0;

        while (x != 0 && reversedNumber < x) {
            reversedNumber = reversedNumber *10 + x%10;
            x /= 10;
        }

        return reversedNumber == x || reversedNumber/10 == x;
    }

    public void test() {
        System.out.println(isPalindrome2(10));
    }
}
