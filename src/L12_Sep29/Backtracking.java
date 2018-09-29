package L12_Sep29;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Sep-2018
 *
 */

public class Backtracking {

	public static void main(String[] args) {

//		int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
//
//		boolean[][] visited = new boolean[maze.length][maze[0].length];
//		blockedMaze(maze, 0, 0, "", visited);

		NQueens(new boolean[4][4], 0, "");
	}

	public static void blockedMaze(int[][] maze, int cr, int cc, String ans, boolean[][] visited) {

		if (cr == maze.length - 1 && cc == maze[0].length - 1) {
			System.out.println(ans);
			return;
		}

		if (cr == maze.length || cc == maze[0].length || cr < 0 || cc < 0 || maze[cr][cc] == 1 || visited[cr][cc]) {
			return;
		}

		visited[cr][cc] = true;

		// dtlr
		blockedMaze(maze, cr + 1, cc, ans + "D", visited);
		blockedMaze(maze, cr - 1, cc, ans + "T", visited);
		blockedMaze(maze, cr, cc - 1, ans + "L", visited);
		blockedMaze(maze, cr, cc + 1, ans + "R", visited);

		visited[cr][cc] = false;

	}

	public static void NQueens(boolean[][] board, int row, String ans) {

		if (row == board.length) {
			System.out.println(ans);
			return;
		}

		for (int col = 0; col < board[0].length; col++) {

			if (isItSafeToPlaceQueen(row, col, board)) {
				board[row][col] = true;
				NQueens(board, row + 1, ans + "[" + row + "-" + col + "]");
				board[row][col] = false;
			}

		}

	}

	public static boolean isItSafeToPlaceQueen(int row, int col, boolean[][] board) {

		int r = row - 1;
		int c = col;

		// vertically up
		while (r >= 0) {

			if (board[r][c]) {
				return false;
			}
			r--;

		}

		// diagonally left
		r = row - 1;
		c = col - 1;

		while (c >= 0 && r >= 0) {

			if (board[r][c]) {
				return false;
			}
			r--;
			c--;

		}

		// diagonally right
		r = row - 1;
		c = col + 1;

		while (c < board[0].length && r >= 0) {

			if (board[r][c]) {
				return false;
			}

			r--;
			c++;

		}

		return true;

	}

}
