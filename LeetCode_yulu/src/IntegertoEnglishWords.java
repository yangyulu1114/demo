public class IntegertoEnglishWords {
    public String one(int num) {
        switch (num) {
            case 1 :
                return "One ";
            case 2 :
                return "Two ";
            case 3 :
                return "Three ";
            case 4 :
                return "Four ";
            case 5 :
                return "Five ";
            case 6 :
                return "Six ";
            case 7 :
                return "Seven ";
            case 8 :
                return "Eight ";
            case 9 :
                return "Nine ";
        }
        return "";
    }

    public String twoLessthanTwenty(int num) {
         switch (num) {
             case 10 :
                 return "Ten ";
             case 11 :
                 return "Eleven ";
             case 12 :
                 return "Twelve ";
             case 13 :
                 return "Thirteen ";
             case 14 :
                 return "Fourteen ";
             case 15 :
                 return "Fifteen ";
             case 16 :
                 return "Sixteen ";
             case 17 :
                 return "Seventeen ";
             case 18 :
                 return "Eighteen ";
             case 19 :
                 return "Nineteen ";
         }
         return "";
    }

    public String ten(int num) {
        switch (num) {
            case 2 :
                return "Twenty ";
            case 3 :
                return "Thirty ";
            case 4 :
                return "Forty ";
            case 5 :
                return "Fifty ";
            case 6 :
                return "Sixty ";
            case 7 :
                return "Seventy ";
            case 8 :
                return "Eighty ";
            case 9 :
                return "Ninety ";
        }
        return "";
    }

    public String two(int num) {
        if (num == 0) {
            return "";
        }
        int tens = num / 10;
        int ones = num % 10;
        if (tens == 0) {
            return one(ones);
        } else if (tens == 1) {
            return twoLessthanTwenty(num);
        } else {
            return ten(tens) + one(ones);
        }
    }

    public String three(int num) {
        if (num == 0) {
            return "";
        }
        int hundreds = num / 100;
        int rest = num % 100;
        if (hundreds == 0) {
            return two(rest);
        } else {
            return one(hundreds) + "Hundred " + two(rest);
        }
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int billion = num / 1000000000;
        int million = (num % 1000000000) / 1000000;
        int thousand = ((num % 1000000000) % 1000000) / 1000;
        int rest = ((num % 1000000000) % 1000000) % 1000;

        StringBuilder sb = new StringBuilder();
        if (billion != 0) {
            sb.append(three(billion)).append("Billion ");
        }
        if (million != 0) {
            sb.append(three(million)).append("Million ");
        }
        if (thousand != 0) {
            sb.append(three(thousand)).append("Thousand ");
        }
        if (rest != 0) {
            sb.append(three(rest));
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
    //本题要注意空格，还有注意为空的情况（即三个数字皆为0），例如edge case 0 , 1000010

    public void test() {
        System.out.println(numberToWords(12345));
    }
}
