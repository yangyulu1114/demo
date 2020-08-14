public class NumberofLinesToWriteString {
    //这题要注意如果该行不足以放下后一个字母，也得从新开一行来放
    public int[] numberOfLines(int[] widths, String S) {
        if (S.length() == 0) {
            return new int[2];
        }
        int line = 1, units = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            units += widths[c - 'a'];
            if (units > 100) {
                line += 1;
                units = widths[c - 'a'];
            }
        }
        return new int[]{line, units};
    }
}
