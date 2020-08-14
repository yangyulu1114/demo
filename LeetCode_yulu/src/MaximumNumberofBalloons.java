public class MaximumNumberofBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[5];
        for (Character c : text.toCharArray()) {
            switch (c) {
                case 'a':
                    count[0]++;
                    break;
                case 'b':
                    count[1]++;
                    break;
                case 'l':
                    count[2]++;
                    break;
                case 'n':
                    count[3]++;
                    break;
                case 'o':
                    count[4]++;
                    break;
            }
        }
        count[2] /= 2;
        count[4] /= 2;
        int max = Integer.MAX_VALUE;
        for (int n : count) {
            max = Math.min(max, n);
        }
        return max;
    }
    public int maxNumberOfBalloons2(String text) {
        int[] chars = new int[26]; //count all letters
        for (char c : text.toCharArray()) {
            chars[c - 'a']++;
        }
        int min = chars[1];//for b
        min = Math.min(min, chars[0]);//for a
        min = Math.min(min, chars[11] / 2);// for l /2
        min = Math.min(min, chars[14] / 2);//similarly for o/2
        min = Math.min(min, chars[13]);//for n
        return min;
    }

}
