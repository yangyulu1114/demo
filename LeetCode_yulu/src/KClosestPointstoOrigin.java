import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
//重点，多做几次
public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        HashMap<Double, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            Double distance = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            List<Integer> index = map.getOrDefault(distance, new ArrayList<>());
            index.add(i);
            map.put(distance, index);
        }
        List<Map.Entry<Double, List<Integer>>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByKey(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1 < o2 ? -1 : 1;
            }
        }));
        int[][] ans = new int[K][2];
        int index = 0;
        for (Map.Entry<Double, List<Integer>> entry : list) {
            List<Integer> s = entry.getValue();
            for (int n : s) {
                ans[index][0] = points[n][0];
                ans[index][1] = points[n][1];
                index++;
            }
            if (index == ans.length) {
                break;
            }
        }
        return ans;
    }
//这个方法和上面的一样都是用排序的方法，排序法根本没必要用map，直接数组排序就可以
    public int[][] kClosest2(int[][] points, int K) {
        int N = points.length;
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = distance(points[i]);
        }
        Arrays.sort(dist);
        int distK = dist[K - 1];
        int[][] ans = new int[K][2];
        for (int i = 0, index = 0; index < K && i < N; i++){
            if (distance(points[i]) <= distK) {
                ans[index][0] = points[i][0];
                ans[index][1] = points[i][1];
                index++;
            }
        }
        return ans;
    }
//DIVIDE AND CONQUER
    public int[][] kClosest3(int[][] points, int K) {
        sort(points, 0, points.length - 1, K); //只用部分排序，分成两个Bucket，左边的bucker一定小于右边的bucket，而bucket内部不用排序
        return Arrays.copyOfRange(points, 0, K );
    }

    public void sort(int[][] points, int i, int j, int K) {
        if (i >= j) {
            return;
        }
        int k = ThreadLocalRandom.current().nextInt(i, j); // 生成随机数，如果不使用随机数，而用第一个数，那在本来就是排好序的数组中时间复杂度会很大
        swap(points, i, k);//保证是以这个随机数来进行桶的分割
        int mid = partition(points, i, j);
        int len = mid - i + 1;
        if (len < K) {
            sort(points, mid + 1, j, K - len);  //如果左边的桶比较大，这继续分割左边的桶，如果左边的桶小，继续分割右边的桶，但是K的大小会变
        } else if (len > K) {
            sort(points, i, mid - 1, K);
        }
    }

    public int partition(int[][] points, int i, int j) {  //快排的思路
        int oi = i;
        int pivotal = dist(i, points);
        i++;

        while (true) {
            while (i < j && dist(i, points) < pivotal) {
                i++;
            }
            while (i <= j && dist(j, points) > pivotal) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(points, i, j);
        }
        swap(points, oi, j);
        return j;
    }

    public void swap(int[][] points, int i, int j) {
        int tempX = points[i][0], tempY = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = tempX;
        points[j][1] = tempY;
    }
    public int dist(int i, int[][] points) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

    public int distance(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }

    public void test() {
        int[][] points = new int[][]{{1,3}, {-2, 2}};
        int[][] ans = kClosest3(points, 1);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i][0]);
            System.out.print(" ");
            System.out.println(ans[i][1]);
        }
    }

}
