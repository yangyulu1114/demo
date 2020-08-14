public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int absent = 0, late = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                absent++;
            } else if (c == 'L') {
                if (i > 0 && s.charAt(i - 1) == 'L') {
                    late++;
                } else {
                    late = 1;
                }
            }
            if (absent > 1 || late > 2) {
                return false;
            }
        }
        return true;
    }
}
