public class onebitandtwobitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int start = 0;
        for (int i = 0; i < bits.length; i++) {
            if (i - start > 1) {
                start = i;
                continue;
            }
            if (i > 0 && bits[i - 1] == 0) {
                start = i;
            }
        }
        return start == bits.length - 1;
    }

    public void test() {
        int[] bits = new int[]{1,1,1,0};
        System.out.println(isOneBitCharacter(bits));
    }
}
