public class GuessNumberHigherorLower {
    public int guessNumber(int n) {
        long i = 1, j = n;

        while (i <= j) {
            long mid = (i + j) / 2;
            // int result = guess((int)mid);
            switch(guess((int)mid)) {
                case 0:
                    return (int)mid;
                case -1:
                    j = mid -1;
                    break;
                case 1:
                    i = mid + 1;
                    break;
            }
        }
        return (int)i;
    }

    int guess (int num) {
        return 0;
    }
}
