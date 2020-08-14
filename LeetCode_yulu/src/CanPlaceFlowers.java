public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            if (i == 0 || i == len - 1) {
                if (len == 1 || (i < len - 1 && (flowerbed[i + 1] == 0) || (i > 0 && flowerbed[i - 1] == 0))) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = i;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}
