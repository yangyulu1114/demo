public class ConstructtheRectangle {
    public int[] constructRectangle(int area) {
        int L = (int) Math.sqrt(area), W = L;
        while (L * W != area) {
            if (L * W > area) {
                W--;
            }
            if (L * W < area) {
                L++;
            }
        }
        return new int[]{L, W};
    }

    //第二种方法相比第一种方法，循环会大大减少，因为从平方根开始，不需要遍历每一个数，只需要遍历左侧的一遍，发现能整除时，另一个数通过除法就可以算出来，而且因为是从大往
    //小变化宽度的，所以能保证两者的差是最小的。比如are=5，用方法1需要循环5次，而方法2循环2次即可求出答案
    public int[] constructRectangle2(int area) {
        int[] result = new int[]{1,1};
        for (int i = (int) Math.sqrt(area); i > 0; i--) {
            if (area % i == 0) {
                result[0] = area / i;
                result[1] = i;
                return result;
            }
        }
        return result;
    }

    public void test() {
        int[] result = constructRectangle2(4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
