package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class _36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Integer> number;
        final int ROW_NUMBER = board.length;
        final int COL_NUMBER = board[0].length;

        number = new HashMap();
        for(int i = 0; i < ROW_NUMBER; i++) {
            number.clear();
            for(int j = 0; j < COL_NUMBER; j++) {
                if(number.containsKey(board[i][j]))
                    return false;
                else if(board[i][j] != '.')
                    number.put(board[i][j],0);
            }
        }

        for(int i = 0; i < COL_NUMBER; i++) {
            number.clear();
            for(int j = 0; j < ROW_NUMBER; j++) {
                if(number.containsKey(board[j][i]))
                    return false;
                else if(board[j][i] != '.')
                    number.put(board[j][i],0);
            }
        }

        for(int i = 0; i < COL_NUMBER; i+=3) {
            for(int j = 0; j < ROW_NUMBER; j+=3) {
                if(!isValidSudoku(board, i, j))
                    return false;
            }
        }

        return true;
    }

    private boolean isValidSudoku(char[][] board, int startRow, int startCol) {
        Map<Character, Integer> number;
        number = new HashMap();
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(number.containsKey(board[i][j]))
                    return false;
                else if(board[i][j] != '.')
                    number.put(board[i][j],0);
            }
        }
        return true;
    }
}
