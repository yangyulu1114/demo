public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }
        return letters[0];
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        int len = letters.length;
        if (letters[len] < target) {
            return letters[0];
        }
        int lo = 0, hi = len - 1;
        while (lo < hi) {
            int middle = (lo + hi) / 2;
            if (letters[middle] <= target) {
                lo = middle + 1;
            } else {
                hi = middle;
            }
        }
        return letters[hi];
    }
}
