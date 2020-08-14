public class RepeatedStringMatch {
//    public int repeatedStringMatch(String A, String B) {
//        StringBuilder sb = new StringBuilder();
//        int count = 0;
//        for (; sb.length() <= 2 * B.length() || count < 2; sb.append(A), count++) {  //这种方法存在的问题，长度乘以2的话，如果A很小，B很大，可能会超时，
//                                                                      如果长度不乘以2，会出现循环的过程中没超过长度，但是还没有包含B，但是马上append之后就包含了或者要超过之后再append一次就超过了
//                                                                      ，但这时长度已经超过了，所以循环退出了
//            if (sb.indexOf(B) >= 0) {
//                return count;
//            }
//        }
//        return sb.indexOf(B) >= 0 ? count : -1;
//    }
//这种题一定要注意写法
    //首先必须A的长度至少等于B才可以，如果长度达到后还不可以，可以再append一次，还不行那就是无法实现了
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (; sb.length() < B.length(); sb.append(A), count++);
        if (sb.indexOf(B) != -1) {
            return count;
        }
        sb.append(A);
        count++;
        if (sb.indexOf(B) != -1) {
            return count;
        }
        return -1;
    }

    //第二种方法再看一下

    public void test() {
        System.out.println(repeatedStringMatch("abcabcabcabc", "abac"));
    }

}
