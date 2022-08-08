public class Solution {

	public static boolean isItSudoku(int board[][]) {

		// Write your code here.
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            if (board[i][j] == 0) {

              for (int c = 1; c <= 9; c++) {
                if (isValid(board, i, j, c)) {
                  board[i][j] = c;

                  if (isItSudoku(board))
                    return true;
                  else
                    board[i][j] = 0;
                }
              }

              return false;
            }
          }
        }
        return true;
	}
    
    public static boolean isValid(int[][] board, int row, int col, int c) {
        for (int i = 0; i < 9; i++) {
          if (board[i][col] == c)
            return false;

          if (board[row][i] == c)
            return false;

          if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
            return false;
        }
        return true;
    }
}
