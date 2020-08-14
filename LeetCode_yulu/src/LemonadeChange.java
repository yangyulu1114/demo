public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int countFive = 0, countTen = 0, money = 0;
        for (int n : bills) {
            if (money < n - 5) {
                return false;
            }
            if (n == 5) {
                countFive += 1;
            } else if (n == 10) {
                countFive--;
                countTen++;
            } else {
                if (countTen > 0) {
                    countTen--;
                    countFive--;
                } else {
                    countFive -= 3;
                }
            }
            if (countFive < 0) {
                return false;
            }
            money += 5;
        }
        return true;
    }

    public void test() {

    }
}
