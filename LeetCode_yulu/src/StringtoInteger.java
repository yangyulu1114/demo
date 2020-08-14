public class StringtoInteger {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty() || (str.charAt(0) != '-' && str.charAt(0) != '+' && (!Character.isDigit(str.charAt(0))))) {
            return 0;
        }
        long sign = str.charAt(0) == '-' ? -1 : 1;
        long ans = Character.isDigit(str.charAt(0)) ? str.charAt(0) - '0' : 0;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                ans = ans * 10 + c - '0';
            } else {
                break;
            }
            if (ans >= Integer.MAX_VALUE || ans <= Integer.MIN_VALUE) {//这里一定要注意，当在过程中超过了范围，就得break了，以为字符串可能很长，如果不中途break，可能即使用long都会溢出
                break;
            }
        }
        ans *= sign;
        if (ans > Integer.MAX_VALUE) {
            ans = Integer.MAX_VALUE;
        } else if (ans < Integer.MIN_VALUE) {
            ans = Integer.MIN_VALUE;
        }
        return (int) ans;
    }
}
