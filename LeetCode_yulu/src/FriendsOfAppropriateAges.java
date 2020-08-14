public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        int count = 0;
        for (int i = 0; i < ages.length; i++) {
            int min = ages[i] / 2 + 7;
            int max = ages[i];
            count += countNums(ages, min, max, i);
        }
        return count;
    }

    public int countNums(int[] ages, int min, int max, int index) {
        int count = 0;
        for (int i = 0; i < ages.length; i++) {
            if (i != index && ages[i] > min && ages[i] <= max) {
                count++;
            }
        }
        return count;
    }

    //因为此题ages的范围要远小于人数，所以可以通过统计数量将循环转变为ages的循环遍历而不是人数

    public int numFriendRequests2(int[] ages) {
        int[] count = new int[121];
        for (int n : ages) {
            count[n]++;
        }
        int ans = 0;
        for (int i = 1; i <= 120; i++) {
            if (count[i] == 0) {
                continue;
            }
            for (int j = 1; j<= 120; j++) {
                if ((count[j] == 0) || (j <= i / 2 + 7) || (j > i) || (j > 100 && i < 100)) {
                    continue;
                }
                ans += count[j] * count[i]; //当A年龄的人数有m个，B年龄的人数有n个，AB满足配对要求，那总共会有m * n的请求
                if (i == j) {
                    ans -= count[j];  //当A == B是要注意，因为自己不能想自己发请求，所以请求数为m * (m - 1)，上面因为加了m * m次，所以这种情况还得减掉m
                }
            }
        }
        return ans;
    }

    public void test() {
        int[] ages = new int[]{20,30,100,110,120};
        System.out.println(numFriendRequests2(ages));
    }

}

