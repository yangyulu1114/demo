import javafx.scene.SnapshotParametersBuilder;

//这题坑居多，有很多地方需要注意,还有些其它方法可以再看一下
public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (isValidIPV4(IP)) {
            return "IPv4";
        } else if (isValidIPV6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    public boolean isValidIPV4(String IP) {
        String[] s = IP.split("\\.");  //注意转义
        int len = s.length;
        if (len != 4 || IP.charAt(IP.length() - 1) == '.') {  //要注意使用split函数时有些case："1.1.1.1."最后一个字符为分隔符的不会分成5个单元格，只会分出4个
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (s[i].isEmpty() || s[i].length() > 3 || (!isNumeric(s[i]))) {  //要注意如果字符串为空，或者很长，或者不为数字，下面的Integer.valueOf(s[i])都没法解析，所以要提前判断
                return false;
            }
            int num = Integer.valueOf(s[i]);
            if (num < 0 || num > 255 || (s[i].length() > 1 && s[i].charAt(0) == '0')) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidIPV6(String IP) {
        IP = IP.toUpperCase();
        String[] s = IP.split(":");
        int len = s.length;
        if (len != 8 || IP.charAt(IP.length() - 1) == ':') {  //要注意使用split函数时有些case：""2001:0db8:85a3:0:0:8A2E:0370:7334:""最后一个字符为分隔符的不会分成9个单元格，只会分出8个
            return false;
        }
        for (int i = 0; i < 8; i++) {
            if (s[i].isEmpty() || s[i].length() > 4 ||(!isValide16(s[i]))) { //要注意如果字符串为空，或者很长，或者不符合16进制要求，下面的Integer.parseInt都没法解析，所以要提前判断
                return false;
            }
            int num = Integer.parseInt(s[i], 16);//注意这里是要用16进制的转换方式，不能再用valuseof了
            if (num < 0 || num >= Math.pow(2, 16)) {
                return false;
            }
        }
        return true;
    }

    public boolean isNumeric(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isValide16(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((!Character.isLetterOrDigit(c)) || (Character.isLetter(c) && (c < 'A' || c > 'F'))) {
                return false;
            }
        }
        return true;
    }

    public void test() {
        System.out.println(validIPAddress("20EE:Fb8:85a3:0:0:8A2E:0370:7334"));
    }
}
