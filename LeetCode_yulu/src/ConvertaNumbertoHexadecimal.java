public class ConvertaNumbertoHexadecimal {
//  本题要格外注意补码取反，以及取反后加一可能存在进位的问题
//    方法二可采用位运算
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        long a = Math.abs((long)(num));
        while (a > 0 ) {
            int remainder = (int) (a % 16);
            switch (remainder) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    sb.append(remainder);
                    break;
                case 10:
                    sb.append('a');
                    break;
                case 11:
                    sb.append('b');
                    break;
                case 12:
                    sb.append('c');
                    break;
                case 13:
                    sb.append('d');
                    break;
                case 14:
                    sb.append('e');
                    break;
                case 15:
                    sb.append('f');
                    break;
            }
            a /= 16;
        }
        if (num < 0) {
            sb = complement(sb);
        }
        return sb.reverse().toString();
    }

    public StringBuilder complement(StringBuilder sb){
        for (int i = sb.length(); i < 8; i++) {
            sb.append(0);
        }
        StringBuilder complement = new StringBuilder();
        int increment = 1;
        for (int i = 0; i < sb.length(); i++) {
            char a = sb.charAt(i);
            switch (a) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    int digit = a - '0';
                    digit = 15 - digit + increment;
                    if (digit <= 9) {
                        complement.append(digit);
                    } else if (digit <= 15){
                        char c = (char) ('a' + (digit % 10));
                        complement.append(c);
                    } else {
                        complement.append(digit % 16);
                    }
                    increment = digit / 16;
                    break;
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                    int digit2 = 15 - (10 + a - 'a');
                    digit2 += increment;
                    complement.append(digit2);
                    increment = digit2 / 16;
                    break;
            }
        }
        return complement;
    }

    public String toHex2(int num) {
        StringBuilder sb = new StringBuilder();
        do {
            int bit = num & 15; // 这一步就是相当于 num % 16
            sb.append(bit < 10 ? (char) (bit + '0'): (char) ('a' + bit - 10)); //记住要类型转换
            num >>>= 4;  //这一步就相当于num / 16
        } while (num != 0); //用do while 是为了应对num等于0的情况
        return sb.reverse().toString();
    }

    public void test() {
        System.out.println(toHex2(26));
    }
}
