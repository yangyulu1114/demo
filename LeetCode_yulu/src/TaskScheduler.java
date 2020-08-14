import java.util.*;

public class TaskScheduler {
    //排序法，时间复杂度O(time)
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0) {   //这个if分支不能少，因为最后即使没有达到冷静期，但是所有任务都已经执行完了，循环也不应该继续了
                    break;
                }
                if (i <= 25 && map[25 - i] > 0) {
                    map[25 - i]--;
                }
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }
//用PriorityQuene来实现排序
    public int leastInterval2(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {  //注意这种方法要降序排，因为先取的都是任务量最多的任务
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : map) {
            if (num > 0) {
                queue.add(num);
            }
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (temp.isEmpty() && queue.isEmpty()) {
                    break;
                }
                if (!queue.isEmpty()) {
                    int num = queue.poll();
                    if (num > 1) {
                        temp.add(num - 1);
                    }
                }
                i++;
                time++;
            }
            for (int num : temp) {
                queue.add(num);
            }
        }
        return time;
    }

    //这种方法就是利用公式 总时间 = 任务执行时间  + 空闲时间
    public int leastInterval3(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int max = map[25] - 1, idleslot = max  * n;  //最大空闲时间
        for (int  i = 24; i >= 0 && idleslot > 0 && map[i] > 0; i--) {
            idleslot -= Math.min(map[i], max);
        }
        return idleslot > 0 ? tasks.length + idleslot : tasks.length;
    }     //这里要注意判断条件，因为idleslot可能会为负
}
