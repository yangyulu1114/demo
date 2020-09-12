public class Heaters {
//    public int findRadius(int[] houses, int[] heaters) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < heaters.length; i++) {
//            set.add(heaters[i]);
//        }
//        Arrays.sort(houses);
//        int max_distance = 0, distance = 0, fisrtdistance = 0;
//        boolean flag = false;
//        for (int i = 0; i < houses.length; i++) {
//            distance += i > 0 ? houses[i] - houses[i - 1] : 0;
//            if (flag == false) {
//                fisrtdistance = distance;
//            }
//            if (set.contains(houses[i])) {
//                max_distance = Math.max(max_distance, distance);
//                distance = 0;
//                flag = true;
//            }
//        }
//        distance = Math.max(distance, fisrtdistance);
//        max_distance = Math.max(max_distance / 2, distance);
//        return max_distance;
//    }

//    public int findRadius(int[] houses, int[] heaters) {
//        if (houses.length == 0) {
//            return 0;
//        }
//        Arrays.sort(houses);
//        Arrays.sort(heaters);
//
//        int max_distance = 0, last_heater_position = houses[0], distance = -1, len = houses.length, j = 0;
//        if (heaters.length > 0 && heaters[0] > houses[len - 1]) {
//            return heaters[0] - houses[0];
//        }
//        for (int i = 0; i < len; i++) {
//            max_distance = Math.max(houses[i] - last_heater_position, max_distance);
//            if (i > 0 && j < heaters.length && heaters[j] >= houses[i - 1] && heaters[j] <= houses[i]) {
//                if (distance == -1) {
//                    distance = heaters[j] - last_heater_position;
//                }
//                last_heater_position = heaters[j];
//                j++;
//            }
//        }
//        int last_distance = houses[len - 1] - last_heater_position;
//        if (j < heaters.length) {
//            last_distance = Math.min((heaters[j] - last_heater_position)/2, last_distance);
//        }
//        distance = Math.max(distance, last_distance);
//        max_distance = Math.max(max_distance / 2, distance);
//        return max_distance;
//    }

//    public void test() {
//        int[] houses = new int[]{1, 2, 3, 5, 15};
//        int[] heaters = new int[]{2, 30};
//
//        System.out.println(findRadius(houses, heaters));
//    }
}
