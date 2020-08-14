public class LicenseKeyFormatting {
    //要注意edge case, S中只有-,或者类似于--a-a-a-a, 2这种情况
    public String licenseKeyFormatting(String S, int K) {
       S = S.toUpperCase();
       StringBuilder sb = new StringBuilder();
       for (int i = S.length() - 1, count = 0; i >= 0; i--) {
           char c = S.charAt(i);
           if (c == '-') {
               continue;
           }
           sb.append(c);
           count++;
           if (count == K) {
               sb.append('-');
               count = 0;
           }
       }
       sb.reverse();
       if (sb.length() > 0 && sb.charAt(0) == '-') {
           sb.deleteCharAt(0);
       }
       return sb.toString();
    }

    public void test() {
        System.out.println(licenseKeyFormatting("--a-a-a-a", 2));
    }
}
