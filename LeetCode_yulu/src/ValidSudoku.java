import java.util.HashSet;

public class ValidSudoku {
    //本题要注意如果9*9的二维数组里所有字符都是'.'，那应该也是返回true
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i <= 8; i++) {
            if (!isValid(board, 0, 8, i, i)) {
                return false;
            }
            if (!isValid(board, i, i, 0, 8)) {
                return false;
            }
        }
        for (int i = 0; i <= 8; i += 3) {
            for (int j = 0; j <= 8; j += 3) {
                if (!isValid(board, i, i + 2, j, j + 2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int columnstart, int columnend, int rowstart, int rowend) {
        HashSet<Character> set = new HashSet<>();
        for (int i = rowstart; i <= rowend; i++) {
            for (int j = columnstart; j <= columnend; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!set.add(c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if ((!seen.add(c + "row" + i)) || (!seen.add(c + "column" + j)) ||
                        (!seen.add(c + "in block" + i / 3 + "-" + j / 3))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void test() {
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));

    }

}
