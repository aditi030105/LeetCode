import java.util.*;

class Solution {
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[] boxes = new int[9];
    List<int[]> empties = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    empties.add(new int[]{r, c});
                } else {
                    int num = board[r][c] - '0';
                    int mask = 1 << num;
                    int box = (r / 3) * 3 + (c / 3);
                    rows[r] |= mask;
                    cols[c] |= mask;
                    boxes[box] |= mask;
                }
            }
        }
        backtrack(board, 0);
    }

    private boolean backtrack(char[][] board, int idx) {
        if (idx == empties.size()) return true;

        int minIdx = idx, minCount = 10;
        for (int i = idx; i < empties.size(); i++) {
            int r = empties.get(i)[0];
            int c = empties.get(i)[1];
            int box = (r / 3) * 3 + (c / 3);
            int used = rows[r] | cols[c] | boxes[box];
            int candidates = 9 - Integer.bitCount(used);
            if (candidates < minCount) {
                minCount = candidates;
                minIdx = i;
                if (minCount == 1) break;
            }
        }
        Collections.swap(empties, idx, minIdx);

        int r = empties.get(idx)[0];
        int c = empties.get(idx)[1];
        int box = (r / 3) * 3 + (c / 3);
        int used = rows[r] | cols[c] | boxes[box];

        for (int num = 1; num <= 9; num++) {
            int mask = 1 << num;
            if ((used & mask) == 0) {
                board[r][c] = (char) (num + '0');
                rows[r] |= mask;
                cols[c] |= mask;
                boxes[box] |= mask;

                if (backtrack(board, idx + 1)) return true;

                board[r][c] = '.';
                rows[r] ^= mask;
                cols[c] ^= mask;
                boxes[box] ^= mask;
            }
        }
        return false;
    }
}