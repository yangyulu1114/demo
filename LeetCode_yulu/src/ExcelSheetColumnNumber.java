public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'A' + 1;
            number = number * 26 + a;
        }
        return number;
    }

    public void test() {
        System.out.println(titleToNumber("AB"));
    }
}
