import java.util.HashSet;

public class HappyNumber {


    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        int sum = n;

        while (!set.contains(sum)) {
            set.add(sum);
            sum = sumdigits(sum);
        }

        if (sum == 1) {
            return true;
        } else {
            return false;
        }

    }


    public boolean isHappy2(int n) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        int sum = n;

//add 函数返回false表示添加失败，已存在
        while (set.add(sum)) {
            sum = sumdigits(sum);
        }

        return sum == 1;

    }

    // 根据题目可知必定会形成一个环，而这个环可能包含1（含1就是1一直循环下去），可能不含1，如果含1，那肯定是快的先走到1，如果没有1，那快的肯定能追上慢的
    public boolean isHappy3(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }


    public int sumdigits(int number) {

        int sum = 0;
        while (number != 0) {
            int tempt = number%10;
            sum += tempt * tempt;
            number = number/10;
        }

        return sum;
    }

    public void test() {
        int n = 19;

        System.out.println(isHappy3(n));
    }
}
