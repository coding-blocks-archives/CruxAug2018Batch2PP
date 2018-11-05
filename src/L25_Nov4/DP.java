package L25_Nov4;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Nov-2018
 *
 */

public class DP {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		int n = 3;
		// System.out.println(fibTD(n, new int[n + 1]));
		// System.out.println(fibBU(n));
		// System.out.println(fibBUSE(n));

		// System.out.println(boardPathTD(0, n, new int[n + 1]));
		// System.out.println(boardPathBU(n));
		// System.out.println(boardPathBUSE(n));

		// System.out.println(mazePath(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(mazePathBU(n, n));
		// System.out.println(mazePathBUSE(n, n));
		// System.out.println(mazePathBUSEDiag(n, n));

		// System.out.println(LCSBU("abcdefghtgcdhjsvcduj", "agcfdgjhjsdgcyugeuht"));
		System.out.println(EditDistance("saturday", "sunday"));

		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static int fibTD(int n, int[] strg) {

		if (n == 0 || n == 1) {
			return n;
		}

		// use
		if (strg[n] != 0) {
			return strg[n];
		}

		int fnm1 = fibTD(n - 1, strg);
		int fnm2 = fibTD(n - 2, strg);

		int fn = fnm1 + fnm2;

		// store
		strg[n] = fn;

		return fn;

	}

	public static int fibBU(int n) {

		int[] strg = new int[n + 1];
		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	public static int fibBUSE(int n) {

		int[] strg = new int[2];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 1; i <= n - 1; i++) {

			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;

		}

		return strg[1];

	}

	public static int boardPathTD(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += boardPathTD(curr + dice, end, strg);
		}

		strg[curr] = count;

		return count;
	}

	public static int boardPathBU(int n) {

		int[] strg = new int[n + 6];
		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {

			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}

		return strg[0];

	}

	public static int boardPathBUSE(int n) {

		int[] strg = new int[6];
		strg[0] = 1;

		for (int slide = 1; slide <= n; slide++) {

			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];

			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];

			strg[0] = sum;

		}

		return strg[0];
	}

	public static int mazePath(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = mazePath(cr, cc + 1, er, ec, strg);
		int cv = mazePath(cr + 1, cc, er, ec, strg);

		strg[cr][cc] = ch + cv;

		return ch + cv;
	}

	public static int mazePathBU(int er, int ec) {

		// int[][] strg = new int[er + 1][ec + 1];
		//
		// for (int row = er; row >= 0; row--) {
		//
		// for (int col = ec; col >= 0; col--) {
		//
		// if (row == er || col == ec) {
		// strg[row][col] = 1;
		// } else {
		// strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
		// }
		// }
		// }

		int[][] strg = new int[er + 2][ec + 2];

		for (int row = er; row >= 0; row--) {

			for (int col = ec; col >= 0; col--) {

				if (row == er && col == ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
				}
			}
		}

		return strg[0][0];
	}

	public static int mazePathBUSE(int er, int ec) {

		int[] strg = new int[ec + 1];
		Arrays.fill(strg, 1);

		for (int slide = er - 1; slide >= 0; slide--) {

			for (int col = ec; col >= 0; col--) {

				if (col == ec) {
					strg[col] = 1;
				} else {
					strg[col] = strg[col] + strg[col + 1];
				}
			}
		}

		return strg[0];

	}

	public static int mazePathBUSEDiag(int er, int ec) {

		int[] strg = new int[ec + 1];
		Arrays.fill(strg, 1);

		int diag = 0;

		for (int slide = er - 1; slide >= 0; slide--) {

			for (int col = ec; col >= 0; col--) {

				if (col == ec) {
					strg[col] = 1;
					diag = 1;
				} else {
					int sum = strg[col] + strg[col + 1] + diag;
					diag = strg[col];
					strg[col] = sum;
				}
			}
		}

		return strg[0];

	}

	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);

		char ch2 = s2.charAt(0);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {
			ans = Math.max(LCS(ros1, s2), LCS(s1, ros2));
		}

		return ans;
	}

	public static int LCSBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {

			for (int col = s2.length() - 1; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
				} else {
					strg[row][col] = Math.max(strg[row + 1][col], strg[row][col + 1]);
				}
			}

		}

		return strg[0][0];

	}

	public static int EditDistance(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);

		char ch2 = s2.charAt(0);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);
		} else {

			int insert = EditDistance(ros1, s2);
			int delete = EditDistance(s1, ros2);
			int replace = EditDistance(ros1, ros2);

			ans = Math.min(replace, Math.min(insert, delete)) + 1;

		}

		return ans;

	}

	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {

			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
					continue;
				}

				if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
					continue;
				}

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {

					int insert = strg[row + 1][col];
					int delete = strg[row][col + 1];
					int replace = strg[row + 1][col + 1];

					strg[row][col] = Math.min(replace, Math.min(insert, delete)) + 1;

				}

			}
		}

		return strg[0][0];

	}

}
